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
package org.springblade.doc.biaozhunhuamuban.controller;

import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.biaozhunhuamuban.entity.FileParse;
import org.springblade.doc.biaozhunhuamuban.entity.Template;
import org.springblade.doc.biaozhunhuamuban.page.BiaozhunhuamubanPage;
import org.springblade.doc.biaozhunhuamuban.service.IBiaozhunhuamubanService;
import org.springblade.doc.biaozhunhuamuban.service.IBiaozhunhuawenjianService;
import org.springblade.doc.biaozhunhuamuban.service.ITemplateService;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuawenjianVO;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.common.configurationBean.FileServer;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.common.tool.CommonUtil;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.BeanUtil;

import org.springblade.doc.safetyproductionfile.entity.SafetyProductionFile;
import org.springblade.doc.safetyproductionfile.to.SafetyProductionFileTO;
import org.springblade.doc.safetyproductionfile.service.ISafetyProductionFileService;
import org.springblade.system.entity.Dept;
import org.springblade.system.feign.ISysClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 控制器
 *
 * @author th
 * @since 2019-05-04
 */
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/doc/biaozhunhuamuban")
@Api(value = "安全标准化文件", tags = "安全标准化文件")
public class BiaozhunhuamubanController extends BladeController  {

	private IBiaozhunhuamubanService biaozhunhuamubanService;
	private ISafetyProductionFileService safetyProductionFileService;

	private ITemplateService templateService;

	private IBiaozhunhuawenjianService iBiaozhunhuawenjianService;

	private FileParse fileParse;

	private ISysClient iSysClient;

	private FileServer fileServer;


	//public static void main(String[] args) {
		//CommonUtil.world2pdf("L:\\SafetyStandards\\标准化相关文件\\子模板文件\\新宝液化\\03-ZD02-001安全生产责任制考核记录.doc","L:\\SafetyStandards\\标准化相关文件\\pdf文件\\新宝液化\\03-ZD02-001安全生产责任制考核记录.pdf");
		//CommonUtil.pdf2Image2("L:\\SafetyStandards\\03-ZD02-001安全生产责任制考核记录.pdf",
			//"L:\\SafetyStandards",300,0);
		//String s="L:\\SafetyStandards\\标准化相关文件\\子模板文件\\新宝液化\\16-绩效考评与持续改进\\16.2持续改进\\16-ZD02-002 部门绩效考核表记录.doc";
		//String replace = StrUtil.replace(s, FilePathConstant.SUBTEMPLATE_PATH, FilePathConstant.SUBTEMPLATE_PDF_PATH);
		//System.out.println(replace);
		//CommonUtil.pdf2Image("L:\\SafetyStandards\\03-ZD02-001安全生产责任制考核记录.pdf","L:\\SafetyStandards",100,0);
		//FileUtil.mkdir("L:\\SafetyStandards\\123\\aa.doc");
	//}

/*	public static void main(String[] args) {
		fileParse f = new fileParse();
		f.parseFile(new File("L:\\SafetyStandards\\标准化相关文件\\子模板文件\\新宝液化"),FilePathConstant.DEFAULT_PARENT_ID ,FilePathConstant.DEFAULT_TIER);
		List<Biaozhunhuamuban> list = f.getList();
		for(Biaozhunhuamuban b:list){
			log.info(b.getSort()+":"+b.getId()+":"+b.getName());
		}
	}*/

