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
package org.springblade.anbiao.yingjijiuyuan.entity;

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
 * @since 2019-04-29
 */
@Data
@TableName("anbiao_yingjizhuangbei_weihu")
@ApiModel(value = "YingjizhuangbeiWeihu对象", description = "YingjizhuangbeiWeihu对象")
public class YingjizhuangbeiWeihu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	@TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 应急装备ID
     */
    @ApiModelProperty(value = "应急装备ID",required = true)
    private String yingjizhuangbeiid;
    /**
     * 检查日期
     */
    @ApiModelProperty(value = "检查日期")
    private String jianchariqi;
    /**
     * 检查结果
     */
    @ApiModelProperty(value = "检查结果")
    private String jianchajieguo;
    /**
     * 检查人
     */
    @ApiModelProperty(value = "检查人")
    private String jiancharen;
    /**
     * 检查项目
     */
    @ApiModelProperty(value = "检查项目")
    private String jianchaxiangmu;
    /**
     * 是否更换零件
     */
    @ApiModelProperty(value = "是否更换零件")
    private String shifougenghuanlingjian;
    /**
     * 确认人
     */
    @ApiModelProperty(value = "确认人")
    private String querenren;
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
}
