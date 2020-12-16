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
@TableName("anbiao_guanchejianchaxinxi")
@ApiModel(value = "Guanchejianchaxinxi对象", description = "Guanchejianchaxinxi对象")
public class Guanchejianchaxinxi implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
	@TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 罐车检查id
     */
    @ApiModelProperty(value = "罐车检查id",required = true)
    private String guanchejianchaid;
    /**
     * 检查单位
     */
    @ApiModelProperty(value = "检查单位")
    private String jianchadanwei;
    /**
     * 检查项
     */
    @ApiModelProperty(value = "检查项")
    private String jianchaxiang;
    /**
     * 检测人
     */
    @ApiModelProperty(value = "检测人")
    private String jianceren;
    /**
     * 检测时间
     */
    @ApiModelProperty(value = "检测时间")
    private String jianceshijian;
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
     * 到期时间
     */
    @ApiModelProperty(value = "到期时间", required = true)
    private String daoqishijian;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String beizhu;
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
