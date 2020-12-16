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
package org.springblade.anbiao.shigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 事故报告调查处理-事故报告 实体类
 *
 * @author elvis.he
 * @since 2019-04-28
 */
@Data
@TableName("anbiao_shigubaogao")
@ApiModel(value = "Shigubaogao对象", description = "Shigubaogao对象")
public class Shigubaogao implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键id")
    private String id;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    @TableField("dept_id")
    private Integer deptId;
    @ApiModelProperty(value = "企业 名称")
    @TableField(exist = false)
    private String deptName;

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
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String chepaihao;
    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String chexing;
    /**
     * 核载人（吨）数
     */
    @ApiModelProperty(value = "核载人（吨）数")
    private BigDecimal hezaishu = new BigDecimal(0);
    /**
     * 实载人（吨）数
     */
    @ApiModelProperty(value = "实载人（吨）数")
    private BigDecimal shizaishu = new BigDecimal(0);
    /**
     * 危险化学品品名
     */
    @ApiModelProperty(value = "危险化学品品名")
    private String weihuapinming;
    /**
     * 驾驶员姓名
     */
    @ApiModelProperty(value = "驾驶员姓名")
    private String jiashiyuan;
    /**
     * 从业资格类别
     */
    @ApiModelProperty(value = "从业资格类别")
    private String congyezigeleibie;
    /**
     * 从业资格证号
     */
    @ApiModelProperty(value = "从业资格证号")
    private String congyezigezhenghao;
    /**
     * 事故分类
     */
    @ApiModelProperty(value = "事故分类")
    private String shigufenlei;
    /**
     * 事故形态
     */
    @ApiModelProperty(value = "事故形态")
    private String shiguxingtai;
    /**
     * 事故发生时间
     */
    @ApiModelProperty(value = "事故发生时间")
    private LocalDateTime shigufashengshijian;
    /**
     * 事故发生地点
     */
    @ApiModelProperty(value = "事故发生地点")
    private String shigufashengdidian;
    /**
     * 天气情况
     */
    @ApiModelProperty(value = "天气情况")
    private String tianqiqingkuang;
    /**
     * 事发路段公路技术等级
     */
    @ApiModelProperty(value = "事发路段公路技术等级")
    private String gonglujishudengji;
    /**
     * 事发路段线性状况
     */
    @ApiModelProperty(value = "事发路段线性状况")
    private String xianxingzhuangkuang;
    /**
     * 事发路段路面状况
     */
    @ApiModelProperty(value = "事发路段路面状况")
    private String lumianzhuangkuang;
    /**
     * 事故直接原因
     */
    @ApiModelProperty(value = "事故直接原因")
    private String shiguzhijieyuanyin;
    /**
     * 运行线路
     */
    @ApiModelProperty(value = "运行线路")
    private String yunxingxianlu;
    /**
     * 线路类别
     */
    @ApiModelProperty(value = "线路类别")
    private String xianluleibie;
    /**
     * 始发站（地）
     */
    @ApiModelProperty(value = "始发站（地）")
    private String shifazhan;
    /**
     * 车站等级
     */
    @ApiModelProperty(value = "车站等级")
    private String chezhandengji;
    /**
     * 死亡（人）
     */
    @ApiModelProperty(value = "死亡（人）")
    private Integer siwang = 0;
    /**
     * 失踪（人）
     */
    @ApiModelProperty(value = "失踪（人）")
    private Integer shizong = 0;
    /**
     * 受伤（人）
     */
    @ApiModelProperty(value = "受伤（人）")
    private Integer shoushang = 0;
    /**
     * 外籍人员死亡（人）
     */
    @ApiModelProperty(value = "外籍人员死亡（人）")
    private Integer waijisiwang = 0;
    /**
     * 外籍人员失踪（人）
     */
    @ApiModelProperty(value = "外籍人员失踪（人）")
    private Integer waijishizong = 0;
    /**
     * 外籍人员受伤（人）
     */
    @ApiModelProperty(value = "外籍人员受伤（人）")
    private Integer waijishoushang = 0;
    /**
     * 财产损失（元）
     */
    @ApiModelProperty(value = "财产损失（元）")
    private BigDecimal caichansunshi = new BigDecimal(0);
    ;
    /**
     * 事故概况
     */
    @ApiModelProperty(value = "事故概况")
    private String shigugaikuang;
    /**
     * 事故初步原因及责任分析
     */
    @ApiModelProperty(value = "事故初步原因及责任分析")
    private String zerenfenxi;
    /**
     * 事故照片
     */
    @ApiModelProperty(value = "事故照片")
    private String shiguzhaopian;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String fujian;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    private Integer isdel = 0;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
}
