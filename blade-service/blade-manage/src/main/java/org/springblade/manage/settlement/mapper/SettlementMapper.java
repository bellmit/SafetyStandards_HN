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
package org.springblade.manage.settlement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.manage.settlement.entity.Settlement;
import org.springblade.manage.settlement.page.SettlementPage;
import org.springblade.manage.settlement.vo.SettlementVO;

import java.util.List;

/**
 *  Mapper 接口
 */
public interface SettlementMapper extends BaseMapper<Settlement> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @return
	 */
	List<SettlementVO> selectPageList(SettlementPage page);

	/**
	 * 统计
	 *
	 * @param page
	 * @return
	 */
	int selectTotal(SettlementPage page);

	/**
	 * 对内利润
	 *
	 * @param page
	 * @return
	 */
	List<SettlementVO> selectLirunList(SettlementPage page);

	/**
	 * 对内利润 统计
	 *
	 * @param page
	 * @return
	 */
	int selectLirunTotal(SettlementPage page);

	/**
	 * 对内利润
	 *
	 * @param page
	 * @return
	 */
	List<SettlementVO> selectZhiChuList(SettlementPage page);

	/**
	 * 对内利润 统计
	 *
	 * @param page
	 * @return
	 */
	int selectZhiChuTotal(SettlementPage page);


	/**
	* @Description: 根据运单id清楚数据
	* @Param: [waybillId]
	*/
	boolean delBywaybillId(String waybillId);

}
