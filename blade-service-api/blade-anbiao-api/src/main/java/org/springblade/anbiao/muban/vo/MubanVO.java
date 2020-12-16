package org.springblade.anbiao.muban.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.anbiao.muban.entity.Muban;
import org.springblade.core.tool.node.INode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SafetyStandards
 * @description: MubanVO
 * @author: 呵呵哒
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MubanVO对象", description = "MubanVO对象")
public class MubanVO extends Muban  implements INode {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 父节点ID
	 */
	private Integer parentId;

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

	private String label;

	private Integer value;

	private Integer key;
	/**
	 * 是否存在下级
	 */
	@ApiModelProperty(value = "是否存在下级(1 存在 0不存在)")
	private Integer existChild;
}
