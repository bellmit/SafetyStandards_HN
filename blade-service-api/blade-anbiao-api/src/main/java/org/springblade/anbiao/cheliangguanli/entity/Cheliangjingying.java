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
import java.time.LocalDateTime;

/**
 * 实体类
 */
@Data
@TableName("anbiao_cheliangjingying")
@ApiModel(value = "Cheliangjingying对象", description = "Cheliangjingying对象")
public class Cheliangjingying implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
	@TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID",required = true)
    private Integer deptId;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id",required = true)
    private String cheliangid;
    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String caozuoren;
    /**
     * 操作人Id
     */
    @ApiModelProperty(value = "操作人Id")
    private Integer caozuorenid;
    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private String caozuoshijian;
    /**
     * 经营性质
     */
    @ApiModelProperty(value = "经营性质")
    private String jingyingxingzhi;
    /**
     * 经营范围
     */
    @ApiModelProperty(value = "经营范围")
    private String jingyingfanwei;
    /**
     * 道路运输证
     */
    @ApiModelProperty(value = "道路运输证", required = true)
    private String daoluyunshuzheng;
    /**
     * 品名
     */
    @ApiModelProperty(value = "品名")
    private String pinming;
    /**
     * 类型等级
     */
    @ApiModelProperty(value = "类型等级")
    private String leixingdengji;
    /**
     * 技术等级
     */
    @ApiModelProperty(value = "技术等级")
    private String jishudengji;
    /**
     * 月管理费
     */
    @ApiModelProperty(value = "月管理费")
    private String yueguanlifei;
    /**
     * 线路标志编号
     */
    @ApiModelProperty(value = "线路标志编号")
    private String xianlubiaozhibianhao;
    /**
     * 经营开始日期
     */
    @ApiModelProperty(value = "经营开始日期")
    private String jingyingkaishiriqi;
    /**
     * 经营截止日期
     */
    @ApiModelProperty(value = "经营截止日期", required = true)
    private String jingyingjiezhiriqi;
    /**
     * 农村客运
     */
    @ApiModelProperty(value = "农村客运")
    private String nongcunkeyun;
    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号")
    private String hetongbianhao;
    /**
     * 合同有效期
     */
    @ApiModelProperty(value = "合同有效期")
    private String hetongyouxiaoqi;
    /**
     * 事业部
     */
    @ApiModelProperty(value = "事业部")
    private String shiyebu;
    /**
     * 企业持有股份
     */
    @ApiModelProperty(value = "企业持有股份")
    private String qiyechiyougufen;
    /**
     * 自编号
     */
    @ApiModelProperty(value = "自编号")
    private String zibianhao;
    /**
     * 行政许可编号
     */
    @ApiModelProperty(value = "行政许可编号", required = true)
    private String xingzhengxukebianhao;
    /**
     * 登记证书编号
     */
    @ApiModelProperty(value = "登记证书编号")
    private String dengjizhengshubianhao;
    /**
     * 运输证发放日
     */
    @ApiModelProperty(value = "运输证发放日")
    private String yunshuzhengfafangri;
    /**
     * 运输证有效期
     */
    @ApiModelProperty(value = "运输证有效期", required = true)
    private String yunshuzhengyouxiaoqi;
    /**
     * 行政许可期限
     */
    @ApiModelProperty(value = "行政许可期限", required = true)
    private String xingzhengxukeqixian;
    /**
     * 行驶证发放日
     */
    @ApiModelProperty(value = "行驶证发放日")
    private String xingshizhengfafangri;
    /**
     * 行驶证注册日
     */
    @ApiModelProperty(value = "行驶证注册日")
    private String xingshizhengzhuceri;
    /**
     * 检验有效期
     */
    @ApiModelProperty(value = "检验有效期")
    private String jianyanyouxiaoqi;
    /**
     * 运行线路
     */
    @ApiModelProperty(value = "运行线路")
    private String yunxingxianlu;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String fujian;
    /**
     * 运输证附件
     */
    @ApiModelProperty(value = "运输证附件", required = true)
    private String yunshuzhengfujian;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String beizhu;
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
