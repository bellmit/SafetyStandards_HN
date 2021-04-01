package org.springblade.anbiao.guanlijigouherenyuan.feign;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Organizations;
import org.springblade.anbiao.guanlijigouherenyuan.service.IOrganizationsService;
import org.springblade.anbiao.guanlijigouherenyuan.vo.OrganizationsVO;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @program: SafetyStandards
 **/
@ApiIgnore
@RestController
@AllArgsConstructor
public class OrganizationsClient implements IOrganizationsClient {

	private IOrganizationsService orrganizationsService;

	@Override
	@ApiOperation(value = "根据单位id获取信息(feign使用)", notes = "传入deptId", position = 3)
	public Organizations selectByDeptId(String deptId) {
		return orrganizationsService.selectByDeptId(deptId);
	}

	@Override
	@ApiOperation(value = "根据单位id清除数据(feign使用)", notes = "传入deptId", position = 4)
	public Boolean delByDeptId(String deptId) {
		return orrganizationsService.delByDeptId(deptId);
	}

	@Override
	@ApiOperation(value = "根据人员id查询政府岗位(feign使用)", notes = "传入Id", position = 4)
	public Organization selectZFRenyuan(String id) {
		return orrganizationsService.selectZFRenyuan(id);
	}

	@Override
	@ApiOperation(value = "政府企业同步更新(feign使用)", notes = "", position = 5)
	public List<OrganizationsVO> getZFQY() {
		return orrganizationsService.getZFQY();
	}

	@Override
	@ApiOperation(value = "政府企业同步更新-对比(feign使用)", notes = "", position = 6)
	public List<OrganizationsVO> getZFQYOrderById() {
		return orrganizationsService.getZFQYOrderById();
	}

	@Override
	@ApiOperation(value = "政府企业同步更新-数据入库(feign使用)", notes = "", position = 7)
	public Boolean insertSelective(OrganizationsVO organizationsVO) {
		return orrganizationsService.insertSelective(organizationsVO);
	}


}
