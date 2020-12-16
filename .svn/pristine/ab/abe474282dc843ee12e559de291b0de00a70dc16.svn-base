package org.springblade.gps.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elvis
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2020/06/28 09:35
 */
@Data
@ApiModel(value = "VehicleNode", description = "VehicleNode")
public class VehicleNode implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	@ApiModelProperty(value = "id")
	private Integer id;
	/**
	 * parentid
	 */
	@ApiModelProperty(value = "父级id")
	private Integer parentId;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private int isonline;

	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String title;

	/**
	 * 子孙节点
	 */
	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<VehicleNode> children;

	public List<VehicleNode> getChildren() {
		if (this.children == null) {
			this.children = new ArrayList<>();
		}
		return this.children;
	}

}
