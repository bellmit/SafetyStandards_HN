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
import org.springblade.alarm.entity.Offlinedetail;

import java.time.LocalDateTime;

/**
 * 视图实体类
 *
 * @author hyp
 * @since 2019-05-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OfflinedetailVO对象", description = "OfflinedetailVO对象")
public class OfflinedetailVO extends Offlinedetail {
    private static final long serialVersionUID = 1L;

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
	@ApiModelProperty(value = "申诉状态")
	private String shensuzhuangtai;
	@ApiModelProperty(value = "车辆类型")
	private  String  OperatType;
	@ApiModelProperty(value = "申诉形式")
	private String shensuxingshi;
	@ApiModelProperty(value = "申诉描述")
	private  String shensumiaoshu;
	@ApiModelProperty(value = "处理 申诉状态")
	private Integer remark;
}
