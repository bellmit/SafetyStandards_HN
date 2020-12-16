package org.springblade.doc.biaozhunhuamuban.feign;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import org.springblade.common.constant.FilePathConstant;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.biaozhunhuamuban.entity.FileParse;
import org.springblade.doc.biaozhunhuamuban.service.IBiaozhunhuamubanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringBlade
 * @description: BlogClientImpl
 * @author: 呵呵哒
 **/
@RestController
@AllArgsConstructor
public class BiaozhunhuamubanClientImpl implements IBiaozhunhuamubanClient {

	private IBiaozhunhuamubanService biaozhunhuamubanService;

	private FileParse fileParse;


	@Override
	@GetMapping(API_PREFIX + "/getImgList")
	public List<String > getImgList(Integer id) {
		List<String> list = new ArrayList<String>();
		Biaozhunhuamuban byId = biaozhunhuamubanService.getById(id);
		String path = byId.getPath();
		if(byId.getIsEdit()==0){
			path = byId.getMubanPath();
		}
		String pic = StrUtil.replace(StrUtil.replace(fileParse.getPath(path), FilePathConstant.SUBTEMPLATE_PATH,FilePathConstant.SUBTEMPLATE_IMG_PATH),".docx","");
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
		return list;
	}
}
