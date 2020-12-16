/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 */
package org.springblade.anbiao.cheliangguanli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 */
@Data
@TableName("anbiao_cheliangbaofei")
@ApiModel(value = "Cheliangbaofei对象", description = "Cheliangbaofei对象")
public class Cheliangbaofei implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
	@TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID",required = true)
    private Integer deptId;
    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String caozuoren;
    /**
     * 操作人id
     */
    @ApiModelProperty(value = "操作人id")
    private Integer caozuorenid;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private String caozuoshijian;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id",required = true)
    private String cheliangid;
    /**
     * 驾驶员
     */
    @ApiModelProperty(value = "驾驶员")
    private String jishiyuan;
    /**
     * 注册登记时间
     */
    @ApiModelProperty(value = "注册登记时间")
    private String zhucedengjishijian;
    /**
     * 类型等级
     */
    @ApiModelProperty(value = "类型等级")
    private String leixingdengji;
    /**
     * 核定载客
     */
    @ApiModelProperty(value = "核定载客")
    private String hedingzaike;
    /**
     * 强制报废日期
     */
    @ApiModelProperty(value = "强制报废日期")
    private String qiangzhibaofeiriqi;
    /**
     * 实际报废日期
     */
    @ApiModelProperty(value = "实际报废日期")
    private String shijibaofeiriqi;
    /**
     * 报废人
     */
    @ApiModelProperty(value = "报废人")
    private String baofeiren;
    /**
     * 报废原因
     */
    @ApiModelProperty(value = "报废原因")
    private String baofeiyuanyin;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String beizhu;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String fujian;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isdelete;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
}
