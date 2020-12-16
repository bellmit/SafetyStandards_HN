package org.springblade.anbiao.guanlijigouherenyuan.feign;

import org.springblade.anbiao.guanlijigouherenyuan.entity.Departmentpost;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @program: SafetyStandards
 **/
@Component
public class IDepartmentpostClientBack implements IDepartmentpostClient {
	@Override
	public Boolean insertDepart(@Valid Departmentpost departmentpost) {
		return null;
	}

	@Override
	public Boolean updateByPostIdDepart(@Valid Departmentpost departmentpost) {
		return null;
	}

	@Override
	public Departmentpost selectByDeptId(String deptId) {
		return null;
	}
}
