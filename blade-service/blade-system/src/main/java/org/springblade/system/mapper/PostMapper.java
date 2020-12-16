package org.springblade.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.system.entity.Post;

import java.util.List;

/**
 * Mapper 接口
 * @author 呵呵哒
 */
public interface PostMapper extends BaseMapper<Post> {
	/**
	 *根据人员id获取岗位
	 * @param userId
	 * @return
	 */
	List<Post> selectByUserId(Integer userId);

	/**
	 * 根据人员id获取默认岗位信息
	 * @param userId
	 * @return
	 */
	Post selectByUserIdAndIsdefault(Integer userId);

	/**
	 * 根据人员id删除岗位
	 * @param userId
	 * @return
	 */
	boolean deleteByUserId(Integer userId);
	/**
	* @Description: 根据用户id与岗位id设置默认岗位
	* @Author: 呵呵哒
	*/
	boolean  updateIsdefault(Post post);

	/**
	 * 新增
	 * @param post
	 * @return
	 */
	boolean insertPost(Post post);

	/**
	 *根据deptId获取下级所有postId
	 * @author: th
	 * @date: 2019/10/24 15:25
	 * @param deptId
	 * @return: java.util.List<java.lang.Integer>
	 */
    List<Integer> getPostIdsByDeptId(String deptId);
}
