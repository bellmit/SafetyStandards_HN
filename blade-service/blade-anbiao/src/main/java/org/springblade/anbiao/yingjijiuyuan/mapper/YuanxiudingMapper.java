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
package org.springblade.anbiao.yingjijiuyuan.mapper;

import org.springblade.anbiao.yingjijiuyuan.entity.Yuanxiuding;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 *  应急预案-修订完善记录 Mapper 接口
 *
 * @author hyp
 * @since 2019-04-25
 */
public interface YuanxiudingMapper extends BaseMapper<Yuanxiuding> {

	/**
	 * 根据应急预案id 查询列表
	 *
	 * @param id
	 * @return
	 */
	List<Yuanxiuding> selectByYuanId(String id);

	/**
	 * 自定义删除
	 *
	 * @param id
	 * @return
	 */
	boolean deleteYuanxiuding(String id);

}
