/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Author:   呵呵哒
 * Date:     2020/6/20 17:18
 * Description:
 */
package org.springblade.anbiao.zhengfu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springblade.anbiao.zhengfu.entity.ZhengFuOrganization;
import org.springblade.anbiao.zhengfu.page.OrganizationPage;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/7/4
 * @描述
 */
public interface IOrganizationService extends IService<Organization> {

	Organization selectGetSheng(String deptId);

	List<Organization> selectGetShi(String Id);

	List<Organization> selectGetXian(String Id);

	Organization selectGetRenyuan(String Id);

	Organization selectGetGangWei(String Id);

	/**
	 * 根据账号政府id获取下级企业
	 * province city country
	 * @return
	 */
	List<ZhengFuOrganization> selectGetZF(@Param("province") String province,@Param("city") String city,@Param("country") String country,@Param("deptId") String deptId);

	/**
	 * 查询政府ID
	 * @param deptId
	 * @return
	 */
	Organization selectGetZFJB(@Param("deptId") String deptId);

	/**
	 * 查询政府企业明细
	 * @param organizationPage
	 * @return
	 */
	OrganizationPage selectALLPage(OrganizationPage organizationPage);


}
