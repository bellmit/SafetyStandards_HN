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
package org.springblade.anbiao.jiaoyupeixun.entity;

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
 * @since 2019-04-25
 */
@Data
@TableName("anbiao_jiaoyupeixun_renyuan")
@ApiModel(value = "JiaoyupeixunRenyuan对象", description = "JiaoyupeixunRenyuan对象")
public class JiaoyupeixunRenyuan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键ID")
    private String id;
    /**
     * 教育培训ID
     */
    @ApiModelProperty(value = "教育培训ID",required = true)
    private String jiaoyupeixunid;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String xingming;
    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String bumen;
    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    private String zhiwu;
    /**
     * 是否参加学习
     */
    @ApiModelProperty(value = "是否参加学习")
    private String shifouxuexi;
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
