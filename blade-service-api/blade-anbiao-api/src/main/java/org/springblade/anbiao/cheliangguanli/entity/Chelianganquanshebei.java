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
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类
 * @author 呵呵哒
 */
@Data
@TableName("anbiao_chelianganquanshebei")
@ApiModel(value = "Chelianganquanshebei对象", description = "Chelianganquanshebei对象")
public class Chelianganquanshebei implements Serializable {

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
     * 车辆ID
     */
    @ApiModelProperty(value = "车辆ID", required = true)
    private String cheliangid;
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
     * 故障警示灯
     */
    @ApiModelProperty(value = "故障警示灯")
    private String guzhangjingshipai;
    /**
     * 使用年限
     */
    @ApiModelProperty(value = "使用年限")
    private String shiyongnianxian;
    /**
     * 实际监控3G
     */
    @ApiModelProperty(value = "实际监控3G")
    @TableField("shijijiankong3G")
  private String shijijiankong3G;
    /**
     * 安装GPS
     */
    @ApiModelProperty(value = "安装GPS", required = true)
    @TableField("anzhuangGPS")
  private String anzhuangGPS;
    /**
     * 静电释放线
     */
    @ApiModelProperty(value = "静电释放线")
    private String jingdianshifangxian;
    /**
     * 安全锤
     */
    @ApiModelProperty(value = "安全锤")
    private String anquanchui;
    /**
     * 灭火器
     */
    @ApiModelProperty(value = "灭火器")
    private String miehuoqi;
    /**
     * 三角木
     */
    @ApiModelProperty(value = "三角木")
    private String sanjiaomu;
    /**
     * 发动机灭火
     */
    @ApiModelProperty(value = "发动机灭火")
    private String fadongjimiehuo;
    /**
     * 防滑链
     */
    @ApiModelProperty(value = "防滑链")
    private String fanghualian;
    /**
     * 交通锤
     */
    @ApiModelProperty(value = "交通锤")
    private String jiaotongchui;
    /**
     * 铁铲
     */
    @ApiModelProperty(value = "铁铲")
    private String tiechan;
    /**
     * 防火罩
     */
    @ApiModelProperty(value = "防火罩")
    private String fanghuozhao;
    /**
     * 硬盘录相机
     */
    @ApiModelProperty(value = "硬盘录相机")
    private String yingpanluxiangji;
    /**
     * 沙袋
     */
    @ApiModelProperty(value = "沙袋")
    private String shadai;
    /**
     * 三角牌
     */
    @ApiModelProperty(value = "三角牌")
    private String sanjiaopai;
    /**
     * 标识灯
     */
    @ApiModelProperty(value = "标识灯")
    private String biaoshideng;
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
