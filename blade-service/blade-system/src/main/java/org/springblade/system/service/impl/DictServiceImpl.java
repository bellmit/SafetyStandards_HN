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
package org.springblade.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTi;
import org.springblade.core.tool.node.ForestNodeMerger;
import org.springblade.core.tool.utils.Func;
import org.springblade.core.tool.utils.StringPool;
import org.springblade.system.entity.Dict;
import org.springblade.system.mapper.DictMapper;
import org.springblade.system.page.DictPage;
import org.springblade.system.service.IDictService;
import org.springblade.system.vo.DictVO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springblade.common.cache.CacheNames.DICT_LIST;
import static org.springblade.common.cache.CacheNames.DICT_VALUE;

/**
 * 服务实现类
 *
 * @author hyp
 */
@Service
@AllArgsConstructor
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

	private DictMapper dictMapper;

	@Override
	public IPage<DictVO> selectDictPage(IPage<DictVO> page, DictVO dict) {
		return page.setRecords(baseMapper.selectDictPage(page, dict));
	}

	@Override
	public List<DictVO> tree(DictPage dictPage) {
		return ForestNodeMerger.merge(baseMapper.tree(dictPage));
	}

	@Override
	@Cacheable(cacheNames = DICT_VALUE, key = "#code+'_'+#dictKey")
	public String getValue(String code, Integer dictKey) {
		return Func.toStr(baseMapper.getValue(code, dictKey), StringPool.EMPTY);
	}

	@Override
	@Cacheable(cacheNames = DICT_LIST, key = "#code")
	public List<Dict> getList(String code) {
		return baseMapper.getList(code);
	}

	@Override
	public DictPage selectALLPage(DictPage dictPage) {
		Integer total = dictMapper.selectAllTotal(dictPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%dictPage.getSize()==0){
				pagetotal = total / dictPage.getSize();
			}else {
				pagetotal = total / dictPage.getSize() + 1;
			}
		}
		if (pagetotal >= dictPage.getCurrent()) {
			dictPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (dictPage.getCurrent() > 1) {
				offsetNo = dictPage.getSize() * (dictPage.getCurrent() - 1);
			}
			dictPage.setTotal(total);
			dictPage.setOffsetNo(offsetNo);
			List<Dict> vehlist = dictMapper.selectALLPage(dictPage);
			dictPage.setRecords(vehlist);
		}
		return dictPage;
	}

	@Override
	public List<Dict> selectByCode(String code) {
		return baseMapper.selectByCode(code);
	}

	@Override
	@CacheEvict(cacheNames = {DICT_LIST, DICT_VALUE})
	public boolean submit(Dict dict) {
		LambdaQueryWrapper<Dict> lqw = Wrappers.<Dict>query().lambda().eq(Dict::getCode, dict.getCode()).eq(Dict::getDictKey, dict.getDictKey());
		Integer cnt = baseMapper.selectCount((Func.isEmpty(dict.getId())) ? lqw : lqw.notIn(Dict::getId, dict.getId()));
		if (cnt > 0) {
			throw new ApiException("当前字典键值已存在!");
		}
		return saveOrUpdate(dict);
	}

	@Override
	public List<DictVO> OtherTree(DictPage dictPage) {
		return baseMapper.OtherTree(dictPage);
	}

	@Override
	public List<DictVO> RegionalismTree(Integer id) {
		return baseMapper.RegionalismTree(id);
	}
}
