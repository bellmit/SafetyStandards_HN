package org.springblade.anbiao.guanlijigouherenyuan.feign;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Departmentpost;
import org.springblade.anbiao.guanlijigouherenyuan.service.IDepartmentpostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @program: SafetyStandards
 * @description: Departmentpost接口
 **/
@ApiIgnore
@RestController
@AllArgsConstructor
public class DepartmentpostClient implements  IDepartmentpostClient{

	private IDepartmentpostService service;

	@Override
	@PostMapping(API_PREFIX + "/insertDepart")
	@ApiOperation(value = "新增or编辑(feign使用)", notes = "传入departmentpost", position = 1)
	public Boolean insertDepart(@RequestBody Departmentpost departmentpost) {
		return service.saveOrUpdate(departmentpost);
	}
	@Override
	@PostMapping(API_PREFIX + "/updateByPostIdDepart")
	@ApiOperation(value = "编辑(feign使用 根据postId进行修改)", notes = "传入departmentpost", position = 1)
	public Boolean updateByPostIdDepart(@RequestBody Departmentpost departmentpost) {
		return service.updateByPostId(departmentpost);
	}

	@Override
	@GetMapping(API_PREFIX + "/selectByDeptId")
	@ApiOperation(value = "根据单位id进行查询数据", notes = "传入deptId", position = 1)
	public Departmentpost selectByDeptId(String deptId) {
		return service.selectByPostId(deptId);
	}
}
