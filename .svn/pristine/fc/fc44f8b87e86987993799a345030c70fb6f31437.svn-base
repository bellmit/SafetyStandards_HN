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
import org.springblade.anbiao.richenganpai.service.IRichenganpaiService;
import org.springblade.anbiao.richenganpai.vo.RichengIndexVo;
import org.springblade.anbiao.richenganpai.vo.RichenganpaiVO;
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
	public List<RichenganpaiVO> getByDate(Integer deptId, String date, Integer userId) {
		return mapper.getByDate(deptId,date,userId);
	}

	@Override
	public List<RichenganpaiVO> getChaoqiByDate(Integer deptId, Integer userId) {
		return mapper.getChaoqiByDate(deptId,userId);
	}

	@Override
	public List<RichenganpaiVO> getAnpaiByUser(Integer deptId, Integer userId) {
		return mapper.getAnpaiByUser(deptId,userId);
	}

}
