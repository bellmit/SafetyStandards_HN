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
@TableName("anbiao_cheliangbaoxian")
@ApiModel(value = "Cheliangbaoxian对象", description = "Cheliangbaoxian对象")
public class Cheliangbaoxian implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
//	@TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id",required = true)
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
     * 自编号
     */
    @ApiModelProperty(value = "自编号")
    private String zibianhao;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id",required = true)
    private String cheliangid;
    /**
     * 照片
     */
    @ApiModelProperty(value = "照片")
    private String zhaopian;
    /**
     * 记录人
     */
    @ApiModelProperty(value = "记录人")
    private String jiluren;
    /**
     * 登记人
     */
    @ApiModelProperty(value = "登记人")
    private String dengjiren;
    /**
     * 被保险人
     */
    @ApiModelProperty(value = "被保险人")
    private String beibaoxianren;
    /**
     * 登记时间
     */
    @ApiModelProperty(value = "登记时间")
    private String dengjishijian;
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
