package org.springblade.upload.upload.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrSpliter;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.upload.upload.entity.FileObj;
import org.springblade.upload.upload.entity.FileUpload;
import org.springblade.upload.upload.service.FileUploadService;
import org.springblade.common.configurationBean.FileServer;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.core.secure.BladeUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SafetyStandards
 * @description: FileUploadController
 **/
@RestController
@RequestMapping("/upload")
@AllArgsConstructor
@Api(value = "附件", tags = "附件")
public class FileUploadController {

	private FileUploadService fileUploadService;

	private FileServer fileServer;

	/**
	 * 删除附件
	 * @param id
	 * @return
	 */
	@PostMapping("/goDel")
	@ApiOperation(value = "删除附件", notes = "传入id", position = 1)
	public @ResponseBody int goDel(String id) {
		int i = 0;
		FileUpload fileUPLoad = fileUploadService.getById(id);
		File file = new File(fileServer.getPathPrefix()+ FilePathConstant.ENCLOSURE_PATH+fileUPLoad.getPath());
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				fileUploadService.removeById(id);
				i=1;
			}
		} else {
			i=0;
		}
		return i;
	}
	/**
	 * 删除附件集合
	 * @param ids
	 * @return
	 */
	@PostMapping("/goDels")
	@ApiOperation(value = "删除附件集合", notes = "传入ids", position = 1)
	public @ResponseBody int goDels(String ids) {
		int j = 0;
		if(ids!=null){
			//参数：被切分字符串，分隔符逗号，0表示无限制分片数，去除两边空格，忽略空白项
			List<String> split = StrSpliter.split(ids, ',', 0, true, true);
			for (int i = 0; i <split.size() ; i++) {
				FileUpload fileUPLoad = fileUploadService.getById(split.get(i));
				File file = new File(fileServer.getPathPrefix()+ FilePathConstant.ENCLOSURE_PATH+fileUPLoad.getPath());
				// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
				if (file.exists() && file.isFile()) {
					if (file.delete()) {
						fileUploadService.removeById(split.get(i));
						j=1;
					}
				} else {
					j=0;
				}
			}
		}
		return j;
	}


	@PostMapping("/upload")
	@ApiOperation(value = "上传", notes = "传入file,table", position = 1)
	public  FileObj  upload(MultipartFile file, String table, String fileId,BladeUser bladeUser) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		FileObj  fileObj=new FileObj();
		String [] nyr=DateUtil.today().split("-");
		long size=file.getSize();
		String name=file.getOriginalFilename();
		String[] a=name.split("\\.");
		String filename = System.currentTimeMillis()+"."+a[a.length-1];
		//附件存放地址(服务器生成地址)
		String path=fileServer.getPathPrefix()+ FilePathConstant.ENCLOSURE_PATH+nyr[0]+"\\"+nyr[1]+"\\"+table+"\\";
		//附件存储物理路径
		String paths=nyr[0]+"\\"+nyr[1]+"\\"+table+"\\"+filename;
		//时间
		String[] data=DateUtil.now().split("-");
		//附件url地址
		String url=fileServer.getUrlPrefix()+ FilePathConstant.EnclosureUrl+data[0]+"/"+data[1]+"/"+table+"/"+filename;
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File targetFile = new File(path+"\\"+filename);
		//执行上传
		file.transferTo(targetFile);
		//存放数据
		FileUpload fileUpload = new FileUpload();
		fileUpload.setId(IdUtil.simpleUUID());
		fileUpload.setFileSaveName(filename);
		fileUpload.setFileSize(size);
		fileUpload.setFileName(name);
		fileUpload.setAttachcode(fileId);
		fileUpload.setPath(paths);
		fileUpload.setFloder(table);
		if(bladeUser!=null){
			fileUpload.setUserName(bladeUser.getUserName());
			fileUpload.setUserid(bladeUser.getUserId());
			fileUpload.setUploadTime(DateUtil.now());
			fileUploadService.insertAttachfile(fileUpload);
			fileObj.setUrl(url);
		}else{

		}
		fileObj.setId(fileUpload.getId());
		fileObj.setName(name);
		fileObj.setSavename(filename);
		fileObj.setUrl(url);
		return fileObj;
	}



}
