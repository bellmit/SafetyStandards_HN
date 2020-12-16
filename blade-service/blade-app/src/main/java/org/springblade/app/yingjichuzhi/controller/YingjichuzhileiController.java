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
package org.springblade.app.yingjichuzhi.controller;

import cn.cqmxcx.www.util.FileUPLoad;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.app.yingjichuzhi.entity.Yingjichuzhilei;
import org.springblade.app.yingjichuzhi.page.YingjichuzhileiPage;
import org.springblade.app.yingjichuzhi.service.IYingjichuzhileiService;
import org.springblade.app.yingjichuzhi.vo.YingjichuzhileiVO;
import org.springblade.common.configurationBean.FileServer;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.common.tool.CommonUtil;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  控制器
 *
 * @author Blade
 * @since 2019-05-07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/yingjichuzhilei")
@Api(value = "", tags = "应急处置类")
public class YingjichuzhileiController extends BladeController {

	private IYingjichuzhileiService yingjichuzhileiService;
	private FileServer fileServer;

	/**
	* 分页
	*/
	/*@GetMapping("/page")
	@ApiOperation(value = "列表查询", notes = "传入yingjichuzhilei", position = 1)
	public R<IPage<Yingjichuzhilei>> list(Yingjichuzhilei yingjichuzhilei, Query query) {
		IPage<Yingjichuzhilei> pages = yingjichuzhileiService.page(Condition.getPage(query), Condition.getQueryWrapper(yingjichuzhilei));
		//YingjichuzhileiWrapper yingjichuzhileiWrapper = new YingjichuzhileiWrapper(dictClient);

		return R.data(pages);
	}*/

	/**
	* 自定义分页
	*/
	@PostMapping("/list")
	@ApiLog("列表查询-应急处置类")
	@ApiOperation(value = "列表查询-应急处置类", notes = "传入yingjichuzhileiPage(应急处置id,current,size必填)", position = 1)
	public R<YingjichuzhileiPage<YingjichuzhileiVO>> page(@RequestBody YingjichuzhileiPage yingjichuzhileiPage) {
		//IPage<YingjichuzhileiVO> pages = yingjichuzhileiService.selectYingjichuzhileiPage(Condition.getPage(query), yingjichuzhilei);
		YingjichuzhileiPage<YingjichuzhileiVO> pages = yingjichuzhileiService.selectPageList(yingjichuzhileiPage);
		return R.data(pages);
	}

	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@PostMapping("/detail")
	@ApiLog("详情-应急处置类")
	@ApiOperation(value = "详情-应急处置类", notes = "传入id", position = 2)
	public R<Yingjichuzhilei> selectByKey(@ApiParam(value = "主键id", required = true) @RequestParam String id){
		YingjichuzhileiVO yingjichuzhilei = yingjichuzhileiService.selectByKey(id);
		if(yingjichuzhilei==null){
			yingjichuzhilei = new YingjichuzhileiVO();
		}
		String path = yingjichuzhilei.getTupianpath();
		List<String> list = new ArrayList<String>();
		String[] paths = path.split("\\|");
		System.out.println(yingjichuzhilei.getCaozuoshijian().split("-"));
		String [] nyr= yingjichuzhilei.getCaozuoshijian().split("-");
		String filenamepic = nyr[0]+"/"+nyr[1]+"/anbiao_yingjichuzhilei/";
		if(paths.length>0){
			for(int i=0;i<paths.length;i++){
				String 	pathes = fileServer.getUrlPrefix()+ StrUtil.replace(FilePathConstant.EMERGENCYPIC_PATH,"\\","/")+filenamepic+paths[i];
				list.add(pathes);
				yingjichuzhilei.setPaths(list);
			}
		}
		return R.data(yingjichuzhilei);
	}

