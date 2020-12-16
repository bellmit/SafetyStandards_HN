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
package org.springblade.anbiao.richenganpai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-06-06
 */
@Data
@TableName("anbiao_richenganpai")
@ApiModel(value = "Richenganpai对象", description = "Richenganpai对象")
public class Richenganpai implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
    /**
     * 单位di
     */
    @ApiModelProperty(value = "单位di",required=true)
    private Integer deptId;
    /**
     * 任务类型
     */
    @ApiModelProperty(value = "任务类型",required=true)
    private String renwuleixing;
    /**
     * 任务标题
     */
    @ApiModelProperty(value = "任务标题",required=true)
    private String renwubiaoti;
    /**
     * 安排人
     */
    @ApiModelProperty(value = "安排人",required=true)
    private String anpairen;
    /**
     * 安排人id
     */
    @ApiModelProperty(value = "安排人id",required=true)
    private Integer anpairenId;
    /**
     * 责任人
     */
    @ApiModelProperty(value = "责任人",required=true)
    private String zerenren;
    /**
     * 责任人id
     */
    @ApiModelProperty(value = "责任人id",required=true)
    private Integer zerenrenId;
    /**
     * 执行人
     */
    @ApiModelProperty(value = "执行人")
    private String zhixingrens;
    /**
     * 执行人id
     */
    @ApiModelProperty(value = "执行人id")
    private String zhixingrenIds;
    /**
     * 是否紧急(0否,1是)
     */
    @ApiModelProperty(value = "是否紧急(0否,1是)",required=true)
    private Integer isJinji;
    /**
     * 是否重要(0否,1是)
     */
    @ApiModelProperty(value = "是否重要(0否,1是)",required=true)
    private Integer isZhongyao;
    /**
     * 任务开始时间
     */
    @ApiModelProperty(value = "任务开始时间",required=true)
    private String renwukaishishijian;
    /**
     * 任务截止时间
     */
    @ApiModelProperty(value = "任务截止时间",required=true)
    private String renwujiezhishijian;

	/**
	 * 任务地点
	 */
	@ApiModelProperty(value = "任务地点",required=true)
    private String renwudidian;
    /**
     * 任务内容
     */
    @ApiModelProperty(value = "任务内容",required=true)
    private String renwuneirong;
    /**
     * 自我评价
     */
    @ApiModelProperty(value = "自我评价")
    private String ziwozongjie;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;
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
     * 是否完成(0否,1是)
     */
    @ApiModelProperty(value = "是否完成(0否,1是,2超期完成)")
    private Integer isFinish;


}
