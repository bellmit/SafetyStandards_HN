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
package org.springblade.anbiao.orgmap.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.orgmap.entity.Orgmap;
import org.springblade.anbiao.orgmap.mapper.OrgmapMapper;
import org.springblade.anbiao.orgmap.service.IOrgmapService;
import org.springblade.anbiao.orgmap.vo.OrgmapVO;
import org.springblade.core.tool.node.ForestNodeMerger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 * @author 呵呵哒
 */
@Service
@AllArgsConstructor
public class OrgmapServiceImpl extends ServiceImpl<OrgmapMapper, Orgmap> implements IOrgmapService {

	private OrgmapMapper  baseMapper;

	@Override
	public IPage<OrgmapVO> selectOrgmapPage(IPage<OrgmapVO> page, OrgmapVO orgmap) {
		return page.setRecords(baseMapper.selectOrgmapPage(page, orgmap));
	}

	@Override
	public List<OrgmapVO> tree(String deptId) {
		return ForestNodeMerger.merge(baseMapper.tree(deptId));
	}

	@Override
	public OrgmapVO selectByCretaTime(String createtime, String deptName) {
		return baseMapper.selectByCretaTime(createtime,deptName);
	}

	@Override
	public int Countorg(Integer parentId) {
		return baseMapper.Countorg(parentId);
	}

}
