package org.springblade.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * 实体类
 *
 * @author hyp
 */
@Getter
@Setter
@TableName("blade_post_menu")
@ApiModel(value = "PostMenu对象", description = "PostMenu对象")
public class PostMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 菜单id
	 */
	@ApiModelProperty(value = "菜单id")
	private Integer menuId;

	/**
	 * 岗位id
	 */
	@ApiModelProperty(value = "岗位id")
	private Integer postId;
	/**
	 * 类型(0代表运维 1代表安标)
	 */
	@ApiModelProperty(value = "类型(0代表运维 1代表安标)")
	private Integer type;

	@Override
	public boolean equals(Object o) {
		if (this == o){
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PostMenu postMenu = (PostMenu) o;
		return Objects.equals(menuId, postMenu.menuId) &&
				Objects.equals(postId, postMenu.postId) &&
				Objects.equals(type, postMenu.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(menuId, postId, type);
	}
}
