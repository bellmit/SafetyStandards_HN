package org.springblade.upload.upload.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.upload.upload.entity.FileUpload;

import java.util.List;


/**
* @Description:
*/
public interface FileUploadMapper extends BaseMapper<FileUpload> {
	/**
	* @Description:
	*/
	FileUpload selectByFileName(String filename);
	/**
	* @Description:
	* @param: [attachcode]
	*/
	List<FileUpload> selectAll(String attachcode);

	/**
	 * 根据id修改附件状态
	 * @param FileUpload
	 * @return
	 */
	boolean updateCorrelation(FileUpload FileUpload);

	boolean delByFileName(String filename);
	/**
	 * 自定义新增
	 * @param FileUpload
	 * @return
	 */
	boolean insertAttachfile(FileUpload FileUpload);
}
