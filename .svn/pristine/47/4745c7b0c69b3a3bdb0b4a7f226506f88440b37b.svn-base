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
package org.springblade.doc.qiyewenjian.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.node.ForestNodeMerger;
import org.springblade.doc.qiyewenjian.entity.Qiyewenjian;
import org.springblade.doc.qiyewenjian.mapper.QiyewenjianMapper;
import org.springblade.doc.qiyewenjian.service.IQiyewenjianService;
import org.springblade.doc.qiyewenjian.vo.QiyewenjianVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-05-28
 */
@Service
@AllArgsConstructor
public class QiyewenjianServiceImpl extends ServiceImpl<QiyewenjianMapper, Qiyewenjian> implements IQiyewenjianService {

	private  QiyewenjianMapper mapper;
	@Override
	public IPage<QiyewenjianVO> selectQiyewenjianPage(IPage<QiyewenjianVO> page, QiyewenjianVO qiyewenjian) {
		return page.setRecords(baseMapper.selectQiyewenjianPage(page, qiyewenjian));
	}

	@Override
	public Integer selectMaxId() {
		return mapper.selectMaxId();
	}

	@Override
	public Integer selectMaxSorByParentId(Integer id) {
		return mapper.selectMaxSorByParentId(id);
	}

	@Override
	public List<QiyewenjianVO> tree(Integer deptId, Integer parentId) {
		return ForestNodeMerger.merge(mapper.tree(deptId,parentId));
	}

	@Override
	public List<Qiyewenjian> getByParentId(Integer parentId) {
		return mapper.getByParentId(parentId);
	}

	@Override
	public boolean updateDocumentNumberById(Integer id, String documentNumber) {
		return mapper.updateDocumentNumberById(id,documentNumber);
	}

	@Override
	public boolean updateSortById(Integer originId, Integer sort) {
		return mapper.updateSortById(originId,sort);
	}

	@Override
	public int updatePreviewRecordById(Integer id) {
		return mapper.updatePreviewRecordById(id);
	}

}
