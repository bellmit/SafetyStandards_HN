package org.springblade.upload.upload.feign;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.upload.upload.entity.FileUpload;
import org.springblade.upload.upload.service.FileUploadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @program: SpringBlade
 * @description: FileUploadClient
 **/
@ApiIgnore
@RestController
@AllArgsConstructor
public class FileUploadClient implements IFileUploadClient {

	private FileUploadService fileUploadService;

	@Override
	@GetMapping(API_PREFIX + "/selectAll")
	@ApiOperation(value = "根据attachcode获取信息(feign使用)", notes = "传入attachcode", position = 1)
	public List<FileUpload> selectAll(@RequestParam("attachcode") String attachcode) {
		return fileUploadService.selectAll(attachcode);
	}

	@Override
	@GetMapping(API_PREFIX + "/selectByFileName")
	@ApiOperation(value = "根据文件名称获取信息(feign使用)", notes = "传入filename", position = 2)
	public FileUpload selectByFileName(@RequestParam("filename") String filename) {
		return fileUploadService.selectByFileName(filename);
	}

	@Override
	@GetMapping(API_PREFIX + "/getUrl")
	@ApiOperation(value = "根据传入str进行解析成url并返回(feign使用)", notes = "传入str", position = 3)
	public String getUrl(@RequestParam("str")  String str) {
		return fileUploadService.getUrl(str);
	}

	@Override
	@GetMapping(API_PREFIX + "/getUrlUrl")
	@ApiOperation(value = "根据传入str进行解析成url并返回(feign使用)", notes = "传入str", position = 3)
	public String getUrlUrl(@RequestParam("str")  String str) {
		return fileUploadService.getUrlUrl(str);
	}
	@Override
	@GetMapping(API_PREFIX + "/getUrllogin")
	@ApiOperation(value = "根据传入str进行解析成url并返回(feign使用)", notes = "传入str", position = 3)
	public String getUrllogin(@RequestParam("str")  String str) {
		return fileUploadService.getUrllogin(str);
	}

	@Override
	@GetMapping(API_PREFIX + "/delByFileName")
	@ApiOperation(value = "根据附加名称进行删除", notes = "传入filename", position = 3)
	public boolean delByFileName(String filename) {
		return fileUploadService.delByFileName(filename);
	}

	/**
	 * 在实现服务里的参数也必须加上 @RequestBody ，不然获取的对象仍然没有值
	 * @param str
	 * @return
	 */
	@Override
	@PostMapping(API_PREFIX + "/updateCorrelation")
	@ApiOperation(value = "根据id修改附件状态(feign使用)", notes = "传入str,correlation", position = 4)
	public Boolean updateCorrelation(@RequestParam("str")  String str,@RequestParam("correlation")  String correlation) {
		return fileUploadService.updateCorr(str,correlation);
	}

}
