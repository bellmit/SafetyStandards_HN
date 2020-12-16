package org.springblade.anbiao.guanlijigouherenyuan.feign;

import org.springblade.anbiao.guanlijigouherenyuan.entity.Organizations;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
	//定义Feign指向的service-id
	value = "blade-anbiao",
	fallback = IOrganizationsClientBack.class
)
/**
* @Description:
*/
public interface IOrganizationsClient {

	String API_PREFIX = "/anbiao/organizations";

	@PostMapping(API_PREFIX + "/selectByDeptId")
	/**
	* @Description:
	* @Param: [deptId]
	*/
	Organizations selectByDeptId(@RequestParam("deptId") String deptId);
	@PostMapping(API_PREFIX + "/delByDeptId")
	/**
	* @Description:
	*/
	Boolean delByDeptId(@RequestParam("deptId") String deptId);

	@PostMapping(API_PREFIX + "/selectZFRenyuan")
	Organization selectZFRenyuan(@RequestParam("id") String id);

}
