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
package org.springblade.anbiao.richenganpai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import feign.Param;
import org.springblade.anbiao.richenganpai.entity.Richenganpai;
import org.springblade.anbiao.richenganpai.page.RiChengAnPaiPage;
import org.springblade.anbiao.richenganpai.vo.RichengIndexVo;
import org.springblade.anbiao.richenganpai.vo.RichenganpaiVO;
import org.springblade.system.user.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author Blade
 * @since 2019-06-06
 */
public interface RichenganpaiMapper extends BaseMapper<Richenganpai> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param richenganpai
	 * @return
	 */
	List<RichenganpaiVO> selectRichenganpaiPage(IPage page, RichenganpaiVO richenganpai);

	/**
	 *查询日程首页数据
	 * @author: hyp
	 * @date: 2019/6/6 10:21
	 * @param deptId
	 * @param userId
	 * @param date
	 */
	List<RichengIndexVo> selectRichengIndex(@Param("deptId") Integer deptId, @Param("userId")Integer userId, @Param("date")String date);

	/**
	 *获取日程代办事项
	 * @author: hyp
	 * @date: 2019/6/6 13:56
	 */
	List<RichenganpaiVO> selectByDate(RiChengAnPaiPage riChengAnPaiPage);
	int selectByDateTotal(RiChengAnPaiPage riChengAnPaiPage);

	/**
	 *获取超期日程
	 * @author: hyp
	 * @date: 2019/6/6 15:11
	 */
	List<RichenganpaiVO> selectChaoQiByDate(RiChengAnPaiPage riChengAnPaiPage);
	int selectChaoQiByDateTotal(RiChengAnPaiPage riChengAnPaiPage);

	/**
	 *获取安排的日程
	 * @author: hyp
	 * @date: 2019/6/21 11:20
	 */
	List<RichenganpaiVO> selectAnpaiByUser(RiChengAnPaiPage riChengAnPaiPage);
	int selectAnpaiByUserTotal(RiChengAnPaiPage riChengAnPaiPage);

	/**
	 * 新增日程待办
	 * @param richenganpaiVO
	 * @return
	 */
	boolean insertSelective(Richenganpai richenganpaiVO);

	/**
	 * 根据ID修改日程待办相应信息
	 * @param richenganpaiVO
	 * @return
	 */
	boolean updateSelective(Richenganpai richenganpaiVO);

	/**
	 * 根据ID查询日程待办详情
	 * @param Id
	 * @return
	 */
	Richenganpai selectByIds(String Id);

	/**
	 * 删除日程待办
	 * @param updateTime
	 * @param updateUser
	 * @param updateUserId
	 * @param Id
	 * @return
	 */
	boolean deleteBind(@RequestParam("updateTime") String updateTime,
					   @RequestParam("updateUser") String updateUser,
					   @RequestParam("updateUserId") Integer updateUserId,
					   @RequestParam("Id") Integer Id);

	/**
	 * 根据用户id获取数据
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);

}
