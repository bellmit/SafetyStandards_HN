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
package org.springblade.anbiao.anquanmubiao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-04-28
 */
@Data
@TableName("anbiao_niandujihua")
@ApiModel(value = "Niandujihua对象", description = "Niandujihua对象")
public class Niandujihua implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	@TableId(value = "id",type = IdType.UUID)
    @ApiModelProperty(value = "ID")
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
     * 操作人ID
     */
    @ApiModelProperty(value = "操作人ID")
    private Integer caozuorenid;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private String caozuoshijian;
    /**
     * 中长期规划ID
     */
    @ApiModelProperty(value = "中长期规划ID",required = true)
    private String guihuaid;
    /**
     * 计划名称
     */
    @ApiModelProperty(value = "计划名称")
    private String jihuamingcheng;
    /**
     * 计划类型
     */
    @ApiModelProperty(value = "计划类型")
    private String jihualeixing;
    /**
     * 制定日期
     */
    @ApiModelProperty(value = "制定日期")
    private String zhidingriqi;
    /**
     * 计划内容
     */
    @ApiModelProperty(value = "计划内容")
    private String jihuaneirong;
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
