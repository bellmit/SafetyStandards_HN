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
package org.springblade.anbiao.guanlijigouherenyuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2019-04-29
 */
@Data
@TableName("anbiao_personnel")
@ApiModel(value = "Personnel对象", description = "Personnel对象")
public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
	@TableId(value = "id",type = IdType.UUID)
    private String id;
    /**
     * 人员id
     */
    @ApiModelProperty(value = "人员id",required = true)
    private Integer userid;

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
     * 姓名
     */
    @ApiModelProperty(value = "姓名", required = true)
    private String xingming;
    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号", required = true)
    private String shenfenzheng;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String shoujihao;
    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期", required = true)
    private String chushengriqi;
    /**
     * 其他联系方式
     */
    @ApiModelProperty(value = "其他联系方式")
    private String qitalianxifangshi;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String youxiang;
    /**
     * 家庭地址
     */
    @ApiModelProperty(value = "家庭地址")
    private String jiatingdizhi;
    /**
     * 工号
     */
    @ApiModelProperty(value = "工号")
    private String gonghao;
    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
    private String ruzhiriqi;
    /**
     * 工作经历
     */
    @ApiModelProperty(value = "工作经历")
    private String gongzuojingli;
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
     * 删除
     */
    @ApiModelProperty(value = "删除")
    private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
	/**
	 * 账号
	 */
	@ApiModelProperty(value = "账号")
	@TableField(exist = false)
	private String account;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	@TableField(exist = false)
	private String password;

	/**
	 * 岗位id
	 */
	@ApiModelProperty(value = "岗位id")
	private String postId;
}
