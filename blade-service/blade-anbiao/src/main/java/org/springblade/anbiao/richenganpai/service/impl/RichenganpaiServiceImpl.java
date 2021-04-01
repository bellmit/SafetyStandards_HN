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
package org.springblade.anbiao.richenganpai.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.richenganpai.entity.Richenganpai;
import org.springblade.anbiao.richenganpai.mapper.RichenganpaiMapper;
import org.springblade.anbiao.richenganpai.page.RiChengAnPaiPage;
import org.springblade.anbiao.richenganpai.service.IRichenganpaiService;
import org.springblade.anbiao.richenganpai.vo.RichengIndexVo;
import org.springblade.anbiao.richenganpai.vo.RichenganpaiVO;
import org.springblade.system.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-06-06
 */
@Service
@AllArgsConstructor
public class RichenganpaiServiceImpl extends ServiceImpl<RichenganpaiMapper, Richenganpai> implements IRichenganpaiService {

	private RichenganpaiMapper mapper;

	@Override
	public IPage<RichenganpaiVO> selectRichenganpaiPage(IPage<RichenganpaiVO> page, RichenganpaiVO richenganpai) {
		return page.setRecords(baseMapper.selectRichenganpaiPage(page, richenganpai));
	}

	@Override
	public List<RichengIndexVo> selectRichengIndex(Integer deptId, Integer userId, String date) {
		return mapper.selectRichengIndex(deptId,userId,date);
	}

	@Override
	public RiChengAnPaiPage<RichenganpaiVO> selectByDate(RiChengAnPaiPage riChengAnPaiPage) {
		Integer total = mapper.selectByDateTotal(riChengAnPaiPage);
		if(riChengAnPaiPage.getSize()==0){
			if(riChengAnPaiPage.getTotal()==0){
				riChengAnPaiPage.setTotal(total);
			}
			if(riChengAnPaiPage.getTotal()==0){
				return riChengAnPaiPage;
			}else{
				List<RichenganpaiVO> richenganpaiVOList = mapper.selectByDate(riChengAnPaiPage);
				riChengAnPaiPage.setRecords(richenganpaiVOList);
				return riChengAnPaiPage;
			}
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%riChengAnPaiPage.getSize()==0){
				pagetotal = total / riChengAnPaiPage.getSize();
			}else {
				pagetotal = total / riChengAnPaiPage.getSize() + 1;
			}
		}
		if (pagetotal >= riChengAnPaiPage.getCurrent()) {
			riChengAnPaiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (riChengAnPaiPage.getCurrent() > 1) {
				offsetNo = riChengAnPaiPage.getSize() * (riChengAnPaiPage.getCurrent() - 1);
			}
			riChengAnPaiPage.setTotal(total);
			riChengAnPaiPage.setOffsetNo(offsetNo);
			List<RichenganpaiVO> richenganpaiVOList = mapper.selectByDate(riChengAnPaiPage);
			riChengAnPaiPage.setRecords(richenganpaiVOList);
		}
		return riChengAnPaiPage;
	}

	@Override
	public RiChengAnPaiPage<RichenganpaiVO> selectChaoQiByDate(RiChengAnPaiPage riChengAnPaiPage) {
		Integer total = mapper.selectChaoQiByDateTotal(riChengAnPaiPage);
		if(riChengAnPaiPage.getSize()==0){
			if(riChengAnPaiPage.getTotal()==0){
				riChengAnPaiPage.setTotal(total);
			}
			if(riChengAnPaiPage.getTotal()==0){
				return riChengAnPaiPage;
			}else{
				List<RichenganpaiVO> richenganpaiVOList = mapper.selectChaoQiByDate(riChengAnPaiPage);
				riChengAnPaiPage.setRecords(richenganpaiVOList);
				return riChengAnPaiPage;
			}
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%riChengAnPaiPage.getSize()==0){
				pagetotal = total / riChengAnPaiPage.getSize();
			}else {
				pagetotal = total / riChengAnPaiPage.getSize() + 1;
			}
		}
		if (pagetotal >= riChengAnPaiPage.getCurrent()) {
			riChengAnPaiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (riChengAnPaiPage.getCurrent() > 1) {
				offsetNo = riChengAnPaiPage.getSize() * (riChengAnPaiPage.getCurrent() - 1);
			}
			riChengAnPaiPage.setTotal(total);
			riChengAnPaiPage.setOffsetNo(offsetNo);
			List<RichenganpaiVO> richenganpaiVOList = mapper.selectChaoQiByDate(riChengAnPaiPage);
			riChengAnPaiPage.setRecords(richenganpaiVOList);
		}
		return riChengAnPaiPage;
	}

	@Override
	public RiChengAnPaiPage<RichenganpaiVO> selectAnpaiByUser(RiChengAnPaiPage riChengAnPaiPage) {
		Integer total = mapper.selectAnpaiByUserTotal(riChengAnPaiPage);
		if(riChengAnPaiPage.getSize()==0){
			if(riChengAnPaiPage.getTotal()==0){
				riChengAnPaiPage.setTotal(total);
			}

			if(riChengAnPaiPage.getTotal()==0){
				return riChengAnPaiPage;
			}else{
				List<RichenganpaiVO> richenganpaiVOList = mapper.selectAnpaiByUser(riChengAnPaiPage);
				riChengAnPaiPage.setRecords(richenganpaiVOList);
				return riChengAnPaiPage;
			}
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%riChengAnPaiPage.getSize()==0){
				pagetotal = total / riChengAnPaiPage.getSize();
			}else {
				pagetotal = total / riChengAnPaiPage.getSize() + 1;
			}
		}
		if (pagetotal >= riChengAnPaiPage.getCurrent()) {
			riChengAnPaiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (riChengAnPaiPage.getCurrent() > 1) {
				offsetNo = riChengAnPaiPage.getSize() * (riChengAnPaiPage.getCurrent() - 1);
			}
			riChengAnPaiPage.setTotal(total);
			riChengAnPaiPage.setOffsetNo(offsetNo);
			List<RichenganpaiVO> richenganpaiVOList = mapper.selectAnpaiByUser(riChengAnPaiPage);
			riChengAnPaiPage.setRecords(richenganpaiVOList);
		}
		return riChengAnPaiPage;
	}

	@Override
	public boolean insertSelective(Richenganpai richenganpaiVO) {
		return mapper.insertSelective(richenganpaiVO);
	}

	@Override
	public boolean updateSelective(Richenganpai richenganpaiVO) {
		return mapper.updateSelective(richenganpaiVO);
	}

	@Override
	public Richenganpai selectByIds(String Id) {
		return mapper.selectByIds(Id);
	}

	@Override
	public boolean deleteBind(String updateTime, String updateUser, Integer updateUserId, Integer Id) {
		return mapper.deleteBind(updateTime, updateUser, updateUserId, Id);
	}

	@Override
	public User getUserById(Integer id) {
		return mapper.getUserById(id);
	}

}
