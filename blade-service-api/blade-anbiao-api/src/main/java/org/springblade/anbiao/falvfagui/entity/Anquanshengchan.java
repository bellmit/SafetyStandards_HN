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
package org.springblade.anbiao.falvfagui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-04-24
 */
@Data
@TableName("anbiao_gangweianquanshengchancaozuoliucheng")
@ApiModel(value = "Anquanshengchan对象", description = "Anquanshengchan对象")
public class Anquanshengchan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键ID")
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
     * 规程名称
     */
    @ApiModelProperty(value = "规程名称")
    private String guichengmingcheng;
    /**
     * 规程类别
     */
    @ApiModelProperty(value = "规程类别")
    private String guichengleibie;
    /**
     * 制定日期
     */
    @ApiModelProperty(value = "制定日期")
    private String zhidingriqi;
    /**
     * 使用部门
     */
    @ApiModelProperty(value = "使用部门")
    private String shiyongbumen;
    /**
     * 规程简述
     */
    @ApiModelProperty(value = "规程简述")
    private String guichengjianshu;
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
