package org.springblade.alarm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 超速报警 疲劳报警 主动安全 实体类
 */

@Data
@TableName("baobiao_alarmvehdailyreport")
@ApiModel(value = "Alarmvehdailyreport对象", description = "Alarmvehdailyreport对象")
public class Alarmvehdailyreport implements Serializable {
	private static final long serialVersionUID = 1L;



//	private Integer id;
//	@ApiModelProperty(value = "企业")
	@TableId("company")
	private String company;

	@ApiModelProperty(value = "车辆牌照")
	@TableId("Cheliangpaizhao")
	private String	cheliangpaizhao;

	@ApiModelProperty(value = "车牌颜色")
	@TableId("Chepaiyanse")
	private String	chepaiyanse;

	@ApiModelProperty(value = "时间")
	@TableId("Date")
	private Date date;

	@ApiModelProperty(value = "报警次数")
	@TableId("Baojingcishu")
	private Integer	baojingcishu;

	@ApiModelProperty(value = "主动报警次数")
	@TableId("Zhudongbaojingcishu")
	private Integer		zhudongbaojingcishu;

	@ApiModelProperty(value = "超速")
	@TableId("Chaosu")
	private Integer		chaosu;

	@ApiModelProperty(value = "疲劳")
	@TableId("Pilao")
	private Integer		pilao;

	@ApiModelProperty(value = "夜间")
	@TableId("Yejian")
	private Integer		yejian;

	@ApiModelProperty(value = "不在线")
	@TableId("Buzaixian")
	private Integer		buzaixian;

	@ApiModelProperty(value = "不定位")
	@TableId("Budingwei")
	private Integer		budingwei;

	@ApiModelProperty(value = "疲劳视频")
	@TableId("Pilaoshipin")
	private Integer		pilaoshipin;

	@ApiModelProperty(value = "打电话")
	@TableId("Dadianhua")
	private Integer		dadianhua;

	@ApiModelProperty(value = "抽烟")
	@TableId("Chouyan")
	private Integer		chouyan;

	@ApiModelProperty(value = "分神")
	@TableId("Fenshen")
	private Integer		fenshen;

	@ApiModelProperty(value = "严重次数")
	@TableId("Yanzhongcishu")
	private Integer		yanzhongcishu;

	@ApiModelProperty(value = "严重超速")
	@TableId("Yanzhongchaosu")
	private Integer		yanzhongchaosu;

	@ApiModelProperty(value = "严重疲劳")
	@TableId("Yanzhongpilao")
	private Integer		yanzhongpilao;

	@ApiModelProperty(value = "创建时间")
	@TableId("createtime")
	private  Date	createtime;


	@ApiModelProperty(value = "超速处理")
	@TableId("Chaosucl")
	private Integer		chaosucl;

	@ApiModelProperty(value = "疲劳处理")
	@TableId("Pilaocl")
	private Integer		pilaocl;

	@ApiModelProperty(value = "夜间处理")
	@TableId("Yejiancl")
	private Integer		yejiancl;

	@ApiModelProperty(value = "不在线处理")
	@TableId("Buzaixiancl")
	private Integer		buzaixiancl;

	@ApiModelProperty(value = "不定位处理")
	@TableId("Budingweicl")
	private Integer		budingweicl;

	@ApiModelProperty(value = "疲劳视频处理")
	@TableId("Pilaoshipincl")
	private Integer		pilaoshipincl;

	@ApiModelProperty(value = "打电话处理")
	@TableId("Dadianhuacl")
	private Integer		dadianhuacl;

	@ApiModelProperty(value = "抽烟处理")
	@TableId("Chouyancl")
	private Integer		chouyancl;

	@ApiModelProperty(value = "分神处理")
	@TableId("Fenshencl")
	private Integer		fenshencl;
	@ApiModelProperty(value = "处理率")
	@TableId("chulilv")
	private String chulilv;
	@ApiModelProperty(value = "处理信息")
	@TableId("chulixinxing")
	private String chulixinxing;



}
