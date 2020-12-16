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
package org.springblade.anbiao.ranyoubutie.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import org.springblade.anbiao.ranyoubutie.entity.Gpsfuelveh;
import org.springblade.anbiao.ranyoubutie.page.GpsfuelvehPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

/**
 *  Mapper 接口
 *
 * @author jx
 * @since 2019-10-20
 */
public interface GpsfuelvehMapper extends BaseMapper<Gpsfuelveh> {


	//List<GpsfuelvehVO> selectGpsfuelvehPage(IPage page, GpsfuelvehVO gpsfuelveh);
	@SqlParser(filter=true)
	List<Map<String,Object>> selectPageList(GpsfuelvehPage page);

	@SqlParser(filter=true)
	List<Map<String,Object>> selectAllList(GpsfuelvehPage page);

	@SqlParser(filter=true)
	String selectConcat(GpsfuelvehPage page);

	@SqlParser(filter=true)
	int selectTotal(GpsfuelvehPage page);



}
