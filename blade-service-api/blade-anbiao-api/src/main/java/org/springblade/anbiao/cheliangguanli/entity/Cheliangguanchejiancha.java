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
@TableName("anbiao_cheliangguanchejiancha")
@ApiModel(value = "Cheliangguanchejiancha对象", description = "Cheliangguanchejiancha对象")
public class Cheliangguanchejiancha implements Serializable {

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
     * 车头车辆牌照
     */
    @ApiModelProperty(value = "车头车辆牌照")
    private String chetoucheliangpaizhao;
    /**
     * 检验日期
     */
    @ApiModelProperty(value = "检验日期")
    private String jianyanriqi;
    /**
     * 检验人员
     */
    @ApiModelProperty(value = "检验人员")
    private String jianyanrenyuan;
    /**
     * 是否合格
     */
    @ApiModelProperty(value = "是否合格", required = true)
    private String shifouhege;
    /**
     * 检验单位
     */
    @ApiModelProperty(value = "检验单位")
    private String jianchadanwei;
    /**
     * 下次检验时间
     */
    @ApiModelProperty(value = "下次检验时间", required = true)
    private String xiacijianyanshijian;
    /**
     * 下次年审时间
     */
    @ApiModelProperty(value = "下次年审时间", required = true)
    private String xiacinianshenshijian;
    /**
     * 使用登记编号
     */
    @ApiModelProperty(value = "使用登记编号")
    private String shiyongdengjibianhao;
    /**
     * 注册代码
     */
    @ApiModelProperty(value = "注册代码")
    private String zhucedaima;
    /**
     * 检验结果
     */
    @ApiModelProperty(value = "检验结果")
    private String jianyanjieguo;
    /**
     * 问题及处理
     */
    @ApiModelProperty(value = "问题及处理")
    private String wentijichuli;
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
