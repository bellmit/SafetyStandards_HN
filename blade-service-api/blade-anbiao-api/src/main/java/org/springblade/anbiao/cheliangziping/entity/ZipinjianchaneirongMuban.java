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
package org.springblade.anbiao.cheliangziping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author Blade
 * @since 2019-09-02
 */
@Data
@TableName("anbiao_zipinjianchaneirong_muban")
@ApiModel(value = "ZipinjianchaneirongMuban对象", description = "ZipinjianchaneirongMuban对象")
public class ZipinjianchaneirongMuban implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private  Integer id;
	@ApiModelProperty(value = "运营类型")
	private String  yunyingleixing;
	@ApiModelProperty(value = "检查项目")
	private String jianchaxiangmu;
	@ApiModelProperty(value = "检查项编号")
	private Integer  jiachaxiangbianhao;

	@ApiModelProperty(value = "内容id")
 	 @TableId(value = "id", type = IdType.AUTO)
 	 private Integer neirongid;
	@ApiModelProperty(value = "检查项目母版id")
 	 private Integer jianchaxiangmuid;
	@ApiModelProperty(value = "检查类容")
 	 private String jianchaleirong;
	@ApiModelProperty(value = "检查方式")
 	 private String jianchafangshi;
	@ApiModelProperty(value = "检查内容编号")
 	 private Integer jiachaneirongbianhao;
	@ApiModelProperty(value = "默认为未检查")
	private Integer isHege;


}
