/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.anbiao.guanlijigouherenyuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Organizations;
import org.springblade.anbiao.guanlijigouherenyuan.page.OrganizationsPage;
import org.springblade.anbiao.guanlijigouherenyuan.vo.OrganizationsVO;
import org.springblade.anbiao.zhengfu.entity.Organization;

import java.util.List;

/**
 *  Mapper 接口
 */
public interface OrganizationsMapper extends BaseMapper<Organizations> {

	/**
	 * 获取系统所有企业
	 * @return
	 */
	List<Organizations> selectAll();

	boolean updateDel(String id);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	List<OrganizationsVO> selectPageList(OrganizationsPage Page);
	/**
	 * 统计
	 * @param
	 * @return
	 */
	int selectTotal(OrganizationsPage Page);

	OrganizationsVO selectByIds(String id);

	Organizations selectByDeptId(String deptId);

	boolean delByDeptId(String deptId);

	Organization selectZFRenyuan(String id);

	List<OrganizationsVO> getZFQY();

	List<OrganizationsVO> getZFQYOrderById();

	boolean insertSelective(OrganizationsVO organizationsVO);



}
