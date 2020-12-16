package org.springblade.system.user.feign;

import org.springblade.system.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SpringBlade
 * @description: IUserClientBack
 **/
@Component
public class IUserFiegnBack implements  IUserFiegn {

	@Override
	public User getUserById(Integer id) {
		return null;
	}

	@Override
	public boolean resetPassword(String userIds) {
		return false;
	}

	@Override
	public List<String> getRoleName(String roleIds) {
		return null;
	}

	@Override
	public List<String> getDeptName(String deptIds) {
		return null;
	}

	@Override
	public int selectMaxId() {
		return 0;
	}

	@Override
	public int selectByLoginName(String account) {
		return 0;
	}

	@Override
	public boolean insertPer(User user) {
		return false;
	}

	@Override
	public List<User> selectByPostId(String postId) {
		return null;
	}

	@Override
	public boolean updatePer(User user) {
		return false;
	}

	@Override
	public boolean deletePer(String id) {
		return false;
	}
}