	/**
	* 新增
	*/
	@PostMapping("/save")
	@ApiLog("新增-应急处置类")
	@ApiOperation(value = "新增-应急处置类", notes = "传入yingjichuzhilei", position = 3)
	public R save(@Valid @RequestBody Yingjichuzhilei yingjichuzhilei) {
		yingjichuzhilei.setCaozuoshijian(DateUtil.now());
		yingjichuzhilei.setCreatetime(DateUtil.now());
		return R.status(yingjichuzhileiService.save(yingjichuzhilei));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiOperation(value = "修改-应急处置类", notes = "传入yingjichuzhilei", position = 4)
	public R update(@Valid @RequestBody Yingjichuzhilei yingjichuzhilei) {
		return R.status(yingjichuzhileiService.updateById(yingjichuzhilei));
	}

	/**
	* 新增或修改
	*/
	/*@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入yingjichuzhilei", position = 5)
	public R submit(@Valid @RequestBody Yingjichuzhilei yingjichuzhilei) {
		return R.status(yingjichuzhileiService.saveOrUpdate(yingjichuzhilei));
	}*/


	/**
	* 删除
	*/
	@PostMapping("/remove")
	@ApiLog("删除-应急处置类")
	@ApiOperation(value = "删除-应急处置类", notes = "传入id", position = 6)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(yingjichuzhileiService.removeByIds(Func.toStrList(ids)));
	}



	@PostMapping("/uploadfile")
	@ApiLog("上传文件-应急处置类")
	@ApiOperation(value = "上传文件-应急处置类", notes = "传入file,table", position = 7)
	public  R<List<Map<String, String>>>  uploadtopic(MultipartFile file, String table) throws IOException {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String,String> map = new HashMap<String,String>();
		String [] nyr= DateUtil.today().split("-");
		String path= fileServer.getPathPrefix()+FilePathConstant.EMERGENCYWORLD_PATH;
		String pathPdf = fileServer.getPathPrefix()+FilePathConstant.EMERGENCYPDF_PATH;
		String pathPic = fileServer.getPathPrefix()+FilePathConstant.EMERGENCYPIC_PATH;
		String name=file.getOriginalFilename();
		String[] a=name.split("\\.");
		String filename = nyr[0]+"\\"+nyr[1]+"\\"+table+"\\"+System.currentTimeMillis()+"."+a[a.length-1];
		String filenamepdf = nyr[0]+"\\"+nyr[1]+"\\"+table+"\\"+System.currentTimeMillis()+".pdf";
		String filenamepic = nyr[0]+"\\"+nyr[1]+"\\"+table;
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File dirs = new File(pathPdf);
		if(!dirs.exists()){
			dirs.mkdirs();
		}
		File targetFile = new File(path+"\\"+filename);
		//执行上传
		file.transferTo(targetFile);
		//判断是否上传成功
		if(targetFile.exists()){
			//存放数据
			long ab=System.currentTimeMillis();
			System.out.println("正在转换中 请等待-------");
			CommonUtil.world2pdf(path+"\\"+filename
				, pathPdf+"\\"+filenamepdf);
			long b=System.currentTimeMillis();
			String urlpath = CommonUtil.pdf2Image(pathPdf+filenamepdf,pathPic+filenamepic,300,0);
			System.out.println(urlpath);
			String[] urls = urlpath.split("\\|");
			String urlpic="";
			for(int i=0;i<urls.length;i++){
				System.out.println(urls[i]);
				urlpic = urlpic+urls[i]+"|";
			}
			System.out.println(urlpath);
			System.out.println("转换完成用时："+(b-ab)/1000+"秒");

			map.put("fileName",name);
			map.put("worldurl",filename);
			map.put("pdfurl",filenamepdf);
			map.put("picurl",urlpic);

		}else{
			map.put("fileName",name);
			map.put("worldurl","");
			map.put("pdfurl","");
			map.put("error","文件上传失败");
		}
		list.add(map);
		return R.data(list);
	}

	/**
	 * 文件查看
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@PostMapping("/imgView")
	@ApiLog("文件查看-应急处置类")
	@ApiOperation(value = "文件查看-应急处置类", notes = "传入world 的文件url", position = 8)
	public void imgView(HttpServletRequest request, HttpServletResponse response, String url,String filename) throws IOException {

		File file = new File(fileServer.getPathPrefix()+FilePathConstant.EMERGENCYWORLD_PATH+url);
		InputStream is = new FileInputStream(file);
		FileUPLoad fileUPLoad = new FileUPLoad();
		fileUPLoad.DownFile( filename, is, request, response);
	}




}
