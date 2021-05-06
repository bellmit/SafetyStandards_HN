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
 * @author 呵呵哒
 */
@Data
@TableName("anbiao_terminal")
@ApiModel(value = "Terminal对象", description = "Terminal对象")
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
//	@TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 终端类型
     */
    @ApiModelProperty(value = "终端类型")
    private String terminalType;
    /**
     * 终端协议名称
     */
    @ApiModelProperty(value = "终端协议名称")
    private String terminalScheme;
    /**
     * 厂牌型号
     */
    @ApiModelProperty(value = "厂牌型号")
    private String brandModel;
    /**
     * 终端型号
     */
    @ApiModelProperty(value = "终端型号")
    private String terminalModel;
    /**
     * 终端生产厂家
     */
    @ApiModelProperty(value = "终端生产厂家")
    private String terminalManufacturer;
    /**
     * 终端厂家编号
     */
    @ApiModelProperty(value = "终端厂家编号")
    private String terminalNumber;
    /**
     * 行驶记录仪版本
     */
    @ApiModelProperty(value = "行驶记录仪版本")
    private String tachographsVersions;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createtime;
    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    private String createid;
    /**
     * 创建者名称
     */
    @ApiModelProperty(value = "创建者名称")
    private String createname;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private String updatetime;
    /**
     * 修改者ID
     */
    @ApiModelProperty(value = "修改者ID")
    private String updateid;
    /**
     * 修改者名称
     */
    @ApiModelProperty(value = "修改者名称")
    private String updatename;
	/**
	 * 是否删除
	 */
	@ApiModelProperty(value = "是否删除")
	private Integer isdelete;
}
