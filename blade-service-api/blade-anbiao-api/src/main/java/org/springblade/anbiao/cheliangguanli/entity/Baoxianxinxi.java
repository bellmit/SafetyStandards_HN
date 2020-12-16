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
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 * @author 呵呵哒
 */
@Data
@TableName("anbiao_baoxianxinxi")
@ApiModel(value = "Baoxianxinxi对象", description = "Baoxianxinxi对象")
public class Baoxianxinxi implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
	@TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 投保公司
     */
    @ApiModelProperty(value = "投保公司")
    private String toubaogongsi;
    /**
     * 保险单号
     */
    @ApiModelProperty(value = "保险单号")
    private String baoxiandanhao;
    /**
     * 投保类型
     */
    @ApiModelProperty(value = "投保类型")
    private String toubaoleixing;
    /**
     * 购买项目
     */
    @ApiModelProperty(value = "购买项目")
    private String goumaixiangmu;
    /**
     * 购买金额
     */
    @ApiModelProperty(value = "购买金额")
    private String goumaijine;
    /**
     * 保费
     */
    @ApiModelProperty(value = "保费")
    private String baofei;
    /**
     * 保额
     */
    @ApiModelProperty(value = "保额")
    private String baoe;
    /**
     * 起保时间
     */
    @ApiModelProperty(value = "起保时间")
    private String qibaoshijian;
    /**
     * 终保时间
     */
    @ApiModelProperty(value = "终保时间", required = true)
    private String zhongbaoshijian;
    /**
     * 出单时间
     */
    @ApiModelProperty(value = "出单时间")
    private String chudanshijian;
    /**
     * 领取人
     */
    @ApiModelProperty(value = "领取人")
    private String lingquren;
    /**
     * 领取时间
     */
    @ApiModelProperty(value = "领取时间")
    private String lingqushijian;
    /**
     * 正本交接人
     */
    @ApiModelProperty(value = "正本交接人")
    private String zhengbenjieshouren;
    /**
     * 正本交接时间
     */
    @ApiModelProperty(value = "正本交接时间")
    private String zhengbenjiaojieshijian;
    /**
     * 发票交接时间
     */
    @ApiModelProperty(value = "发票交接时间")
    private String fapiaojiaojieshijian;
    /**
     * 发票交接人
     */
    @ApiModelProperty(value = "发票交接人")
    private String fapiaojieshouren;
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
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isdelete;
    /**
     * 保险ID
     */
    @ApiModelProperty(value = "保险ID", required = true)
    private String baoxianid;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
}
