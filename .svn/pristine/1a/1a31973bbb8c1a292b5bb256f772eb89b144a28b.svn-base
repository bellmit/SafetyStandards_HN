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
package org.springblade.anbiao.cankaofangan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cankaofangan.entity.Cankaofangan;
import org.springblade.anbiao.cankaofangan.mapper.CankaofanganMapper;
import org.springblade.anbiao.cankaofangan.service.ICankaofanganService;
import org.springblade.anbiao.cankaofangan.vo.CankaofanganVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-06-14
 */
@Service
@AllArgsConstructor
public class CankaofanganServiceImpl extends ServiceImpl<CankaofanganMapper, Cankaofangan> implements ICankaofanganService {

	private  CankaofanganMapper mapper;
	@Override
	public IPage<CankaofanganVO> selectCankaofanganPage(IPage<CankaofanganVO> page, CankaofanganVO cankaofangan) {
		return page.setRecords(baseMapper.selectCankaofanganPage(page, cankaofangan));
	}

	@Override
	public List<Cankaofangan> getByRenwuleixing(String renwuleixing) {
		return mapper.getByRenwuleixing(renwuleixing);
	}

}
