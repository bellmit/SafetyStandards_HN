package org.springblade.anbiao.falvfagui.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.tool.utils.Func;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: SafetyStandards
 * @description: Guanlizhidu
 * @author: elvis
 * @create2021-04-24 15:00
 **/
@Data
@TableName("anbiao_guanlizhidu")
@ApiModel(value = "Guanlizhidu对象", description = "Guanlizhidu对象")
public class Guanlizhidu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "主键id")
    private String id;
    @ApiModelProperty(value = "企业 id")
    @TableField("dept_id")
    private Integer deptId;
    @ApiModelProperty(value = "企业 名称")
    @TableField(exist = false)
    private String deptName;

    @ApiModelProperty(value = "操作人")
    private String caozuoren;
    @ApiModelProperty(value = "操作人id")
    private Integer caozuorenid;
    @ApiModelProperty(value = "操作时间")
    private String caozuoshijian;

    @ApiModelProperty(value = "文件名称")
    private String wenjianmingcheng;
    @ApiModelProperty(value = "制度类别")
    private String zhiduleibie;
    @ApiModelProperty(value = "使用部门")
    private String shiyongbumen;
    @ApiModelProperty(value = "参考法规")
    private String cankaofagui;
    @ApiModelProperty(value = "文号")
    private String wenhao;
    @ApiModelProperty(value = "登记日期")
    private LocalDateTime dengjiriqi;
    @ApiModelProperty(value = "发布日期")
    private LocalDateTime faburiqi;
    @ApiModelProperty(value = "登记人")
    private String dengjiren;
    @ApiModelProperty(value = "制度简述")
    private String zhidujianshu;
    @ApiModelProperty(value = "车辆来源")
    private String shuoming;
    @ApiModelProperty(value = "附件")
    private String fujian;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",required = true)
	private String createtime;
    /**
     * 是否删除
     */
    @TableLogic
    @ApiModelProperty(value = "是否已删除")
    @TableField("is_deleted")
    private Integer isdel = 0;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Guanlizhidu other = (Guanlizhidu) obj;
        if (Func.equals(this.getId(), other.getId())) {
            return true;
        }
        return false;
    }

}
