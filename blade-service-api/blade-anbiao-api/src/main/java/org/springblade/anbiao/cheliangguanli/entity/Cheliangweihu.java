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
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 */
@Data
@TableName("anbiao_cheliangweihu")
@ApiModel(value = "Cheliangweihu对象", description = "Cheliangweihu对象")
public class Cheliangweihu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
	@TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id",required = true)
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
     * 车辆维护单位
     */
    @ApiModelProperty(value = "车辆维护单位")
    private String cheliangweihudanwei;
    /**
     * 维护类别
     */
    @ApiModelProperty(value = "维护类别")
    private String weihuleibie;
    /**
     * 进厂日期
     */
    @ApiModelProperty(value = "进厂日期")
    private String jinchangriqi;
    /**
     * 进厂里程读数
     */
    @ApiModelProperty(value = "进厂里程读数")
    private String jinchanglichengdushu;
    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期")
    private String chuchangriqi;
    /**
     * 维护金额
     */
    @ApiModelProperty(value = "维护金额")
    private String weihujine;
    /**
     * 下次维护日期
     */
    @ApiModelProperty(value = "下次维护日期",required = true)
    private String xiaciweihuriqi;

	/**
	 * 维护日期
	 */
	@ApiModelProperty(value = "维护日期",required = true)
	private String weihuriqi;
    /**
     * 下次进厂里程读数
     */
    @ApiModelProperty(value = "下次进厂里程读数")
    private String xiacijinchanglicheng;
    /**
     * 是否合格
     */
    @ApiModelProperty(value = "是否合格")
    private String shifouhege;
    /**
     * 认定维修点
     */
    @ApiModelProperty(value = "认定维修点")
    private String rendingweixiudian;
    /**
     * 维护合同编号
     */
    @ApiModelProperty(value = "维护合同编号")
    private String weihuhetongbianhao;
    /**
     * 录入时间
     */
    @ApiModelProperty(value = "录入时间")
    private String lurushijian;
    /**
     * 维护内容
     */
    @ApiModelProperty(value = "维护内容")
    private String weihuneirong;
    /**
     * 检测报告附件
     */
    @ApiModelProperty(value = "检测报告附件")
    private String jiancebaogaofujian;
    /**
     * 复印件
     */
    @ApiModelProperty(value = "复印件")
    private String fuyinjian;
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
