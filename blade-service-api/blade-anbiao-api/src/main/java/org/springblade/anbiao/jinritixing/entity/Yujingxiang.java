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
package org.springblade.anbiao.jinritixing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 * @author hyp
 * @since 2020-11-12
 */
@Data
@TableName("anbiao_yujingxiang")
@ApiModel(value = "Yujingxiang对象", description = "Yujingxiang对象")
public class Yujingxiang implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
    /**
     * 预警项
     */
    @ApiModelProperty(value = "预警项")
    private String yujingxiang;
    /**
     * URL
     */
    @ApiModelProperty(value = "URL")
    private String url;

    /**
     * 预警分类
     */
    @ApiModelProperty(value = "预警分类")
    private String yujingfenlei;
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bianhao;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String shuoming;
}
