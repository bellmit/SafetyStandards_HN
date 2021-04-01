package org.springblade.system.user.feign;

import org.springblade.core.launch.constant.AppConstant;
import org.springblade.system.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * User Feign接口类
 *
 * @author hyp
 */
@FeignClient(
	//定义Feign指向的service-id
	value = AppConstant.APPLICATION_USER_NAME,
	fallback = IUserFiegnBack.class
)
public interface IUserFiegn {

	String API_PREFIX = "/user";

	/**
	 * 根据用户id获取数据
	 * @param id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/getUserById")
	User getUserById(@RequestParam("id") Integer id);

	/**
	 * 初始化密码
	 *
	 * @param userIds
	 * @return
	 */
	@GetMapping(API_PREFIX + "/resetPassword")
	boolean resetPassword(@RequestParam("userIds") String userIds);

	/**
	 * 获取角色名
	 *
	 * @param roleIds
	 * @return
	 */
	@GetMapping(API_PREFIX + "/getRoleName")
	List<String> getRoleName(@RequestParam("roleIds") String roleIds);

	/**
	 * 获取部门名
	 *
	 * @param deptIds
	 * @return
	 */
	@GetMapping(API_PREFIX + "/getDeptName")
	List<String> getDeptName(@RequestParam("deptIds") String deptIds);
	/**
	 * 获取当前最大的id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectMaxId")
	int selectMaxId();
	/**
	 * 查询登录账号是否重复
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectByLoginName")
	int selectByLoginName(@RequestParam("account") String account);

	/**
	 * 自定义新增 在实现服务里的参数也必须加上 @RequestBody ，不然获取的对象仍然没有值
	 * @param user
	 * @return
	 */
	@PostMapping(API_PREFIX + "/insertPer")
	boolean insertPer(@Valid @RequestBody User user);

	/**
	 * 根据岗位id获取岗位下级人员信息
	 * @param postId
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectByPostId")
	List<User> selectByPostId(@RequestParam("postId") String postId);

	/**
	 * 自定义编辑 在实现服务里的参数也必须加上 @RequestBody ，不然获取的对象仍然没有值
	 * @param user
	 * @return
	 */
	@PostMapping(API_PREFIX + "/updatePer")
	boolean updatePer(@Valid @RequestBody User user);

	/**
	 * 自定义删除
	 * @param id
	 * @return
	 */
	@GetMapping(API_PREFIX + "/deletePer")
	boolean deletePer(@RequestParam("id") String id);



}
