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

import org.springblade.core.log.annotation.ApiLog;
import org.springblade.doc.biaozhunhuamuban.entity.Template;
import org.springblade.doc.biaozhunhuamuban.service.ITemplateService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.feign.IDictClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 *  控制器
 *
 * @author th
 * @since 2019-05-07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doc/biaozhunhuamuban/template")
@Api(value = "标准化母模板", tags = "标准化母模板")
public class TemplateController extends BladeController {

	private ITemplateService templateService;

	private IDictClient dictClient;





	/**
	 *上传标准化母模板文件
	 * @author: hyp
	 * @CreateDate2021-05-08 10:56
	 * @param file
	 * @param template
	 * @param user
	 * @return: org.springblade.core.tool.api.R
	 */
	@PostMapping("/uploadTemplateZip")
	@ApiLog("安全标准化文件-上传-zip母模板文件")
	@ApiOperation(value = "上传-zip母模板文件", notes = "传入file，template,user", position = 1)
	public R uploadZip(MultipartFile file, Template template, BladeUser user) throws IOException {
		Long start = System.currentTimeMillis();
		//临时存放路径
		String zipPath = FilePathConstant.UPLOAD_TEMP_PATH+template.getDeptName();
		//解压到母模板路径
		String unzipPath = FilePathConstant.TEMPLATE_PATH+template.getTemplateName();
		if(!FileUtil.exist(zipPath)){
			FileUtil.mkdir(zipPath);
		}
		if(!FileUtil.exist(unzipPath)){
			FileUtil.mkdir(unzipPath);
		}
		File targetFile = new File(zipPath+File.separator+file.getOriginalFilename());
		//zip写入到临时文件
		file.transferTo(targetFile);
		//解压到母模板文件
		File unFile=ZipUtil.unzip(zipPath+File.separator+file.getOriginalFilename(),unzipPath, Charset.forName("GBK"));
		//存入母模板信息到anbiao_template
		template.setTemplatePath(unzipPath);
		template.setCaozuoren(user.getUserName());
		template.setCaozuorenid(user.getUserId());
		template.setCaozuoshijian(DateUtil.now());
		template.setCreatetime(DateUtil.now());
		templateService.save(template);
		//删除临时保存的zip文件
		FileUtil.del(zipPath+File.separator+file.getOriginalFilename());

		Long end = System.currentTimeMillis();
		//文件递归解析到数据存取耗时
		System.out.println(DateUtil.formatBetween(end-start));

		return R.status(true);
	}




	/**
	* 新增
	*/
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入template", position = 4)
	public R save(@Valid @RequestBody Template template) {
		return R.status(templateService.save(template));
	}

	/**
	* 修改
	*/
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入template", position = 5)
	public R update(@Valid @RequestBody Template template) {
		return R.status(templateService.updateById(template));
	}

	/**
	* 新增或修改
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入template", position = 6)
	public R submit(@Valid @RequestBody Template template) {
		return R.status(templateService.saveOrUpdate(template));
	}


	/**
	* 删除
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(templateService.removeByIds(Func.toIntList(ids)));
	}


}
