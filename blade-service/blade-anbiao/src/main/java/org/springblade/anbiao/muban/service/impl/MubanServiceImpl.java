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
package org.springblade.anbiao.muban.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.muban.entity.Muban;
import org.springblade.anbiao.muban.entity.MubanMap;
import org.springblade.anbiao.muban.mapper.MubanMapMapper;
import org.springblade.anbiao.muban.mapper.MubanMapper;
import org.springblade.anbiao.muban.service.IMubanService;
import org.springblade.anbiao.muban.vo.MubanVO;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.node.ForestNodeMerger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  服务实现类
 * @author 呵呵哒
 */
@Service
@AllArgsConstructor
public class MubanServiceImpl extends ServiceImpl<MubanMapper, Muban> implements IMubanService {

	private MubanMapper mubanMapper;

	private MubanMapMapper mubanMapMapper;

	@Override
	public List<MubanVO> selectMubanPage(Integer id) {
		return ForestNodeMerger.merge(mubanMapper.selectMubanPage(id));
	}

	@Override
	public Muban selectByToken(String token) {
		return mubanMapper.selectByToken(token);
	}

	@Override
	public int CountToken(String token) {
		return mubanMapper.CountToken(token);
	}

	@Override
	public Muban selectByName(String muban) {
		return mubanMapper.selectByName(muban);
	}

	@Override
	public int CountMuban(String muban) {
		return mubanMapper.CountMuban(muban);
	}

	@Override
	public List<MubanMap> selectMapList(String tableName) {
		return mubanMapMapper.selectMapList(tableName);
	}

	@Override
	public R initConf(Integer deptId,String [] tables) {
		List<MubanMap> mubanMapList = new ArrayList<MubanMap>();
		for (String table : tables) {
			List<MubanMap> mubanMaps = mubanMapMapper.getConfByDeptIdForTable(deptId,table.trim());
			mubanMaps.forEach(item->item.setTableName(table.substring(0,table.lastIndexOf("_map")).trim()));
			mubanMapList.addAll(mubanMaps);
		}
		mubanMapMapper.delAll();
		mubanMapMapper.insertList(mubanMapList);
		return null;
	}

	@Override
	public List<MubanVO> selectBiaoMing(Integer id) {
		return mubanMapper.selectBiaoMing(id);
	}

}
