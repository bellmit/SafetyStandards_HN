package org.springblade.upload.upload.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: SafetyStandards
 * @description:
 * @author: hyp
 * @create2021-05-17 10:24
 **/
@Data
public class FileObj implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "文件名")
	private String name;
	@ApiModelProperty(value = "url")
	private String url;
	@ApiModelProperty(value = "savename")
	private  String savename;
	@ApiModelProperty(value = "id")
	private  String id;
}
