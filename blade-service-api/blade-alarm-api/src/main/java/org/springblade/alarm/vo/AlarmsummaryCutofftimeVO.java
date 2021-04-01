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
package org.springblade.alarm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.alarm.entity.AlarmsummaryCutofftime;

import java.time.LocalDateTime;

/**
 * 视图实体类
 *
 * @author hyp
 * @since 2019-05-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AlarmsummaryCutofftimeVO对象", description = "AlarmsummaryCutofftimeVO对象")
public class AlarmsummaryCutofftimeVO extends AlarmsummaryCutofftime {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车辆牌照")
    private String plate;
    @ApiModelProperty(value = "持续时长格式化")
    private String keeptimeShow;
    @ApiModelProperty(value = "区域验证")
    private String isRegionVShow;
    @ApiModelProperty(value = "是否夜间")
    private String atNocturnalShow;

    @ApiModelProperty(value = "处理状态")
    private String chulizhuangtai;
    @ApiModelProperty(value = "处理形式")
    private String chulixingshi;
    @ApiModelProperty(value = "处理描述")
    private String chulimiaoshu;
    @ApiModelProperty(value = "处理人")
    private String chuliren;
    @ApiModelProperty(value = "处理人id")
    private Integer chulirenid;
    @ApiModelProperty(value = "处理时间")
    private LocalDateTime chulishijian;
    @ApiModelProperty(value = "附件")
    private String fujian;
    @ApiModelProperty(value = "备注")
    private String beizhu;
	@ApiModelProperty(value = "严重超速等级")
    private String yanzhongdengji;

	@ApiModelProperty(value = "申诉状态")
	private String shensuzhuangtai;

	@ApiModelProperty(value = "申诉形式")
	private String shensuxingshi;

	@ApiModelProperty(value = "申诉描述")
	private String shensumiaoshu;

	@ApiModelProperty(value = "申诉审核标识（0:申诉审核中;1:申诉通过;2:申诉驳回）")
	private Integer shensushenhebiaoshi;

	@ApiModelProperty(value = "申诉审核人")
	private String shensushenheren;

	@ApiModelProperty(value = "申诉审核时间")
	private String shensushenheshijian;

	@ApiModelProperty(value = "申诉审核意见")
	private String shensushenheyijian;

	@ApiModelProperty(value = "开始行驶时间（疲劳驾驶）")
	private String calctime;

	@ApiModelProperty(value = "提醒消息ID")
	private String alarmGuid;

	@ApiModelProperty(value = "IC卡登签")
	private String icardsign;

	@ApiModelProperty(value = "报警等级")
	private String alarmlevel;

	@ApiModelProperty(value = "二次处理形式")
	private String twicechulixingshi;

	@ApiModelProperty(value = "二次处理描述")
	private String twicechulimiaoshu;

	@ApiModelProperty(value = "二次处理附件")
	private String twicefujian;

	@ApiModelProperty(value = "二次处理人")
	private String twicechuliren;

	@ApiModelProperty(value = "二次处理时间")
	private String twicechulishijian;

	@ApiModelProperty(value = "二次处理人ID")
	private String twicechulirenid;

	@ApiModelProperty(value = "最终处理结果")
	private String endresult;

	@ApiModelProperty(value = "处理率")
	private String chulilv;

	@ApiModelProperty(value = "日期")
	private String dateShow;

	@ApiModelProperty(value = "企业ID")
	private String deptId;

	@ApiModelProperty(value = "报警总数")
	private Integer baojingcishu;

}
