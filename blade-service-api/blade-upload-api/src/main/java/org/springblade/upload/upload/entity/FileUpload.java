package org.springblade.upload.upload.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: SafetyStandards
 * @description: FileUpload
 * @author: hyp
 * @create: 2019-04-11 10:48
 **/
@Data
@TableName("blade_attachfiles")
public class FileUpload {

	private String id;

	private String attachcode;

	private int userid;

	private String userName;

	private String fileName;

	private String fileSaveName;

	private int quoteTimes;

	private String uploadTime;

	private long fileSize;

	private BigDecimal fileType;

	private String floder;
	@TableField(exist = false)
	private String wenjianid;

	private BigDecimal compressed;
	@TableField(exist = false)
	private String wenjianleixing;

	private String path;

	private String correlation;
}
