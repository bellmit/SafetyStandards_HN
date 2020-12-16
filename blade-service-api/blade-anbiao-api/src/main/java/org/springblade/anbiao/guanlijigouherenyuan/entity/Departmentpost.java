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
package org.springblade.anbiao.guanlijigouherenyuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("anbiao_departmentpost")
@ApiModel(value = "Departmentpost对象", description = "Departmentpost对象")
public class Departmentpost implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
	@TableId(value = "id",type = IdType.UUID)
    private String id;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id")
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
     * 部门/岗位名称
     */
    @ApiModelProperty(value = "部门/岗位名称")
    private String mingcheng;
    /**
     * 部门/岗位类型
     */
    @ApiModelProperty(value = "部门/岗位类型")
    private String leixing;
    /**
     * 部门/岗位负责人
     */
    @ApiModelProperty(value = "部门/岗位负责人")
    private String fuzeren;
    /**
     * 部门/岗位职责
     */
    @ApiModelProperty(value = "部门/岗位职责")
    private String gangweizhize;
    /**
     * 部门/岗位安全职责
     */
    @ApiModelProperty(value = "部门/岗位安全职责")
    private String anquanzhize;
    /**
     * 类型(部门/岗位)
     */
    @ApiModelProperty(value = "类型(部门/岗位)")
    private String type;

	/**
	 * 逻辑删除
	 */
	@ApiModelProperty(value = "逻辑删除")
  	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
	/**
	 * 机构名称
	 */
	@ApiModelProperty(value = "机构名称")
	@TableField(exist = false)
	private String deptName;

	/**
	 * 上级id
	 */
	@ApiModelProperty(value = "上级id")
	@TableField(exist = false)
	private String parentId;

	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型(区分部门/岗位)")
	@TableField(exist = false)
	private String extendType;
}
