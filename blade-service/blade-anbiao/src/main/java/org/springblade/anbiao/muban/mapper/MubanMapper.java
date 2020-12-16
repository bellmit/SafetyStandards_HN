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
package org.springblade.anbiao.muban.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.muban.entity.Muban;
import org.springblade.anbiao.muban.vo.MubanVO;

import java.util.List;

/**
 *  Mapper 接口
 * @author 呵呵哒
 */
public interface MubanMapper extends BaseMapper<Muban> {

	/**
	 * 获取模板数据
	 *
	 * @return
	 */
	List<MubanVO> selectMubanPage(Integer id);

	/**
	 * 获取数据
	 * @param token
	 * @return
	 */
	Muban selectByToken(String token);

	/**
	 * 根据名称查询数据
	 * @param muban
	 * @return
	 */
	Muban selectByName(String muban);


	/**
	 * 获取token个数
	 * @param token
	 * @return
	 */
	int CountToken(String token);

	/**
	 * 获取名称数量
	 * @param muban
	 * @return
	 */
	int CountMuban(String muban);

	/**
	 * 获取一键初始化表名
	 * @param id
	 * @return
	 */
	List<MubanVO> selectBiaoMing(Integer id);

}
