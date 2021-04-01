/**
 * Copyright (C), 2015-2020,
 * FileName: GpsVehicle
 * Author:   呵呵哒
 * Date:     2020/7/3 10:29
 * Description:
 */
package org.springblade.anbiao.zhengfu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.anbiao.cheliangziping.vo.ZipinjianchaneirongMubanVO;

import java.io.Serializable;
import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/3
 * @描述
 */
@Data
@ApiModel(value = "Organization对象", description = "Organization对象")
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 企业ID
	 */
	@ApiModelProperty(value = "企业ID")
	private String Id;

	/**
	 * 上级ID
	 */
	@ApiModelProperty(value = "上级ID")
	private String parentId;

	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "企业名称")
	private String deptName;

	/**
	 * 企业tree_code
	 */
	@ApiModelProperty(value = "企业tree_code")
	private String treeCode;

	/**
	 * 省
	 */
	@ApiModelProperty(value = "省")
	private String province;

	/**
	 * 市
	 */
	@ApiModelProperty(value = "市")
	private String city;

	/**
	 * 县
	 */
	@ApiModelProperty(value = "县")
	private String country;

	/**
	 * 人员ID
	 */
	@ApiModelProperty(value = "人员ID")
	private String renYuanId;

	/**
	 * 登录账号
	 */
	@ApiModelProperty(value = "登录账号")
	private String account;

	/**
	 * 岗位ID
	 */
	@ApiModelProperty(value = "岗位ID")
	private String gangWeiId;

	/**
	 * xianlist数据
	 */
	@ApiModelProperty(value = "xianlist数据")
	private List<Organization> xianlist;

	/**
	 *shilist数据
	 */
	@ApiModelProperty(value = "shilist数据")
	private List<Organization> shilist;

	@ApiModelProperty(value = "机构类型")
	private String jigouleixing;

	@ApiModelProperty(value = "简称")
	private String fullName;

	@ApiModelProperty(value = "机构负责人")
	private String jigoufuzeren;

	@ApiModelProperty(value = "经营范围")
	private String jigouzizhi;

	@ApiModelProperty(value = "法人代表")
	private String farendaibiao;

	@ApiModelProperty(value = "联系电话")
	private String lianxidianhua;

	@ApiModelProperty(value = "注册资本")
	private String zhuceziben;

	@ApiModelProperty(value = "车辆规模")
	private String cheliangguimo;

	@ApiModelProperty(value = "从业人员数量")
	private String congyerenshuliang;

	@ApiModelProperty(value = "成立时间")
	private String chenglishijian;

	@ApiModelProperty(value = "入网时间")
	private String createtime;

	@ApiModelProperty(value = "地区名称")
	private String areaname;

	@ApiModelProperty(value = "政府运管名称")
	private String yunguanmingcheng;

	@ApiModelProperty(value = "政府运管ID")
	private String yunguanid;

	@ApiModelProperty(value = "企业ID")
	private String qiyeid;

	@ApiModelProperty(value = "企业名称")
	private String qiyemingcheng;

}