	/**
	 *企业上传标准化文件模板（会先同步到母模板）
	 * @author: th
	 * @CreateDate: 2019-05-08 10:40
	 * @param file 文件
	 * @param template 模板信息
	 * @param user
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("/uploadSubtemplateZip")
	@ApiIgnore()
	@ApiLog("安全标准化文件-上传-zip模板文件")
	@ApiOperation(value = "上传-zip模板文件", notes = "传入file,template,user", position = 1)
	public R uploadSubtemplateZip(MultipartFile file, Template template, BladeUser user) throws IOException {
		// TODO: 2019/9/3 非线程安全
//		if(user==null){
//			return  R.fail("user信息为空");
//		}
		Long start = System.currentTimeMillis();
		//临时存放路径
		String zipPath = fileServer.getPathPrefix()+FilePathConstant.UPLOAD_TEMP_PATH+template.getTemplateName();
		//解压到母模板路径
		String unzipPath = fileServer.getPathPrefix()+FilePathConstant.TEMPLATE_PATH+template.getTemplateName();
		//企业模板文件路径
		String deptFilePath = fileServer.getPathPrefix()+FilePathConstant.SUBTEMPLATE_PATH+template.getTemplateName();
		if(!FileUtil.exist(zipPath)){
			FileUtil.mkdir(zipPath);
		}
		if(!FileUtil.exist(unzipPath)){
			FileUtil.mkdir(unzipPath);
		}
		if(!FileUtil.exist(deptFilePath)){
			FileUtil.mkdir(deptFilePath);
		}

		File targetFile = new File(zipPath+File.separator+file.getOriginalFilename());

		//zip写入到临时文件
		System.out.println("正在讲zip写入临时文件夹");
		file.transferTo(targetFile);
		System.out.println("zip写入临时文件夹完成");

		//解压到母模板文件
		System.out.println("正在解压zip到母模板文件夹");
		ZipUtil.unzip(zipPath+File.separator+file.getOriginalFilename(),unzipPath, Charset.forName("GBK"));
		System.out.println("解压zip到母模板文件夹完成");
		//存入母模板信息到anbiao_template
		System.out.println("母模板信息入库中");
//		template.setTemplatePath(unzipPath);
//		template.setCaozuoren(user.getUserName());
//		template.setCaozuorenid(user.getUserId());
//		template.setCaozuoshijian(DateUtil.now());
//		template.setCreatetime(DateUtil.now());
//		templateService.save(template);
		System.out.println("母模板信息入库完成");

		//解压到企业模板文件
		System.out.println("解压到企业模板文件");
		File deptFile=ZipUtil.unzip(zipPath+File.separator+file.getOriginalFilename(),deptFilePath, Charset.forName("GBK"));
		System.out.println("解压到企业模板文件完成");

		//删除临时保存的zip文件
		System.out.println("删除临时文件");
		FileUtil.del(zipPath+File.separator+file.getOriginalFilename());
		System.out.println("删除临时文件完成");

		Integer maxId = biaozhunhuamubanService.selectMaxId();
		if(maxId==null){
			maxId=1;
		}else{
			maxId++;
		}

		//设置存入id
		fileParse.setId(maxId);
		//设置单位id
		fileParse.setDeptId(template.getDeptId());

		//解析路径存取到anbiao_biaozhunhuamuban
		System.out.println("递归解析文件路径信息");
		fileParse.parseFile(deptFile,FilePathConstant.DEFAULT_PARENT_ID ,FilePathConstant.DEFAULT_TIER);
		System.out.println("递归解析文件路径信息完成");
		List<Biaozhunhuamuban> list = fileParse.getList();
		//控制台输出
		for(Biaozhunhuamuban b:list){
			log.info(b.getSort()+":"+b.getId()+":"+b.getName());
		}

		//将模板中的doc转换为docx
		try {
			//重新获取转换后的list
			System.out.println("模板文件doc转docx");
			list =fileParse.convertDocx(list);
			System.out.println("模板文件doc转docx完成");
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail("模板文件docx转换异常");
		}
		//保存模板路径到数据库
		System.out.println("企业模板文件入库");
		boolean b =biaozhunhuamubanService.saveBatch(list);
		System.out.println("企业模板文件入库完成");

		//保存成功,则生成正式文件
		if(b){
			fileParse.creatFormalFile(list,template.getDeptName());
		}
		Long end = System.currentTimeMillis();
		//文件递归解析到数据存取耗时
		System.out.println(DateUtil.formatBetween(end-start));

		fileParse.close();
		return R.status(true);
	}


	/*@PostMapping("/upload")
	@ApiOperation(value = "上传", notes = "传入file", position = 1)
	public R upload(  MultipartFile file) throws IOException {

		File targetFile = new File("D:\\新宝液化\\"+file.getOriginalFilename());
		file.transferTo(targetFile);
		return R.status(true);
	}*/


	/*@PostMapping("/uploads")
	@ApiOperation(value = "上传", notes = "传入file", position = 1)
	public R uploads(  MultipartFile[] files) throws IOException {

		String savePath = "D:\\新宝液化\\";
		if(files != null && files.length != 0){
			if(null != files && files.length > 0){
				//遍历并保存文件
				for(MultipartFile file : files){
					file.transferTo(new File(savePath + file.getOriginalFilename()));
				}
			}
		}
		return R.status(true);
	}*/

	/**
	 * 获取目录树形结构(当前岗位人员所拥有权限)
	 */
	@GetMapping("/tree")
	@ApiLog("安全标准化文件-查询-目录树")
	@ApiOperation(value = "查询-目录树", notes = "获取目录树形结构(当前岗位人员所拥有权限),传入deptId", position = 1)
	@ApiImplicitParams({ @ApiImplicitParam(name = "parentId", value = "上级id", required = false),
		@ApiImplicitParam(name = "deptId", value = "单位id", required = true),
		@ApiImplicitParam(name = "fileProperty", value = "文件性质", required = false)
	})
	public R<List<BiaozhunhuamubanVO>> tree(@RequestParam Integer deptId, @RequestParam  Integer parentId, String fileProperty) {
		List<BiaozhunhuamubanVO> list;
		if(StrUtil.isNotEmpty(fileProperty)){
			 list= biaozhunhuamubanService.filePropertyTree(deptId,fileProperty);
		}else {
			 list= biaozhunhuamubanService.tree(deptId,parentId);
			List<SafetyProductionFileTO> safeList = safetyProductionFileService.selectByBind(parentId);
			safeList.forEach(item->{
				BiaozhunhuamubanVO vo = new BiaozhunhuamubanVO();
				if(item.getIsEdit()==0){
					vo.setPath(item.getMubanPath());
				}else{
					vo.setPath(item.getPath());
				}
				vo.setParentId(parentId);
				vo.setId(item.getBindId());
				vo.setName(item.getName());
				vo.setDocumentNumber(item.getDocumentNumber());
				vo.setDocSource(1);
				vo.setType("文件");
				vo.setFileNum(item.getCumulativeVisits());
				vo.setLastPreviewTime(item.getLastPreviewTime());
				list.add(vo);
			});
		}
		return R.data(list);
	}

