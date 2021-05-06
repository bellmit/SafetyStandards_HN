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
package org.springblade.anbiao.guanlijigouherenyuan.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.guanlijigouherenyuan.entity.AnBiaoLogin;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Personnel;
import org.springblade.anbiao.guanlijigouherenyuan.page.PersonnelPage;
import org.springblade.anbiao.guanlijigouherenyuan.vo.PersonnelVO;

import java.util.List;

/**
 *  服务类
 *
 * @author Blade
 * @since 2019-04-29
 */
public interface IPersonnelService extends IService<Personnel> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param personnel
	 * @return
	 */
	IPage<PersonnelVO> selectPersonnelPage(IPage<PersonnelVO> page, PersonnelVO personnel);
	List<Personnel> selectJG();
	Personnel selectpostId(String postId,String userId);

	boolean updateDel(String id);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	PersonnelPage<PersonnelVO> selectPageList(PersonnelPage Page);

	int selectTotal(PersonnelPage Page);
	/**
	 *查询当前人员是否存在岗位信息
	 * @param userId
	 * @return
	 */
	int selectByPost(String userId);
	/**
	 * 根据人员idd获取数据
	 * @param userId
	 * @return
	 */
	PersonnelVO selectByUserId(String userId);

	/**
	 * 根据人员id清楚数据
	 * @param userId
	 * @return
	 */
	boolean updateDelByUserId(String userId);

	/**
	 * 根据人员id单位id获取数据
	 * @param userId
	 * @return
	 */
	Personnel selectByUserIdAdnByDeptId(String userId,String deptId);

	/**
	 * 统一入口新增
	 * @param anBiaoLogin
	 * @return
	 */
	boolean insertAnBiaoLogin(AnBiaoLogin anBiaoLogin);

	/**
	 * 统一入口编辑
	 * @param anBiaoLogin
	 * @return
	 */
	boolean updateAnBiaoLogin(AnBiaoLogin anBiaoLogin);
	AnBiaoLogin selectAnBiaoLogin(String name,String password);

	/**
	 * 添加人员详情
	 * @param personnel
	 * @return
	 */
	boolean insertSelective(Personnel personnel);
}
