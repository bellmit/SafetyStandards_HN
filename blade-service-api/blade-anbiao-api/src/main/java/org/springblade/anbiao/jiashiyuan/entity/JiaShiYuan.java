package org.springblade.anbiao.jiashiyuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by you on 2019/4/22.
 */
@Data
@TableName("anbiao_jiashiyuan")
@ApiModel(value = "JiaShiYuan对象", description = "JiaShiYuan对象")
public class JiaShiYuan implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.UUID)
	private String id;

	/**
	 * 驾驶员姓名
	 */
	@ApiModelProperty(value = "驾驶员姓名",required = true)
	private String jiashiyuanxingming;

	/**
	 * 照片
	 */
	@ApiModelProperty(value = "照片")
	private String zhaopian;

	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	private String xingbie;

	/**
	 * 身份证号
	 */
	@ApiModelProperty(value = "身份证号", required = true)
	private String shenfenzhenghao;

	/**
	 * 出生时间
	 */
	@ApiModelProperty(value = "出生时间")
	private String chushengshijian;

	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄")
	private String nianling;

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码", required = true)
	private String shoujihaoma;

	/**
	 * 从业人员类型
	 */
	@ApiModelProperty(value = "从业人员类型",required = true)
	private String congyerenyuanleixing;

	/**
	 * 身份证有效期
	 */
	@ApiModelProperty(value = "身份证有效期",required = true)
	private String shenfenzhengyouxiaoqi;

	/**
	 * 文化程度
	 */
	@ApiModelProperty(value = "文化程度")
	private String wenhuachengdu;

	/**
	 * 聘用日期
	 */
	@ApiModelProperty(value = "聘用日期")
	private String pingyongriqi;

	/**
	 * 机动驾驶员
	 */
	@ApiModelProperty(value = "机动驾驶员")
	private String jidongjiashiyuan;

	/**
	 * 驾驶员类型
	 */
	@ApiModelProperty(value = "驾驶员类型",required = true)
	private String jiashiyuanleixing;

	/**
	 * 所属单位ID
	 */
	@ApiModelProperty(value = "所属单位ID",required = true)
	private Integer deptId;


	/**
	 * 身份证复印件
	 */
	@ApiModelProperty(value = "身份证复印件")
	private String shenfenzhengfujian;

	/**
	 * 从业证复印件
	 */
	@ApiModelProperty(value = "从业证复印件")
	private String congyezhengfujian;

	/**
	 * 驾驶证复印件
	 */
	@ApiModelProperty(value = "驾驶证复印件")
	private String jiashizhengfujian;

	/**
	 * 家庭住址
	 */
	@ApiModelProperty(value = "家庭住址")
	private String jiatingzhuzhi;

	/**
	 * 档案编号
	 */
	@ApiModelProperty(value = "档案编号")
	private String danganbianhao;

	/**
	 * 驾驶证号
	 */
	@ApiModelProperty(value = "驾驶证号")
	private String jiashizhenghao;

	/**
	 * 准驾车型
	 */
	@ApiModelProperty(value = "准驾车型")
	private String zhunjiachexing;

	/**
	 * 驾龄
	 */
	@ApiModelProperty(value = "驾龄")
	private String jialing;

	/**
	 * 违法记分
	 */
	@ApiModelProperty(value = "违法记分")
	private String weifajifen;

	/**
	 * 驾驶证初领日期
	 */
	@ApiModelProperty(value = "驾驶证初领日期")
	private String jiashizhengchulingriqi;

	/**
	 * 驾驶证有效期
	 */
	@ApiModelProperty(value = "驾驶证有效期",required = true)
	private String jiashizhengyouxiaoqi;

	/**
	 * 体检有效期
	 */
	@ApiModelProperty(value = "体检有效期",required = true)
	private String tijianyouxiaoqi;

	/**
	 * 体检日期
	 */
	@ApiModelProperty(value = "体检日期",required = true)
	private String tijianriqi;

	/**
	 * 从业资格证
	 */
	@ApiModelProperty(value = "从业资格证",required = true)
	private String congyezigezheng;

	/**
	 * 从业类别
	 */
	@ApiModelProperty(value = "从业类别")
	private String congyeleibie;

	/**
	 * 从业证有效期
	 */
	@ApiModelProperty(value = "从业证有效期",required = true)
	private String congyezhengyouxiaoqi;

	/**
	 * 从业证初领日期
	 */
	@ApiModelProperty(value = "从业证初领日期")
	private String congyezhengchulingri;

	/**
	 * 证件核发机关
	 */
	@ApiModelProperty(value = "证件核发机关")
	private String zhengjianhefajiguan;

	/**
	 * 发证机关
	 */
	@ApiModelProperty(value = "发证机关")
	private String fazhengjiguan;

	/**
	 * 诚信考核时间
	 */
	@ApiModelProperty(value = "诚信考核时间")
	private String chengxinkaoheshijian;

	/**
	 * 下次诚信考核时间
	 */
	@ApiModelProperty(value = "下次诚信考核时间")
	private String xiacichengxinkaoheshijian;

	/**
	 * 继续教育时间
	 */
	@ApiModelProperty(value = "继续教育时间")
	private String jixujiaoyushijian;

	/**
	 * 下次继续教育时间
	 */
	@ApiModelProperty(value = "下次继续教育时间")
	private String xiacijixujiaoyushijian;

	/**
	 * 从业资格类别
	 */
	@ApiModelProperty(value = "从业资格类别")
	private String congyezigeleibie;

	/**
	 * 证件状态
	 */
	@ApiModelProperty(value = "证件状态")
	private String zhengjianzhuangtai;

	/**
	 * 护照号码
	 */
	@ApiModelProperty(value = "护照号码")
	private String huzhaohaoma;

	/**
	 * 护照类别
	 */
	@ApiModelProperty(value = "护照类别")
	private String huzhaoleibie;

	/**
	 * 国家码
	 */
	@ApiModelProperty(value = "国家码")
	private String guojiama;

	/**
	 * 护照有效期
	 */
	@ApiModelProperty(value = "护照有效期")
	private String huzhaoyouxiaoqi;

	/**
	 * 准驾证号
	 */
	@ApiModelProperty(value = "准驾证号")
	private String zhunjiazhenghao;

	/**
	 * 准驾类型
	 */
	@ApiModelProperty(value = "准驾类型")
	private String zhunjialeixing;

	/**
	 * 准运线
	 */
	@ApiModelProperty(value = "准运线")
	private String zhunyunxian;

	/**
	 * 准驾证有效期
	 */
	@ApiModelProperty(value = "准驾证有效期")
	private String zhunjiazhengyouxiaoqi;

	/**
	 * 缴纳标准
	 */
	@ApiModelProperty(value = "缴纳标准")
	private String jiaonabiaozhun;

	/**
	 * 缴纳金额
	 */
	@ApiModelProperty(value = "缴纳金额")
	private String jiaonajine;

	/**
	 * 是否缴纳
	 */
	@ApiModelProperty(value = "是否缴纳")
	private String shifoujiaona;
	/**
	 * 超速违法记录
	 */
	@ApiModelProperty(value = "超速违法记录")
	private String chaosuweifajilu;

	/**
	 * 交通违法记录
	 */
	@ApiModelProperty(value = "交通违法记录")
	private String jiaotongweifajilu;

	/**
	 * 致人死亡责任
	 */
	@ApiModelProperty(value = "致人死亡责任")
	private String zhirensiwangzeren;

	/**
	 * 违规类型
	 */
	@ApiModelProperty(value = "违规类型")
	private String weiguileixing;

	/**
	 * 驾车经历
	 */
	@ApiModelProperty(value = "驾车经历")
	private String jiachejingli;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String beizhu;

	/**
	 * 复印件
	 */
	@ApiModelProperty(value = "复印件")
	private String fuyinjian;

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
	 * 操作人
	 */
	@ApiModelProperty(value = "操作人")
	private String caozuoren;

	/**
	 * 部门
	 */
	@ApiModelProperty(value = "部门")
	private String bumen;

	/**
	 * 离职时间
	 */
	@ApiModelProperty(value = "离职时间")
	private String lizhishijian;

	/**
	 * 登陆密码
	 */
	@ApiModelProperty(value = "登陆密码")
	private String denglumima;

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
	 * 导入错误信息
	 */
	@ApiModelProperty(value = "导入错误信息")
	@TableField(exist = false)
	private String Msg;
	/**
	 * 导入错误信息2
	 */
	@ApiModelProperty(value = "导入错误信息2")
	@TableField(exist = false)
	private boolean Msg2;

	@ApiModelProperty(value = "导入错误信息图标")
	@TableField(exist = false)
	private String importUrl;
}