	/**
	 * 权限树形结构(安标16项)
	 */
	@GetMapping("/Jurgrant-tree")
	@ApiLog("安全标准化文件-权限-tree")
	@ApiOperation(value = "权限-tree", notes = "传入postId", position = 1)
	@ApiImplicitParams({@ApiImplicitParam(name = "postId", value = "岗位id", required = true)})
	public R<List<BiaozhunhuamubanVO>> JurgrantTree(String postId) {
		Dept dept=iSysClient.selectByJGBM("机构",postId);
		List<BiaozhunhuamubanVO> list= biaozhunhuamubanService.JurgrantTree(dept.getId().toString());
		return R.data(list);
	}
	/**
	 * 岗位所拥有权限(安标16项)
	 */
	@GetMapping("/JurpostTreeKeys")
	@ApiLog("安全标准化文件-权限-keys")
	@ApiOperation(value = "权限-keys", notes = "传入postId", position = 1)
	@ApiImplicitParams({@ApiImplicitParam(name = "postId", value = "岗位id", required = true)})
	public R<List<String>> JurpostTreeKeys(String postId) {
		List<BiaozhunhuamubanVO> list= biaozhunhuamubanService.JurpostTreeKeys(postId);
		List<String> lists=new ArrayList<>();
		for (int i = 0; i <list.size() ; i++) {
			lists.add(list.get(i).getId().toString());
		}
		return R.data(lists);
	}
	/**
	 *新增目录
	 * @author: th
	 * @CreateDate: 2019-05-08 17:21
	 * @param id
	 * @param fileName
	 * @param user
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.Biaozhunhuamuban>
	 */
	@PostMapping("/addSubtemplateDir")
	@ApiLog("安全标准化文件-新增-文件夹")
	@ApiOperation(value = "新增-文件夹", notes = "传入本节点id，新增目录名称", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "需要新增下级节点的id", required = true),
		@ApiImplicitParam(name = "fileName", value = "新增文件夹的名称", required = true)
	})
	public R<BiaozhunhuamubanVO> addSubtemplateDir(Integer id,String fileName,BladeUser user) {
		Biaozhunhuamuban parent = biaozhunhuamubanService.getById(id);
		String msg = "新增成功";
		if(user==null){
			msg = "新增失败，user信息为null";
			return R.fail(msg);
		}
		//如果当前路径是目录
		if("文件夹".equals(parent.getType())){
			//生成文件夹
            FileUtil.mkParentDirs(fileParse.getPath(parent.getPath()));
			FileUtil.mkdir(fileParse.getPath(parent.getPath())+File.separator+fileName);
		}else{
			msg = "新增失败，该节点不是目录或不存在";
			return R.fail(msg);
		}
		//查询最大id
		Integer newId = biaozhunhuamubanService.selectMaxId()+1;
		//查询下级最大sort
		Integer newSort = biaozhunhuamubanService.selectMaxSorByParentId(id)+1;
		parent.setParentId(id);
		parent.setId(newId);
		parent.setPath(parent.getPath()+File.separator+fileName);
		parent.setCaozuoren(user.getUserName());
		parent.setCaozuorenid(user.getUserId());
		parent.setCaozuoshijian(DateUtil.now());
		parent.setTier(parent.getTier()+"-"+newId);
		parent.setName(fileName);
		parent.setSort(newSort);
		parent.setIsEdit(1);
		parent.setDocumentNumber(null);
		biaozhunhuamubanService.save(parent);
		BiaozhunhuamubanVO vo = new BiaozhunhuamubanVO();
		BeanUtil.copyProperties(parent,vo);
		vo.setFileNum(0);

		return R.data(vo,msg);
	}



	/**
	 *新增模板文件
	 * @author: th
	 * @CreateDate: 2019-05-09 19:32
	 * @param id
	 * @param file
	 * @param user
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.Biaozhunhuamuban>
	 */
	@PostMapping("/addSubtemplateFile")
	@ApiLog("安全标准化文件-新增-文件")
	@ApiOperation(value = "新增-文件", notes = "传入本节点id，文件", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "需要新增下级节点的id", required = true),
		@ApiImplicitParam(name = "file", value = "新增的文件", required = true)
	})
	public R<BiaozhunhuamubanVO> addSubtemplateFile(Integer id,MultipartFile file,BladeUser user) {
		Biaozhunhuamuban parent = biaozhunhuamubanService.getById(id);
		String deptName = iSysClient.getDeptName(parent.getDeptId());
		String msg = "新增成功";
		if(user==null){
			msg = "新增失败，user信息为null";
			return R.fail(msg);
		}
		//如果当前路径是目录
		if("文件夹".equals(parent.getType())){
			//获取文件名称
			String fileName = file.getOriginalFilename();
			List<Biaozhunhuamuban> byParentId = biaozhunhuamubanService.getByParentId(id);
			for (int i = 0; i < byParentId.size(); i++) {
				if(fileName.equals(byParentId.get(i).getName())){
					return R.fail("已存在相同文件名称");
				}
			}
			//获得文件物理路径
			String filePath = fileParse.getPath(parent.getPath())+File.separator+fileName;
			//生产父级目录
			FileUtil.mkParentDirs(filePath);

			try {
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
			Integer newId = biaozhunhuamubanService.selectMaxId()+1;
			//查询下级最大sort
			Integer newSort = biaozhunhuamubanService.selectMaxSorByParentId(id)+1;
			parent.setParentId(id);
			parent.setId(newId);
			parent.setPath(fileParse.getInsertPath(filePath));
			parent.setCaozuoren(user.getUserName());
			parent.setCaozuorenid(user.getUserId());
			parent.setCaozuoshijian(DateUtil.now());
			parent.setTier(parent.getTier()+"-"+newId);
			parent.setIsEdit(1);
			parent.setName(fileName);
			parent.setSort(newSort);
			parent.setType("文件");
			parent.setDocumentNumber(null);
			boolean save = biaozhunhuamubanService.save(parent);
			//保存成功，生成对应的正式文件，pdf，图片
			if(save){
				try {
					fileParse.creatFormalFile(parent, new HashMap<String,Object>(){{
						put("dpetName", deptName);
					}});
				} catch (IOException e) {
					e.printStackTrace();
					return R.fail("生成正式文件异常");
				}
			}
		}else{
			msg = "新增失败，该节点不是目录或不存在";
			return R.fail(msg);
		}

		BiaozhunhuamubanVO vo = new BiaozhunhuamubanVO();
		BeanUtil.copyProperties(parent,vo);
		vo.setFileNum(0);
		return R.data(vo,msg);
	}

	/**
	 *标准化模板文件替换
	 * @author: th
	 * @CreateDate: 2019-05-09 21:29
	 * @param id
	 * @param file
	 * @param user
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.Biaozhunhuamuban>
	 */
	@PostMapping("/replaceSubtemplateFile")
	@ApiLog("安全标准化文件-替换-文件")
	@ApiOperation(value = "替换-文件", notes = "传入本节点id，文件", position = 2)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "需要被替换节点的id", required = true),
		@ApiImplicitParam(name = "file", value = "替换的文件", required = true)
	})
	public R<Biaozhunhuamuban> replaceSubtemplateFile(Integer id,MultipartFile file,BladeUser user) {
		Biaozhunhuamuban byId = biaozhunhuamubanService.getById(id);
		String deptName = iSysClient.getDeptName(byId.getDeptId());
		String newPath = byId.getPath().replaceFirst(byId.getName(),file.getOriginalFilename());
		String newName = file.getOriginalFilename();
		String msg = "替换成功";
		if(user==null){
			msg = "替换失败，user信息为null";
			return R.fail(msg);
		}

		if(byId.getIsEdit()==1){
			//如果当前路径存在
			if(FileUtil.exist(fileParse.getPath(byId.getPath()))){
				//删除源企业模板文件
				FileUtil.del(fileParse.getPath(byId.getPath()));
			}
			//如果是文件类型，就继续删除正式文件，pdf，图片
			String mb = byId.getPath();
			String zs = StrUtil.replace(fileParse.getPath(mb),FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_FORMAL_PATH);
			String pdf = StrUtil.replace(StrUtil.replace(mb,FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_PDF_PATH),".docx",".pdf");
			String img = StrUtil.replace(StrUtil.replace(fileParse.getPath(mb),FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_IMG_PATH),".docx","");
			if(FileUtil.exist(fileParse.getPath(zs))){
				FileUtil.del(fileParse.getPath(zs));
			}
			if(FileUtil.exist(fileParse.getPath(pdf))){
				FileUtil.del(fileParse.getPath(pdf));
			}
			if(FileUtil.exist(fileParse.getPath(img))){
				FileUtil.del(fileParse.getPath(img));
			}
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

		byId.setPath(newPath);
		byId.setCaozuoren(user.getUserName());
		byId.setCaozuorenid(user.getUserId());
		byId.setCaozuoshijian(DateUtil.now());
		byId.setName(newName);
		byId.setIsEdit(1);
		boolean updateById = biaozhunhuamubanService.updateById(byId);

		//替换成功，生成对应的正式文件，pdf，图片
		if(updateById){
			try {
				 fileParse.creatFormalFile(byId, new HashMap<String,Object>(){{
					put("dpetName", deptName);
				}});
			} catch (IOException e) {
				e.printStackTrace();
				return R.fail("生成正式文件异常");
			}
		}

		return R.data(byId,msg);
	}

	/**
	 *删除节点
	 * @author: th
	 * @CreateDate: 2019-05-15 21:36
	 * @param id
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("/delSubtemplate")
	@ApiLog("安全标准化文件-删除-节点")
	@ApiOperation(value = "删除-节点", notes = "id", position = 3)
	public R delSubtemplate(@ApiParam(value = "主键", required = true) @RequestParam Integer id) {
		//查询下级节点
		List<Biaozhunhuamuban> list = biaozhunhuamubanService.getByParentId(id);
		String msg="删除成功";
		//如果有下级节点,不允许删除
		if(list!=null && list.size()>0){
			msg = "该节点下存在子节点,不允许直接删除";
			return R.fail(msg);
		}
		Biaozhunhuamuban byId = biaozhunhuamubanService.getById(id);
		if(byId.getIsEdit()==1){
			if(FileUtil.exist(fileParse.getPath(byId.getPath()))){
				FileUtil.del(fileParse.getPath(byId.getPath()));
			}
			//如果是文件类型，就继续删除正式文件，pdf，图片
			String mb = byId.getPath();
			String zs = StrUtil.replace(mb,FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_FORMAL_PATH);
			String pdf = StrUtil.replace(StrUtil.replace(mb,FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_PDF_PATH),".docx",".pdf");
			String img = StrUtil.replace(StrUtil.replace(mb,FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_IMG_PATH),".docx","");
			if(FileUtil.exist(fileParse.getPath(zs))){
				FileUtil.del(fileParse.getPath(zs));
			}
			if(FileUtil.exist(fileParse.getPath(pdf))){
				FileUtil.del(fileParse.getPath(pdf));
			}
			if(FileUtil.exist(fileParse.getPath(img))){
				FileUtil.del(fileParse.getPath(img));
			}
		}
		boolean b = biaozhunhuamubanService.removeById(id);
		return R.success(msg);
	}

	/**
	 * 根据文件性质获取目录树形结构
	 */
//	@GetMapping("/filePropertyTree")
//	@ApiOperation(value = "根据文件性质获取目录树形结构,及其所有上级节点", notes = "传入deptId,文件性质(法律法规,规章制度,操作规程...)", position = 1)
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "fileProperty", value = "文件性质", required = true),
//		@ApiImplicitParam(name = "deptId", value = "单位id", required = true)
//	})
//	public R<List<BiaozhunhuamubanVO>> filePropertyTree(@RequestParam Integer deptId,@RequestParam  String fileProperty) {
//		List<BiaozhunhuamubanVO> list= biaozhunhuamubanService.filePropertyTree(deptId,fileProperty);
//		return R.data(list);
//	}




	/**
	 *修改标准化节点文件性质
	 * @author: th
	 * @CreateDate: 2019-05-15 17:24
	 * @param id
	 * @param fileProperty
	 * @return: org.springblade.core.tool.api.R
	 */
	@GetMapping("/updateFileProperty")
	@ApiLog("安全标准化文件-修改-文件性质")
	@ApiOperation(value = "修改-文件性质", notes = "根据id修改节点的文件性质", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "fileProperty", value = "文件性质", required = true),
		@ApiImplicitParam(name = "id", value = "id", required = true)
	})
	public R updateFileProperty(@RequestParam Integer id,@RequestParam  String fileProperty) {
		boolean a= biaozhunhuamubanService.updateFilePropertyById(id,fileProperty);
		return R.success("修改文件性质成功");
	}


	/**
	 *修改文件所属人
	 * @author: th
	 * @date: 2019/5/19 14:51
	 * @param id
	 * @param fileSuoshurenId
	 * @return: org.springblade.core.tool.api.R
	 */
	@GetMapping("/updateFileSuoshuren")
	@ApiLog("安全标准化文件-修改-文件所属人")
	@ApiOperation(value = "修改-文件所属人", notes = "根据id修改文件所属人", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "fileSuoshurenId", value = "文件所属人id", required = true),
		@ApiImplicitParam(name = "id", value = "id", required = true)
	})
	public R updateFileSuoshuren(@RequestParam Integer id,@RequestParam  Integer fileSuoshurenId) {
		boolean a= biaozhunhuamubanService.updatefileSuoshurenById(id,fileSuoshurenId);
		return R.success("修改文件所属人成功");
	}



	@GetMapping("/updateDocumentNumber")
	@ApiLog("安全标准化文件-修改-文档编号")
	@ApiOperation(value = "修改-文档编号", notes = "根据id修改文档的编号", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "documentNumber", value = "文档编号", required = true),
		@ApiImplicitParam(name = "id", value = "id", required = true)
	})
	public R updateDocumentNumber(@RequestParam Integer id,@RequestParam  String documentNumber) {
        Biaozhunhuamuban byId = biaozhunhuamubanService.getById(id);
		//如果已经编辑，就删除文件
		if(byId.getIsEdit()==1){
			String mb = byId.getPath();
			String zs = StrUtil.replace(mb,FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_FORMAL_PATH);
			String pdf = StrUtil.replace(mb,FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_PDF_PATH);
			String img = StrUtil.replace(StrUtil.replace(mb,FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_IMG_PATH),".docx","");
			if(FileUtil.exist(fileParse.getPath(zs))){
				FileUtil.del(fileParse.getPath(zs));
			}
			if(FileUtil.exist(fileParse.getPath(pdf))){
				FileUtil.del(fileParse.getPath(pdf));
			}
			if(FileUtil.exist(fileParse.getPath(img))){
				FileUtil.del(fileParse.getPath(img));
			}
		}
		String deptName = iSysClient.getDeptName(byId.getDeptId());
		String tihuanmubanPath = byId.getPath();
		//如果未被编辑，就从模板中复制过来
		if(byId.getIsEdit()==0){
			tihuanmubanPath=byId.getMubanPath();
			FileUtil.copy(fileParse.getPath(tihuanmubanPath),fileParse.getPath(byId.getPath()),true);

		}
		try {
			fileParse.creatFormalFile(byId, new HashMap<String,Object>(){{
				put("dpetName", deptName);
				put("documentNumber", documentNumber);
			}});
            //修改数据编号
            boolean a= biaozhunhuamubanService.updateDocumentNumberById(id,documentNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return R.success("修改文档编号成功");
	}

	@GetMapping("/reName")
	@ApiLog("安全标准化文件-修改-文件名称")
	@ApiOperation(value = "修改-文件名称", notes = "根据id修改文件名称", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "新名称", required = true),
		@ApiImplicitParam(name = "id", value = "id", required = true)
	})
	public R reName(Integer id, String name) {
		boolean a= biaozhunhuamubanService.updateNameById(id,name+".docx");

		return R.success("重命名成功");
	}

	@GetMapping("/swapFileSort")
	@ApiLog("安全标准化文件-排序-节点")
	@ApiOperation(value = "排序-节点", notes = "根据模板文件id实现两节点排序号对调,实现节点排序上下移动", position = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "originId", value = "源文件id", required = true),
		@ApiImplicitParam(name = "targetId", value = "目标文件id", required = true)
	})
	public R swapFileSort(@RequestParam Integer originId,@RequestParam  Integer targetId) {
//		Biaozhunhuamuban origin = biaozhunhuamubanService.getById(originId);
//		Biaozhunhuamuban target = biaozhunhuamubanService.getById(targetId);
//		int originSort = origin.getSort();
//		int targetSort = target.getSort();
//		boolean a = biaozhunhuamubanService.updateSortById(originId,targetSort);
//		boolean b = biaozhunhuamubanService.updateSortById(targetId,originSort);
		boolean a= biaozhunhuamubanService.swapFileSort(originId,targetId);
		return R.success("移动成功");
	}



	/**
	 *根据文件所属人与文件性质预览对应图片
	 * @author: th
	 * @date: 2019/5/19 14:51
	 * @param fileProperty
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.BiaozhunhuawenjianVO>
	 */
	@PostMapping("/imgPreviewBySuoshuren")
	@ApiLog("安全标准化文件-预览-所属人的文件")
	@ApiOperation(value = "预览-所属人的文件", notes = "传入文件性质,预览他对应的文件", position = 9)
	public R<BiaozhunhuawenjianVO> imgPreviewBySuoshuren(@ApiParam(value = "文件性质", required = true)@RequestParam String fileProperty,
														 BladeUser user ){
//		if(user==null){
//			return R.fail("user信息为空");
//		}
		BiaozhunhuawenjianVO biaozhunhuawenjian= iBiaozhunhuawenjianService.selectPicPathBySuoshurenId(fileProperty,user.getUserId());
		if(biaozhunhuawenjian==null){
			return R.data(biaozhunhuawenjian,"该文件不存在对应的预览图片资源");
		}
		List<String> list = new ArrayList<String>();
		String pic = fileParse.getPath(biaozhunhuawenjian.getPath());
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
		biaozhunhuawenjian.setImgList(list);
		return R.data(biaozhunhuawenjian);
	}


	/**
	 *模板文件下载
	 * @author: th
	 * @date: 2019/5/19 2:04
	 * @param id
	 * @return: java.lang.String
	 */
	@GetMapping("downloadSubtemplateFile")
	@ApiLog("安全标准化文件-下载-文件")
	@ApiOperation(value = "下载-文件", notes = "根据安标模板id下载模板文件", position = 1)
	@ApiImplicitParam(name = "id", value = "id", required = true)
	public R<String> downloadSubtemplateFile(@RequestParam Integer id){
		Biaozhunhuamuban byId = biaozhunhuamubanService.getById(id);
		if(byId==null){
			R.fail("不存在该模板文件");
		}
		String path =byId.getPath();
		if(byId.getIsEdit()==0){
			path=byId.getMubanPath();
		}
		return R.data(fileParse.insertPathToUrl(path));
	}





