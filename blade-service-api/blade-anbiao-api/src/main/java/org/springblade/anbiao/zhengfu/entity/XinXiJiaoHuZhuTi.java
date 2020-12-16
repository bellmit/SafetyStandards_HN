/**
 * Copyright (C), 2015-2020,
 * FileName: XinXiJiaoHuZhuTi
 * Author:   呵呵哒
 * Date:     2020/6/20 15:52
 * Description:
 */
package org.springblade.anbiao.zhengfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/6/20
 * @描述
 */
@Data
@TableName("anbiao_xinxijiaohuzhutibiao")
@ApiModel(value = "XinXiJiaoHuZhuTi对象", description = "XinXiJiaoHuZhuTi对象")
public class XinXiJiaoHuZhuTi implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID")
	private String id;

	/**
	 * 主题名称
	 */
	@ApiModelProperty(value = "主题名称")
	private String zhutimingcheng;

	/**
	 * 主题正文
	 */
	@ApiModelProperty(value = "主题正文")
	private String zhutizhengwen;

	/**
	 * 政府用户ID
	 */
	@ApiModelProperty(value = "政府用户ID")
	private String zhengfuyonghuid;

	/**
	 * 企业用户ID
	 */
	@ApiModelProperty(value = "企业用户ID")
	private String qiyeyonghuid;

	/**
	 * 发起时间
	 */
	@ApiModelProperty(value = "发起时间")
	private String faqishijian;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态（0：正常；1：需要回复；9：删除；）")
	private String zhuangtai;

	/**
	 * 附件
	 */
	@ApiModelProperty(value = "附件")
	private String fujian;

	@ApiModelProperty(value = "附件名称")
	private String fujianname;

	/**
	 * 发送单位ID
	 */
	@ApiModelProperty(value = "发送单位ID")
	private String fasongdanweiid;

	/**
	 * 送达单位ID
	 */
	@ApiModelProperty(value = "送达单位ID")
	private String songdadanweiid;

	/**
	 * 送达单位
	 */
	@ApiModelProperty(value = "送达单位")
	private String songdadanwei;

	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型（1：通知公告；2：安全查岗；3：文件下发；4：下发整改）")
	private Integer type;

	/**
	 * 文件类型
	 */
	@ApiModelProperty(value = "文件类型")
	private String wenjianleixing;

	/**
	 * 回复有效期
	 */
	@ApiModelProperty(value = "回复有效期")
	private String huifuyouxiaoqi;


	/**
	 * 整改时间
	 */
	@ApiModelProperty(value = "整改时间")
	private String zhenggaishijian;

	/**
	 * 控制分数
	 */
	@ApiModelProperty(value = "控制分数")
	private String kongzhifenshu;

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
	 * 下发企业数
	 */
	@ApiModelProperty(value = "下发企业数")
	private Integer xiafaqiyeshu;

	/**
	 * 回复企业数
	 */
	@ApiModelProperty(value = "回复企业数")
	private Integer huifuqiyeshu;

	/**
	 * 未回复企业数
	 */
	@ApiModelProperty(value = "未回复企业数")
	private Integer weihuifuqiyeshu;

	/**
	 * 发起单位
	 */
	@ApiModelProperty(value = "发起单位")
	private String fasongdanwei;

	/**
	 * 单位名称
	 */
	@ApiModelProperty(value = "单位名称")
	private String deptName;

	/**
	 * 单位ID
	 */
	@ApiModelProperty(value = "单位ID")
	private String deptId;

	/**
	 * 回复时间
	 */
	@ApiModelProperty(value = "回复时间")
	private String huifushijian;

	/**
	 * 回复正文
	 */
	@ApiModelProperty(value = "回复正文")
	private String huifuzhengwen;

	/**
	 * 回复用户ID
	 */
	@ApiModelProperty(value = "回复用户ID")
	private String userId;

	/**
	 * 回复用户名称
	 */
	@ApiModelProperty(value = "回复用户名称")
	private String userName;

}
