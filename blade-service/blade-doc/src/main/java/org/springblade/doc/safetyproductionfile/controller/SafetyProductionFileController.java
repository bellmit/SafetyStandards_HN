/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.doc.safetyproductionfile.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.deepoove.poi.data.PictureRenderData;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.common.tool.CommonUtil;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.biaozhunhuamuban.entity.FileParse;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO;
import org.springblade.doc.safetyproductionfile.entity.SafetyProductionFile;
import org.springblade.doc.safetyproductionfile.service.ISafetyProductionFileService;
import org.springblade.doc.safetyproductionfile.vo.SafetyProductionFileVO;
import org.springblade.system.feign.IDictClient;
import org.springblade.system.feign.ISysClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import springfox.documentation.annotations.ApiIgnore;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  控制器
 *
 * @author Blade
 * @since 2019-05-28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doc/SafetyProductionFile")
@Api(value = "安全生产文档", tags = "安全生产文档")
public class SafetyProductionFileController extends BladeController {

	private ISafetyProductionFileService safetyProductionFileService;

	private IDictClient dictClient;

	private FileParse fileParse;

	private ISysClient iSysClient;



	/**
	 *添加目录
	 * @author: hyp
	 * @date: 2019/5/30 13:50
	 * @param id
	 * @param fileName
	 * @param user
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.SafetyProductionFileVO>
	 */
	@PostMapping("/addDir")
	@ApiLog("安全生产文档-新增-文件夹")
	@ApiOperation(value = "新增-文件夹", notes = "传入本节点id，新增目录名称", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "需要新增下级节点的id", required = true),
		@ApiImplicitParam(name = "fileName", value = "新增文件夹的名称", required = true),
		@ApiImplicitParam(name = "documentNumber", value = "文档编号", required = true)
	})
	public R<SafetyProductionFileVO> addDir(@RequestParam(name="id",required=true)Integer id, String fileName,String documentNumber, BladeUser user) {
		SafetyProductionFile parent = safetyProductionFileService.getById(id);
		String msg = "新增成功";
		if(user==null){
			msg = "新增失败，user信息为null";
			return R.fail(msg);
		}
		if(FileUtil.isDirectory(fileParse.getPath(parent.getPath()))){
			//生成文件夹
			FileUtil.mkdir(fileParse.getPath(parent.getPath())+File.separator+fileName);
		}else{
			msg = "新增失败，该节点不是目录或不存在";
			return R.fail(msg);
		}
		//查询最大id
		Integer newId = safetyProductionFileService.selectMaxId()+1;
		//查询下级最大sort
		Integer newSort = safetyProductionFileService.selectMaxSorByParentId(id)+1;
		parent.setParentId(id);
		parent.setId(newId);
		parent.setPath(parent.getPath()+ File.separator+fileName);
		parent.setCaozuoren(user.getUserName());
		parent.setCaozuorenid(user.getUserId());
		parent.setCaozuoshijian(DateUtil.now());
		parent.setTier(parent.getTier()+"-"+newId);
		parent.setName(fileName);
		parent.setSort(newSort);
		parent.setDocumentNumber(documentNumber);
		safetyProductionFileService.save(parent);
		SafetyProductionFileVO vo = new SafetyProductionFileVO();
		BeanUtil.copyProperties(parent,vo);
		vo.setFileNum(0);

		return R.data(vo,msg);
	}







	/**
	 *添加文件
	 * @author: hyp
	 * @date: 2019/5/30 13:50
	 * @param id
	 * @param file
	 * @param user
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.SafetyProductionFileVO>
	 */
	@PostMapping("/addFile")
	@ApiLog("安全生产文档-新增-文件")
	@ApiOperation(value = "新增-文件", notes = "传入本节点id，文件", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "需要新增下级节点的id", required = true),
		@ApiImplicitParam(name = "file", value = "新增的文件", required = true),
		@ApiImplicitParam(name = "documentNumber", value = "文档编号", required = true)
	})
	public R<SafetyProductionFileVO> addFile(Integer id, MultipartFile file,String documentNumber, BladeUser user) {
		SafetyProductionFile parent = safetyProductionFileService.getById(id);
		String msg = "新增成功";
		if(user==null){
			msg = "新增失败，user信息为null";
			return R.fail(msg);
		}
		//如果当前路径是目录
		if("文件夹".equals(parent.getType())){
			//获取文件名称
			String fileName = file.getOriginalFilename();
			List<SafetyProductionFile> byParentId = safetyProductionFileService.getByParentId(id);
			for (int i = 0; i < byParentId.size(); i++) {
				if(fileName.equals(byParentId.get(i).getName())){
					return R.fail("已存在相同文件名称");
				}
			}
			//获得文件物理路径
			String filePath = fileParse.getPath(parent.getPath())+File.separator+fileName;

			try {
				FileUtil.mkParentDirs(filePath);
				//存入本地
				file.transferTo(FileUtil.file(filePath));
				//获取后缀名
				String expandedName =file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
				//如果是doc文件则转换为docx
				if(".doc".equals(expandedName)){
					CommonUtil.convertDocFmt(filePath, StrUtil.replace(filePath,".doc",".docx"),CommonUtil.DOCX_FMT);
					//删除源文件
					FileUtil.del(filePath);
					//得到新的文件名与文件路径
					filePath = StrUtil.replace(filePath,".doc",".docx");
					fileName = StrUtil.replace(fileName,".doc",".docx");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			//查询最大id
			Integer newId = safetyProductionFileService.selectMaxId()+1;
			//查询下级最大sort
			Integer newSort = safetyProductionFileService.selectMaxSorByParentId(id)+1;
			parent.setParentId(id);
			parent.setId(newId);
			parent.setPath(fileParse.getInsertPath(filePath));
			parent.setCaozuoren(user.getUserName());
			parent.setCaozuorenid(user.getUserId());
			parent.setCaozuoshijian(DateUtil.now());
			parent.setTier(parent.getTier()+"-"+newId);
			parent.setName(fileName);
			parent.setSort(newSort);
			parent.setType("文件");
			parent.setDocumentNumber(documentNumber);
			parent.setIsEdit(1);
			boolean save = safetyProductionFileService.save(parent);
			//保存成功，生成对应的pdf，图片
			if(save){
				fileParse.creatFormalFile(parent);
			}
		}else{
			msg = "新增失败，该节点不是目录或不存在";
			return R.fail(msg);
		}

		SafetyProductionFileVO vo = new SafetyProductionFileVO();
		BeanUtil.copyProperties(parent,vo);
		vo.setFileNum(0);
		return R.data(vo,msg);
	}




	@PostMapping("/addImages")
	@ApiLog("安全生产文档-新增-图片文档")
	@ApiOperation(value = "新增-图片文档", notes = "传入本节点id，文件", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "需要新增下级节点的id", required = true),
		@ApiImplicitParam(name = "files", value = "新增的图片们", required = true),
		@ApiImplicitParam(name = "documentName", value = "文档名称", required = true),
		@ApiImplicitParam(name = "documentNumber", value = "文档编号", required = true)
	})
	public R<SafetyProductionFileVO> addFile(Integer id, MultipartFile[] files, String documentName, String documentNumber, BladeUser user) throws IOException {
		SafetyProductionFile parent = safetyProductionFileService.getById(id);

		String msg = "新增成功";
		if(user==null){
			msg = "新增失败，user信息为null";
			return R.fail(msg);
		}
		//如果当前路径是目录
		if(files.length>10){
			return R.fail("图片数量超出限制,最大10张图片");
		}
		if("文件夹".equals(parent.getType())){
			List<SafetyProductionFile> byParentId = safetyProductionFileService.getByParentId(id);
			for (int i = 0; i < byParentId.size(); i++) {
				if(documentName.equals(byParentId.get(i).getName())){
					return R.fail("已存在相同文件名称");
				}
			}
			int i = 0;
			Map<String,PictureRenderData> map = new HashMap<String,PictureRenderData>();
			for (MultipartFile file : files) {
				//获取文件名称
				String contentType = file.getContentType();
				if(!contentType.contains("image/")){
					return R.fail("上传类型不符,只能上传图片类型");
				}
				InputStream inputStream = file.getInputStream();
				BufferedImage sourceImg= ImageIO.read(inputStream);
				int width = sourceImg.getWidth()/2;
				int height = sourceImg.getHeight()/2;
				if(sourceImg.getWidth()/2>600){
					int bili = sourceImg.getWidth()/600;
					width = 600;
					height = sourceImg.getHeight()/bili;
				}
				PictureRenderData pictureRenderData = new PictureRenderData(width, height, ".png",file.getBytes());
				map.put("image"+i++,pictureRenderData);

			}
			//获得文件物理路径
			String filePath = fileParse.getPath(parent.getPath())+File.separator+documentName+".docx";
			//查询最大id
			Integer newId = safetyProductionFileService.selectMaxId()+1;
			//查询下级最大sort
			Integer newSort = safetyProductionFileService.selectMaxSorByParentId(id)+1;
			parent.setParentId(id);
			parent.setId(newId);
			parent.setPath(fileParse.getInsertPath(filePath));
			parent.setCaozuoren(user.getUserName());
			parent.setCaozuorenid(user.getUserId());
			parent.setCaozuoshijian(DateUtil.now());
			parent.setTier(parent.getTier()+"-"+newId);
			parent.setName(documentName+".docx");
			parent.setSort(newSort);
			parent.setType("文件");
			parent.setDocumentNumber(documentNumber);
			parent.setIsEdit(1);
			boolean save = safetyProductionFileService.save(parent);
//			//保存成功，生成对应的pdf，图片
			if(save){
				fileParse.creatFormalImageFile(map,parent);
			}
		}else{
			msg = "新增失败，该节点不是目录或不存在";
			return R.fail(msg);
		}
//
		SafetyProductionFileVO vo = new SafetyProductionFileVO();
		BeanUtil.copyProperties(parent,vo);
		vo.setFileNum(0);
		return R.data(vo,"上传成功");
	}



	/**
	 *文件替换
	 * @author: hyp
	 * @date: 2019/5/30 13:50
	 * @param id
	 * @param file
	 * @param user
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.SafetyProductionFileVO>
	 */
	@PostMapping("/replaceFile")
	@ApiLog("安全生产文档-替换-文件")
	@ApiOperation(value = "替换-文件", notes = "传入本节点id，文件", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "需要被替换节点的id", required = true),
		@ApiImplicitParam(name = "file", value = "替换的文件", required = true)
	})
	public R<SafetyProductionFileVO> replaceFile(Integer id,MultipartFile file,BladeUser user) {
		SafetyProductionFile wenjian = safetyProductionFileService.getById(id);
		String newPath = wenjian.getPath().replaceFirst(wenjian.getName(),file.getOriginalFilename());
		String newName = file.getOriginalFilename();
		String msg = "替换成功";
		if(user==null){
			msg = "替换失败，user信息为null";
			return R.fail(msg);
		}
		//如果当前路径存在
		if(FileUtil.exist(fileParse.getPath(wenjian.getPath()))){
			//删除源企业模板文件
			FileUtil.del(fileParse.getPath(wenjian.getPath()));
			//删除正式文件，pdf，图片
			FileUtil.del(StrUtil.replace(StrUtil.replace(fileParse.getPath(wenjian.getPath()), FilePathConstant.SPF_PATH,FilePathConstant.SPF_PDF_PATH),".docx",".pdf"));
			FileUtil.del(StrUtil.replace(StrUtil.replace(fileParse.getPath(wenjian.getPath()), FilePathConstant.SPF_PATH,FilePathConstant.SPF_IMG_PATH),".docx",""));

		}

		try {
			FileUtil.mkParentDirs(fileParse.getPath(newPath));
			file.transferTo(FileUtil.file(fileParse.getPath(newPath)));
			//获取后缀名
			String expandedName =file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
			//如果是doc文件则转换为docx
			if(".doc".equals(expandedName)){
				CommonUtil.convertDocFmt(fileParse.getPath(newPath), StrUtil.replace(fileParse.getPath(newPath),".doc",".docx"),CommonUtil.DOCX_FMT);
				//删除源文件
				FileUtil.del(fileParse.getPath(newPath));
				newPath = StrUtil.replace(newPath,".doc",".docx");
				newName = StrUtil.replace(newName,".doc",".docx");
			}
		} catch (IOException e) {
			e.printStackTrace();
			msg="替换失败";
			return R.fail(msg);
		} catch (Exception e) {
			msg="docx转换失败";
			e.printStackTrace();
			return R.fail(msg);
		}

		wenjian.setPath(newPath);
		wenjian.setCaozuoren(user.getUserName());
		wenjian.setCaozuorenid(user.getUserId());
		wenjian.setCaozuoshijian(DateUtil.now());
		wenjian.setName(newName);
		wenjian.setIsEdit(1);
		boolean updateById = safetyProductionFileService.updateById(wenjian);

		//替换成功，生成对应的正式文件，pdf，图片
		if(updateById){
			fileParse.creatFormalFile(wenjian);
		}
		SafetyProductionFileVO vo = new SafetyProductionFileVO();
		BeanUtil.copyProperties(wenjian,vo);
		vo.setFileNum(0);
		return R.data(vo,msg);
	}

	/**
	 *删除节点
	 * @author: hyp
	 * @date: 2019/5/30 13:51
	 * @param id
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("/del")
	@ApiLog("安全生产文档-删除-节点")
	@ApiOperation(value = "删除-节点", notes = "id", position = 3)
	public R del(@ApiParam(value = "主键", required = true) @RequestParam Integer id) {
		//查询下级节点
		List<SafetyProductionFile> list = safetyProductionFileService.getByParentId(id);
		String msg="删除成功";
		//如果有下级节点,不允许删除
		if(list!=null && list.size()>0){
			msg = "该节点下存在子节点,不允许直接删除";
		}else{
			SafetyProductionFile wenjian = safetyProductionFileService.getById(id);
			if(FileUtil.exist(fileParse.getPath(wenjian.getPath()))){
				FileUtil.del(fileParse.getPath(wenjian.getPath()));
				//如果是文件类型，就继续pdf，图片
				FileUtil.del(StrUtil.replace(StrUtil.replace(fileParse.getPath(wenjian.getPath()), FilePathConstant.SPF_PATH,FilePathConstant.SPF_PDF_PATH),".docx",".pdf"));
				FileUtil.del(StrUtil.replace(StrUtil.replace(fileParse.getPath(wenjian.getPath()), FilePathConstant.SPF_PATH,FilePathConstant.SPF_IMG_PATH),".docx",""));
			}

			safetyProductionFileService.removeById(id);

		}
		return R.success(msg);
	}



	/**
	 *目录树
	 * @author: hyp
	 * @date: 2019/5/30 13:51
	 * @param deptId
	 * @param parentId
	 * @return: org.springblade.core.tool.api.R<java.util.List<org.springblade.anbiao.SafetyProductionFileVO>>
	 */
	@GetMapping("/tree")
	@ApiLog("安全生产文档-获取-目录树")
	@ApiOperation(value = "获取-目录树", notes = "传入deptId", position = 1)
	@ApiImplicitParams({ @ApiImplicitParam(name = "parentId", value = "上级id", required = false),
		@ApiImplicitParam(name = "deptId", value = "单位id", required = true)
	})
	public R<List<SafetyProductionFileVO>> tree(@RequestParam Integer deptId,@RequestParam(required = true,defaultValue="0")  Integer parentId) {
		List<SafetyProductionFileVO> list= safetyProductionFileService.tree(deptId,parentId);
		return R.data(list);
	}

	@GetMapping("/bindTree")
	@ApiLog("安全生产文档-获取-绑定树")
	@ApiOperation(value = "获取-绑定树", notes = "传入deptId", position = 1)
	@ApiImplicitParams({ @ApiImplicitParam(name = "parentId", value = "上级id", required = false),
			@ApiImplicitParam(name = "deptId", value = "单位id", required = true),
			@ApiImplicitParam(name = "biaozhunhuamubanId", value = "标准化文件目录id", required = true)
	})
	public R<List<SafetyProductionFileVO>> bindTree(@RequestParam Integer deptId,@RequestParam(required = true,defaultValue="0")  Integer parentId,@RequestParam Integer biaozhunhuamubanId) {
		List<SafetyProductionFileVO> list= safetyProductionFileService.bindTree(deptId,parentId,biaozhunhuamubanId);
		return R.data(list);
	}


	@GetMapping("/boxTree")
	@ApiLog("安全生产文档-获取-盒子树")
	@ApiOperation(value = "获取-盒子树", notes = "传入deptId,获取该单位ABCD文档的前二级目录", position = 1)
	@ApiImplicitParam(name = "deptId", value = "单位id", required = true)
	public R<List<SafetyProductionFileVO>> boxTree(@RequestParam Integer deptId) {
		List<SafetyProductionFileVO> list= safetyProductionFileService.boxTree(deptId);
		return R.data(list);
	}



	/**
	 *图片预览
	 * @author: hyp
	 * @date: 2019/5/30 13:51
	 * @param id
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.SafetyProductionFileVO>
	 */
	@PostMapping("/imgPreview")
	@ApiLog("安全生产文档-预览-文件")
	@ApiOperation(value = "预览-文件", notes = "传入id", position = 9)
	public R<SafetyProductionFileVO> imgPreview(@ApiParam(value = "id", required = true)@RequestParam Integer id){
		SafetyProductionFile byId = safetyProductionFileService.getById(id);
		if(byId==null){
			return R.fail("该文件不存在对应的预览图片资源");
		}
		List<String> list = new ArrayList<String>();
		String path = byId.getPath();
		if(byId.getIsEdit()==0){
			path = byId.getMubanPath();
		}
		String pic = StrUtil.replace(StrUtil.replace(fileParse.getPath(path),FilePathConstant.SPF_PATH,FilePathConstant.SPF_IMG_PATH),".docx","");
		System.out.println(pic);
		File file = new File(pic);
		File[] files=file.listFiles();
		for(int i = 0; i < files.length; i++){
			if (files[i].isFile()) {
				try{
					//String base64 = CommonUtil.encodeBase64File(files[i].getAbsolutePath());
					//list.add(base64);
					list.add(fileParse.pathToUrl(files[i].getPath()));
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		SafetyProductionFileVO vo = new  SafetyProductionFileVO();
		BeanUtil.copyProperties(byId,vo);
		vo.setImgList(list);
		int i  = safetyProductionFileService.updatePreviewRecordById(id);
		return R.data(vo);
	}



	/**
	 *下载文件
	 * @author: hyp
	 * @date: 2019/5/30 17:18
	 * @param response
	 * @param id
	 * @return: org.springblade.core.tool.api.R<java.lang.String>
	 */
	@GetMapping("downloadFile")
	@ApiLog("安全生产文档-下载-文件")
	@ApiOperation(value = "下载-文件", notes = "根据id下载企业文件", position = 1)
	@ApiImplicitParam(name = "id", value = "id", required = true)
	public R<String> downloadSubtemplateFile(HttpServletResponse response, @RequestParam Integer id){
		SafetyProductionFile byId = safetyProductionFileService.getById(id);
		if(byId==null){
			R.fail("不存在该文件");
		}
		String path = byId.getPath();
		if(byId.getIsEdit()==0){
			path = byId.getMubanPath();
		}
		return R.data(fileParse.insertPathToUrl(path));
	}


	@GetMapping("/updateDocumentNumber")
	@ApiLog("安全生产文档-修改-编号")
	@ApiOperation(value = "修改-编号", notes = "根据id修改文档的编号", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "documentNumber", value = "文档编号", required = true),
		@ApiImplicitParam(name = "id", value = "id", required = true)
	})
	public R updateDocumentNumber(@RequestParam Integer id,@RequestParam  String documentNumber) {
		boolean a= safetyProductionFileService.updateDocumentNumberById(id,documentNumber);
//		SafetyProductionFile byId = SafetyProductionFileService.getById(id);
//		SafetyProductionFileVO vo = new SafetyProductionFileVO();
//		BeanUtil.copyProperties(byId,vo);

		return R.success("修改文档编号成功");
	}



	@GetMapping("/swapFileSort")
	@ApiLog("安全生产文档-移动-节点")
	@ApiOperation(value = "移动-节点", notes = "根据模板文件id实现两文件排序号对调,实现文件排序上下移动", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "originId", value = "源文件id", required = true),
		@ApiImplicitParam(name = "targetId", value = "目标文件id", required = true)
	})
	public R swapFileSort(@RequestParam Integer originId,@RequestParam  Integer targetId) {
		SafetyProductionFile origin = safetyProductionFileService.getById(originId);
		SafetyProductionFile target = safetyProductionFileService.getById(targetId);
		boolean a = safetyProductionFileService.updateSortById(originId,target.getSort());
		boolean b = safetyProductionFileService.updateSortById(targetId,origin.getSort());
		return R.success("移动成功");
	}



	@PostMapping("/aKeyGeneration")
	@ApiLog("ABCD文档-一键生成")
	@ApiOperation(value = "ABCD文档-一键生成", notes = "传入单位id", position = 8)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deptId", value = "机构id", required = true),
		@ApiImplicitParam(name = "isOnlyDir", value = "是否只生成目录(0否1是)", required = false),
		@ApiImplicitParam(name = "caozuoren", value = "操作时间", required = false),
		@ApiImplicitParam(name = "caozuorenid", value = "操作人id", required = false)
	})
	public R aKeyGeneration(Integer deptId,Integer isOnlyDir,String caozuoren,Integer caozuorenid){
		// TODO: 2019/9/3 非线程安全，改成多例模式或者用消息队列
		List<Integer> deptIds = iSysClient.getDetpIds(deptId);
//		List<Integer> deptIds = new ArrayList<>();
//		deptIds.add(5263);
		List<SafetyProductionFileVO> mubanList = safetyProductionFileService.getMubanTree(isOnlyDir);
		for (Integer id : deptIds) {
			int i = safetyProductionFileService.getCountByDetpId(id);
			//如果改机构已有文件，则跳过
			if(i>0){
				return R.success("该机构已有文件");
			}
			String deptName = iSysClient.getDeptName(id);
//			String deptName = "宿州市双泽运输有限公司";
			int maxId = safetyProductionFileService.selectMaxId()+1;
			fileParse.setId(maxId);
			fileParse.setDeptName(deptName);
			fileParse.setDeptId(id);

			fileParse.parseAbcdMubanList(mubanList,FilePathConstant.DEFAULT_PARENT_ID,FilePathConstant.DEFAULT_TIER);
			List<SafetyProductionFile> list = fileParse.getAbcdList();
			fileParse.close();
			list.get(i).setCaozuoren(caozuoren);
			list.get(i).setCaozuorenid(caozuorenid);
			String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			list.get(i).setCaozuoshijian(formatStr2);
			safetyProductionFileService.saveBatch(list);
		}

		return R.success("一键生成成功");
	}
}
