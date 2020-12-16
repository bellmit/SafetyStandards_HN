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
package org.springblade.app.yingjichuzhi.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类
 * @author 呵呵哒
 */
@Data
@TableName("anbiao_yingjichuzhilei")
@ApiModel(value = "Yingjichuzhilei对象", description = "Yingjichuzhilei对象")
public class Yingjichuzhilei implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 应急处置id
     */
    @ApiModelProperty(value = "应急处置id")
    private String yingjichuzhiid;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;
    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String path;
	/**
	 * pdf文件路径
	 */
	@ApiModelProperty(value="pdf文件路径")
	private String pdfpath;
	/**
	 * 图片文件路径
	 */
	@ApiModelProperty(value="图片路径",required = true)
	private String tupianpath;
	/**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    private String name;
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
     * 删除
     */
    @TableLogic
    @ApiModelProperty(value = "删除")
	@TableField("is_deleted")
    private Integer isdel;
    /**
     * 创建时间
     */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;



}
