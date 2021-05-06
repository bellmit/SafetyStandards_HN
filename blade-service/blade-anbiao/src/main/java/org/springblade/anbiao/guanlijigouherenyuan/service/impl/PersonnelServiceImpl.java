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
package org.springblade.anbiao.guanlijigouherenyuan.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.guanlijigouherenyuan.entity.AnBiaoLogin;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Personnel;
import org.springblade.anbiao.guanlijigouherenyuan.mapper.PersonnelMapper;
import org.springblade.anbiao.guanlijigouherenyuan.page.PersonnelPage;
import org.springblade.anbiao.guanlijigouherenyuan.service.IPersonnelService;
import org.springblade.anbiao.guanlijigouherenyuan.vo.PersonnelVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-04-29
 */
@Service
@AllArgsConstructor
public class PersonnelServiceImpl extends ServiceImpl<PersonnelMapper, Personnel> implements IPersonnelService {

	private PersonnelMapper mapper;

	@Override
	public IPage<PersonnelVO> selectPersonnelPage(IPage<PersonnelVO> page, PersonnelVO personnel) {
		return page.setRecords(baseMapper.selectPersonnelPage(page, personnel));
	}

	@Override
	public List<Personnel> selectJG() {
		return mapper.selectJG();
	}

	@Override
	public Personnel selectpostId(String postId,String userId) {
		return mapper.selectpostId(postId,userId);
	}

	@Override
	public boolean updateDel(String id) {
		return mapper.updateDel(id);
	}

	@Override
	public PersonnelPage<PersonnelVO> selectPageList(PersonnelPage Page) {
		Integer total = mapper.selectTotal(Page);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%Page.getSize()==0){
				pagetotal = total / Page.getSize();
			}else {
				pagetotal = total / Page.getSize() + 1;
			}
		}
		if (pagetotal < Page.getCurrent()) {
			return Page;
		} else {
			Page.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (Page.getCurrent() > 1) {
				offsetNo = Page.getSize() * (Page.getCurrent() - 1);
			}
			Page.setTotal(total);
			Page.setOffsetNo(offsetNo);
			List<PersonnelVO> vehlist = mapper.selectPageList(Page);
			return (PersonnelPage<PersonnelVO>) Page.setRecords(vehlist);
		}
	}

	@Override
	public int selectTotal(PersonnelPage Page) {
		return mapper.selectTotal(Page);
	}

	@Override
	public int selectByPost(String userId) {
		return mapper.selectByPost(userId);
	}

	@Override
	public PersonnelVO selectByUserId(String userId) {
		return mapper.selectByUserId(userId);
	}

	@Override
	public boolean updateDelByUserId(String userId) {
		return mapper.updateDelByUserId(userId);
	}

	@Override
	public Personnel selectByUserIdAdnByDeptId(String userId, String deptId) {
		return mapper.selectByUserIdAdnByDeptId(userId,deptId);
	}

	@Override
	public boolean insertAnBiaoLogin(AnBiaoLogin anBiaoLogin) {
		return mapper.insertAnBiaoLogin(anBiaoLogin);
	}

	@Override
	public boolean updateAnBiaoLogin(AnBiaoLogin anBiaoLogin) {
		return mapper.updateAnBiaoLogin(anBiaoLogin);
	}

	@Override
	public AnBiaoLogin selectAnBiaoLogin(String name,String password) {
		return mapper.selectAnBiaoLogin(name,password);
	}

	@Override
	public boolean insertSelective(Personnel personnel) {
		return mapper.insertSelective(personnel);
	}


}
