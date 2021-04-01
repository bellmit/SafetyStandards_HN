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
package org.springblade.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springblade.system.entity.Dept;
import org.springblade.system.vo.DeptSubVO;
import org.springblade.system.vo.DeptVO;

import java.util.List;

/**
 * Mapper 接口
 * @author 呵呵哒
 */
public interface DeptMapper extends BaseMapper<Dept> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param dept
	 * @return
	 */
	List<DeptVO> selectDeptPage(IPage page, DeptVO dept);

	/**
	 * 获取树形节点
	 *
	 * @param id
	 * @return
	 */
	List<DeptVO> tree(String id,String type);

	/**
	 * 多岗设置树形
	 * @param id
	 * @param id
	 * @return
	 */
	List<DeptVO> treeDG(String id);

	/**
	 * 企業異動
	 * @param id
	 * @return
	 */
	List<DeptVO> YDtree(String id);

	/**
	 * 获取treecode
	 * *@param id
	 * @return
	 */
	Dept  selectByTreeCode(Integer id);

	/**
	 * 获取是否存在下级组织
	 * @param id
	 * @return
	 */
	int selectCountByparentId(Integer id);

	/**
	 * 获取当前最大的deptId
	 * @return
	 */
	int selectMaxId();

	/**
	 * 查询机构是否存在重名
	 * @param fullName
	 * @return
	 */
	int selectByName(String fullName);

	/**
	 * 自定义新增方法
	 * @param dept
	 * @return
	 */
	boolean insertDept(Dept dept);

	/**
	 * 根据传值岗位id 类型 获取直属上级信息
	 * @param type
	 * @param deptId
	 * @return
	 */
	Dept selectByJGBM(String type,String deptId);

	/**
	 * 根据传值岗位id 类型 获取相关下级信息
	 * @param type
	 * @param deptId
	 * @return
	 */
	Dept selectByJGQY(String type,String deptId);

	/**
	 * 自定义根据id获取数据
	 * @param id
	 * @return
	 */
	Dept selectByDeptId(Integer id);

	/**
	 *获取机构子树
	 * @author: hyp
	 * @date: 2019/10/14 10:40
	 * @param deptId
	 * @return: java.util.List<java.lang.String>
	 */
    List<DeptSubVO> getDeptSubTree(Integer deptId);

    /**
     *获取下级企业id
     * @author: hyp
     * @date: 2019/10/28 13:53
     * @param deptId
     * @return: java.util.List<java.lang.Integer>
     */
    List<Integer> getDetpIds(Integer deptId);

	/**
	 * 获取省市县运管
	 * @author: elvis
	 * @date: 2020/06/17 09:53
	 * @param code,deptId
	 * @return: java.util.List<DeptSubVO>
	 */
	List<DeptSubVO> getRegionGovList(String code,int parentId);

	List<DeptSubVO> getRegionGovList_Shi(@Param("param2") Integer param2);

	/**
	 * 获取省市县
	 * @author: elvis
	 * @date: 2020/06/17 09:53
	 * @param code,deptId
	 * @return: java.util.List<DeptSubVO>
	 */
	List<DeptSubVO> getRegionList(String code,int parentId);

	/**
	 * 根据机构名称获取机构信息
	 * @author: elvis
	 * @date: 2020/06/19 09:53
	 * @param name
	 * @return
	 */
	Dept getDeptByName(@Param("name") String name);

	/**
	 * 根据机构名称模糊查询获取机构信息
	 * @param deptname
	 * @return
	 */
	List<Dept> getByName(@Param("deptname") String deptname);

	/**
	 * 根据企业ID获取下级所有企业（企业、个体）
	 * @param deptId
	 * @return
	 */
	List<Dept> QiYeList(@Param("deptId") Integer deptId);


}
