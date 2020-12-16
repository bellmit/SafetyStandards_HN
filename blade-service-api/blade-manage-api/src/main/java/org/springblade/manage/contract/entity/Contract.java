/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * limitations under the License.
 */
package org.springblade.manage.contract.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 */
@Data
@TableName("manage_contract")
@ApiModel(value = "Contract对象", description = "Contract对象")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;
  private Integer deptId;
    /**
     * 甲方
     */
    @ApiModelProperty(value = "甲方")
    private String jiafang;
    /**
     * 甲方代表
     */
    @ApiModelProperty(value = "甲方代表")
    private String jiafangdaibiao;
    /**
     * 甲方电话
     */
    @ApiModelProperty(value = "甲方电话")
    private String jiafangdianhua;
    /**
     * 乙方
     */
    @ApiModelProperty(value = "乙方")
    private String yifang;
    /**
     * 乙方代表
     */
    @ApiModelProperty(value = "乙方代表")
    private String yifangdaibiao;
    /**
     * 乙方电话
     */
    @ApiModelProperty(value = "乙方电话")
    private String yifangdianhua;
    /**
     * 签订时间
     */
    @ApiModelProperty(value = "签订时间")
    private String qiandingshijian;
    /**
     * 合同到期时间
     */
    @ApiModelProperty(value = "合同到期时间")
    private String hetongdaoqishijian;
    /**
     * 货物量
     */
    @ApiModelProperty(value = "货物量")
    private String huowuliang;
    /**
     * 合同金额
     */
    @ApiModelProperty(value = "合同金额")
    private String hetongjine;
    /**
     * 收货企业
     */
    @ApiModelProperty(value = "收货企业")
    private String shouhuoqiye;

	/**
	 * 是否删除
	 */
	@ApiModelProperty(value = "是否删除")
	private Integer isDelete;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String createuser;
	/**
	 * 操作人
	 */
	@ApiModelProperty(value = "操作人")
	private String caozuoren;
	/**
	 * 操作时间
	 */
	@ApiModelProperty(value = "操作时间")
	private String caozuoshijian;
	/**
	 * 合同编号
	 */
	@ApiModelProperty(value = "合同编号")
	private String hetongbianhao;

	@ApiModelProperty(value = "企业名称")
	@TableField(exist = false)
	private String deptName;
}
