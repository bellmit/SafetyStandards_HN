package org.springblade.system.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.tool.node.INode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author th
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/10/1410:48
 */
@Data
public class DeptSubVO  implements Serializable, INode {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id")
    private Integer id;
    @ApiModelProperty(value = "标题")
    private String title;


    /**
     * 父主键
     */
    @ApiModelProperty(value = "父主键")
    private Integer parentId;

    /**
     * 机构名
     */
    @ApiModelProperty(value = "机构名")
    private String deptName;



    /**
     * 子孙节点
     */
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<INode> children;


    @Override
    public List<INode> getChildren() {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        return this.children;
    }
}
