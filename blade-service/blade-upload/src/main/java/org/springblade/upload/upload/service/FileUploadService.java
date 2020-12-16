package org.springblade.upload.upload.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.upload.upload.entity.FileUpload;

import java.util.List;

/**
 */
public interface FileUploadService extends IService<FileUpload> {

	/**
	 * @Description:
	 * @param: filename
	 * @return: org.springblade.deadline.entity.FileUpload
	 */
	FileUpload selectByFileName(String filename);
	/**
	 * @Description:
	 * @param: [attachcode]
	 * @return: java.util.List<org.springblade.deadline.entity.FileUpload>
	 */
	List<FileUpload> selectAll(String attachcode);

	/**
	 * 附件回显
	 * @param attachcode
	 * @return
	 */
	public List<FileUpload> huixian(String attachcode);

	/**
	 * x自定义新增
	 * @param FileUpload
	 * @return
	 */
	boolean insertAttachfile(FileUpload FileUpload);

	/**
	 * @Description:根据传值获取url(附件名称)
	 * @Param: [list]
	 * @return: java.lang.String
	 */
	String getUrl(String str);
	/**
	 * @Description:根据传值获取url(附件名称 )
	 * @Param: [list]
	 * @return: java.lang.String
	 */
	String getUrlUrl(String str);

	/**
	 * @Description:根据传值获取url(附件名称 日报)
	 * @Param: [list]
	 * @return: java.lang.String
	 */
	String getUrllogin(String str);

	/**
	 * 根据id修改附件状态
	 * @param FileUpload
	 * @return
	 */
	boolean updateCorrelation(FileUpload FileUpload);

	boolean delByFileName(String filename);

	/**
	 * 根据id修改附件状态(fegin)
	 * @param str
	 * @return
	 */
	boolean updateCorr(String str, String correlation);
	/**
	 * @Description: 根据attachcode与保存名称查询需要清理的数据
	 * @Param: [attachcode, str]
	 * @return: java.util.List<org.springblade.anbiao.upload.entity.FileUpload>
	 */
//	List<FileUpload>  selectByNotSaveName(String attachcode,List<String> str);

}