/*	@GetMapping("downloadSubtemplateFile")
	@ApiOperation(value = "下载企业安标模板文件", notes = "根据安标模板id下载模板文件", position = 1)
	@ApiImplicitParam(name = "id", value = "id", required = true)
	public String downloadSubtemplateFile(HttpServletResponse response,@RequestParam Integer id){
		Biaozhunhuamuban byId = biaozhunhuamubanService.getById(id);
		String fileName = byId.getName();
		String filePath = fileParse.getPath(byId.getPath());
		File file = new File(filePath);
		if(file.exists()){ //判断文件父目录是否存在
			response.setContentType("application/force-download");
			try {
				response.addHeader("Content-Disposition","attachment;fileName=" +new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			byte[] buffer = new byte[1024];
			FileInputStream fis = null; //文件输入流
			BufferedInputStream bis = null;

			OutputStream os = null; //输出流
			try {
				os = response.getOutputStream();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				int i = bis.read(buffer);
				while(i != -1){
					os.write(buffer);
					i = bis.read(buffer);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("----------file download" + fileName);
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}*/



	/**
	 * 根据安标性质获取目录树形结构
	 */
//	@GetMapping("/anbiaoPropertyTree")
//	@ApiIgnore()
//	@ApiOperation(value = "根据安标性质获取目录树形结构", notes = "传入deptId,安标性质(会议记录,教育培训,事故调查报告与处理...)", position = 1)
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "anbiaoProperty", value = "安标性质", required = true),
//		@ApiImplicitParam(name = "deptId", value = "单位id", required = true)
//	})
//	public R<List<BiaozhunhuamubanVO>> anbiaoPropertyTree(@RequestParam Integer deptId,@RequestParam  String anbiaoProperty) {
//		List<BiaozhunhuamubanVO> list= biaozhunhuamubanService.anbiaoPropertyTree(deptId,anbiaoProperty);
//		return R.data(list);
//	}



	/**
	 *文件对应图片预览
	 * @author: th
	 * @CreateDate: 2019-05-12 15:08
	 * @param id
	 * @return: org.springblade.core.tool.api.R<org.springblade.anbiao.BiaozhunhuawenjianVO>
	 */
	@PostMapping("/imgPreview")
	@ApiLog("安全标准化文件-预览-文件")
	@ApiOperation(value = "预览-文件", notes = "传入id,filetype(filetype为解析后的文件类型,有1正式文件,2pdf文件,3img文件,预览用3,保留filetype参数,是以防将来做pdf预览)", position = 9)
	public R<BiaozhunhuamubanVO> imgPreview(@ApiParam(value = "id", required = true)@RequestParam Integer id,
											@ApiParam(value = "docSource", required = false,defaultValue = "0")@RequestParam(required = false,defaultValue = "0") Integer docSource){
		//BiaozhunhuawenjianVO biaozhunhuawenjian= iBiaozhunhuawenjianService.selectPicPath(id,fileType);
		if(docSource==1){
			BiaozhunhuamubanVO vo = new BiaozhunhuamubanVO();
			SafetyProductionFile safe = safetyProductionFileService.selectByBindId(id);
			if(safe==null){
				return R.data(vo,"该文件不存在对应的预览图片资源");
			}
			List<String> list = new ArrayList<String>();
			String path = safe.getPath();
			if(safe.getIsEdit()==0){
				path = safe.getMubanPath();
			}
			String pic = StrUtil.replace(StrUtil.replace(fileParse.getPath(path),FilePathConstant.SPF_PATH,FilePathConstant.SPF_IMG_PATH),".docx","");
			File file = new File(pic);
			File[] files=file.listFiles();
			for(int i = 0; i < files.length; i++){
				if (files[i].isFile()) {
					try{
						list.add(fileParse.pathToUrl(files[i].getPath()));
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
			vo.setImgList(list);
			return R.data(vo);

		}else{
			Biaozhunhuamuban biaozhunhuamuban = biaozhunhuamubanService.getById(id);
			BiaozhunhuamubanVO vo = new BiaozhunhuamubanVO();
			BeanUtil.copyProperties(biaozhunhuamuban,vo);
			if(biaozhunhuamuban==null){
				return R.data(vo,"该文件不存在对应的预览图片资源");
			}
			List<String> list = new ArrayList<String>();
			String path = vo.getPath();
			if(vo.getIsEdit()==0){
				path = vo.getMubanPath();
			}
			String pic = StrUtil.replace(StrUtil.replace(fileParse.getPath(path),FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_IMG_PATH),".docx","");
			File file = new File(pic);
			File[] files=file.listFiles();
			for(int i = 0; i < files.length; i++){
				if (files[i].isFile()) {
					try{
						list.add(fileParse.pathToUrl(files[i].getPath()));
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
			vo.setImgList(list);
			int i  = biaozhunhuamubanService.updatePreviewRecordById(id);
			return R.data(vo);
		}

	}



	/*@PostMapping("/filePathInsert")
	@ApiIgnore()
	public void filePathInsert(){

		int maxId = 1;
		fileParse.setId(maxId);
		fileParse.parseFile(new File("D:\\新宝液化"), 0,1);
		List<Biaozhunhuamuban> list = fileParse.getList();
		for(Biaozhunhuamuban b:list){
			log.info(b.getSort()+":"+b.getId()+":"+b.getName());
		}
		biaozhunhuamubanService.saveBatch(list);
	}*/




	/**
	 *根据文件性质查询文件列表数据
	 * @author: th
	 * @CreateDate: 2019-05-11 18:44
	 * @param biaozhunhuamubanPage
	 * @return: org.springblade.core.tool.api.R<java.util.List<org.springblade.anbiao.Biaozhunhuamuban>>
	 */
	@PostMapping("/fileList")
	@ApiLog("安全标准化文件-列表-文件")
	@ApiOperation(value = "列表-文件", notes = "传入文件性质,与单位id", position = 8)
	public R<BiaozhunhuamubanPage<BiaozhunhuamubanVO>> fileList(@RequestBody BiaozhunhuamubanPage biaozhunhuamubanPage){
		BiaozhunhuamubanPage<BiaozhunhuamubanVO> biaozhunhuamubans = biaozhunhuamubanService.fileList(biaozhunhuamubanPage);
		return R.data(biaozhunhuamubans);
	}


    @PostMapping("/aKeyGeneration")
    @ApiLog("安全标准化文件-一键生成")
    @ApiOperation(value = "安全标准化文件-一键生成", notes = "传入机构id与运营类型", position = 8)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deptId", value = "机构id", required = true),
		@ApiImplicitParam(name = "yunyingleixing", value = "运营类型(1危货，2普货，3客运)", required = true),
		@ApiImplicitParam(name = "isOnlyDir", value = "是否只生成目录(0否1是)", required = false),
		@ApiImplicitParam(name = "caozuoren", value = "操作人", required = false),
		@ApiImplicitParam(name = "caozuorenid", value = "操作人id", required = false)
	})
    public R aKeyGeneration(Integer deptId,Integer yunyingleixing,Integer isOnlyDir,String caozuoren,Integer caozuorenid){
		// TODO: 2019/9/3 非线程安全，改成多例模式或者用消息队列
		List<Integer> deptIds = iSysClient.getDetpIds(deptId);
		List<BiaozhunhuamubanVO> mubanList = biaozhunhuamubanService.getMubanTree(yunyingleixing,isOnlyDir);
		for (Integer id : deptIds) {
			int i = biaozhunhuamubanService.getCountByDetpId(id);
			//如果改机构已有文件，则跳过
			if(i>0){
				return R.success("该机构已有文件");
			}
			String deptName = iSysClient.getDeptName(id);
			int maxId = biaozhunhuamubanService.selectMaxId()+1;
			fileParse.setId(maxId);
			fileParse.setDeptName(deptName);
			fileParse.setDeptId(id);

			fileParse.parseMubanList(mubanList,FilePathConstant.DEFAULT_PARENT_ID,FilePathConstant.DEFAULT_TIER);
			List<Biaozhunhuamuban> list = fileParse.getList();
			fileParse.close();
			list.get(i).setCaozuoren(caozuoren);
			list.get(i).setCaozuorenid(caozuorenid);
			String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			list.get(i).setCaozuoshijian(formatStr2);
			biaozhunhuamubanService.saveBatch(list);
		}

		return R.success("一键生成成功");
    }



	@GetMapping("/safetyBind")
	@ApiLog("安全标准化文件-安全生产完档绑定")
	@ApiOperation(value = "安全标准化文件-安全生产完档绑定", notes = "传入标准文件目录id与安全生产文档ids", position = 1)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "标准化文件目录id", required = true),
			@ApiImplicitParam(name = "safetyIds", value = "安全生产文档ids", required = true)
	})
	public R<List<BiaozhunhuamubanVO>> safetyBind(@RequestParam  Integer id, @RequestParam String safetyIds) {
		Biaozhunhuamuban byId = biaozhunhuamubanService.getById(id);
		if("文件".equals(byId.getType())){
			return R.fail("请用目录进行绑定");
		}
		biaozhunhuamubanService.insertBind(id,safetyIds.split(","));
		List<SafetyProductionFileTO> safeList =  safetyProductionFileService.selectByBind(id);
		List<BiaozhunhuamubanVO> biaozhunhuamubanVOList = new ArrayList<BiaozhunhuamubanVO>();
		safeList.forEach(item->{
			BiaozhunhuamubanVO vo = new BiaozhunhuamubanVO();
			if(item.getIsEdit()==0){
				vo.setPath(item.getMubanPath());
			}else{
				vo.setPath(item.getPath());
			}
			vo.setParentId(id);
			vo.setId(item.getBindId());
			vo.setDocSource(1);
			vo.setType("文件");
			vo.setFileNum(item.getCumulativeVisits());
			vo.setLastPreviewTime(item.getLastPreviewTime());
			biaozhunhuamubanVOList.add(vo);
		});
		return R.data(biaozhunhuamubanVOList,"绑定成功");
	}



	@GetMapping("/cancelSafetyBind")
	@ApiLog("安全标准化文件-安全生产完档取消绑定")
	@ApiOperation(value = "安全标准化文件-安全生产完档取消绑定", notes = "传入节点id", position = 1)
	@ApiImplicitParam(name = "id", value = "节点id", required = true)
	public R cancelSafetyBind(@RequestParam  Integer id) {
		biaozhunhuamubanService.deleteBind(id);
		return R.success("取消绑定成功");
	}

	@PostMapping(value = "/getQYBZHList")
	@ApiLog("已生成标准化相关文件的企业信息")
	@ApiOperation(value = "已生成标准化相关文件的企业信息", notes = "传入biaozhunhuamubanPage",position = 3)
	public R getQYBZHList(@RequestBody BiaozhunhuamubanPage biaozhunhuamubanPage) throws IOException {
		return R.data(biaozhunhuamubanService.selectGetBiaoZhunHuaList(biaozhunhuamubanPage));
	}

	@PostMapping(value = "/getQYWDList")
	@ApiLog("安全管理标准文档,一键生成,未生成的企业")
	@ApiOperation(value = "安全管理标准文档,一键生成,未生成的企业", notes = "传入deptId",position = 4)
	public R getQYWDList(@RequestBody BiaozhunhuamubanPage biaozhunhuamubanPage) throws IOException {
		return R.data(biaozhunhuamubanService.selectGetQYWD(biaozhunhuamubanPage.getDeptId()));
	}

	@PostMapping(value = "/getQYWJList")
	@ApiLog("安全标准化文件,一键生成,未生成的企业")
	@ApiOperation(value = "安全标准化文件,一键生成,未生成的企业", notes = "传入deptId",position = 5)
	public R getQYWJList(@RequestBody BiaozhunhuamubanPage biaozhunhuamubanPage) throws IOException {
		return R.data(biaozhunhuamubanService.selectGetQYWJ(biaozhunhuamubanPage.getDeptId()));
	}


}

