package org.springblade.upload.upload.feign;

import org.springblade.upload.upload.entity.FileUpload;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SpringBlade
 * @description: FileUploadClientBack
 * @author: hyp
 * @create: 2019-04-19 17:46
 **/
@Component
public class IFileUploadClientBack implements IFileUploadClient {
	@Override
	public List<FileUpload> selectAll(String attachcode) {
		return null;
	}

	@Override
	public FileUpload selectByFileName(String filename) {
		return null;
	}

	@Override
	public String getUrl(String str) {
		return null;
	}

	@Override
	public String getUrlUrl(String str) {
		return null;
	}

	@Override
	public String getUrllogin(String str) {
		return null;
	}

	@Override
	public boolean delByFileName(String filename) {
		return false;
	}

	@Override
	public Boolean updateCorrelation(String str,String correlation) {
		return false;
	}

}
