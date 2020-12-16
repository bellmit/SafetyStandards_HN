package org.springblade.system.user.feign;

import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @program: SpringBlade
 * @description: UserFeign
 **/
@ApiIgnore
@RestController
@AllArgsConstructor
public class UserFeign implements IUserFiegn  {

	IUserService service;

	@Override
	@GetMapping(API_PREFIX + "/getUserById")
	public User getUserById(Integer id) {
		return service.getUserById(id);
	}

	@Override
	@GetMapping(API_PREFIX + "/resetPassword")
	public boolean resetPassword(String userIds) {
		return service.resetPassword(userIds);
	}

	@Override
	@GetMapping(API_PREFIX + "/getRoleName")
	public List<String> getRoleName(String roleIds) {
		return service.getRoleName(roleIds);
	}

	@Override
	@GetMapping(API_PREFIX + "/getDeptName")
	public List<String> getDeptName(String deptIds) {
		return service.getDeptName(deptIds);
	}

	@Override
	@GetMapping(API_PREFIX + "/selectMaxId")
	public int selectMaxId() {
		return service.selectMaxId();
	}

	@Override
	@GetMapping(API_PREFIX + "/selectByLoginName")
	public int selectByLoginName(String account) {
		return service.selectByLoginName(account);
	}

	/**
	 * 在实现服务里的参数也必须加上 @RequestBody ，不然获取的对象仍然没有值
	 * @param user
	 * @return
	 */
	@Override
	@PostMapping(API_PREFIX + "/insertPer")
	public boolean insertPer(@RequestBody User user) {
		return service.insertPer(user);
	}

	@Override
	@GetMapping(API_PREFIX + "/selectByPostId")
	public List<User> selectByPostId(String postId) {
		return service.selectByPostId(postId);
	}

	/**
	 * 在实现服务里的参数也必须加上 @RequestBody ，不然获取的对象仍然没有值
	 * @param user
	 * @return
	 */
	@Override
	@PostMapping(API_PREFIX + "/updatePer")
	public boolean updatePer(@RequestBody User user) {
		return service.updatePer(user);
	}

	@Override
	@GetMapping(API_PREFIX + "/deletePer")
	public boolean deletePer(String id) {
		return service.deletePer(id);
	}


}
