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
package org.springblade.doc.biaozhunhuamuban.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuawenjian;
import org.springblade.doc.biaozhunhuamuban.mapper.BiaozhunhuawenjianMapper;
import org.springblade.doc.biaozhunhuamuban.service.IBiaozhunhuawenjianService;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuawenjianVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author th
 * @since 2019-05-10
 */
@Service
@AllArgsConstructor
public class BiaozhunhuawenjianServiceImpl extends ServiceImpl<BiaozhunhuawenjianMapper, Biaozhunhuawenjian> implements IBiaozhunhuawenjianService {

	private BiaozhunhuawenjianMapper Mapper;

	@Override
	public IPage<BiaozhunhuawenjianVO> selectBiaozhunhuawenjianPage(IPage<BiaozhunhuawenjianVO> page, BiaozhunhuawenjianVO biaozhunhuawenjian) {
		return page.setRecords(Mapper.selectBiaozhunhuawenjianPage(page, biaozhunhuawenjian));
	}

	@Override
	public BiaozhunhuawenjianVO selectPicPath(Integer biaozhunhuamubanId, Integer fileType) {
		return Mapper.selectPicPath(biaozhunhuamubanId,fileType);
	}

	@Override
	public int removeByMubanId(Integer mubanId) {
		return Mapper.removeByMubanId(mubanId);
	}

	@Override
	public List<Biaozhunhuawenjian> getByMubanId(Integer mubanId) {
		return Mapper.getByMubanId(mubanId);
	}

	@Override
	public BiaozhunhuawenjianVO selectPicPathBySuoshurenId(String fileProperty, Integer fileSuoshurenId) {
		return Mapper.selectPicPathBySuoshurenId(fileProperty,fileSuoshurenId);
	}

	@Override
	public int updatePreviewRecordById(Integer id) {
		return Mapper.updatePreviewRecordById(id);
	}

}
