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
package org.springblade.anbiao.baobiaowenjian.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.anbiao.baobiaowenjian.entity.BaobiaoWenjian;

import java.time.LocalDate;
import java.util.List;

/**
 * 视图实体类
 *
 * @author hyp
 * @since 2019-05-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BaobiaoWenjianVO对象", description = "BaobiaoWenjianVO对象")
public class BaobiaoWenjianVO extends BaobiaoWenjian {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件属性（1日报、2周报、3月报、4年报）")
    private Integer property;
    @ApiModelProperty(value = "统计日期")
    private LocalDate countDate;
    @ApiModelProperty(value = "图片列表")
    private List<String> imgList;
	@ApiModelProperty(value = "累计访问次数")
	private Integer cumulativeVisits;
	@ApiModelProperty(value = "最后访问时间")
	private String lastPreviewTime;

}
