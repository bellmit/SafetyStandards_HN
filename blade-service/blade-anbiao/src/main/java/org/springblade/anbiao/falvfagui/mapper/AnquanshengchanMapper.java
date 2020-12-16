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
package org.springblade.anbiao.falvfagui.mapper;

import org.springblade.anbiao.falvfagui.entity.Anquanshengchan;
import org.springblade.anbiao.falvfagui.page.AnquanshengchanPage;
import org.springblade.anbiao.falvfagui.vo.AnquanshengchanVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author Blade
 * @since 2019-04-24
 */
public interface AnquanshengchanMapper extends BaseMapper<Anquanshengchan> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param anquanshengchan
	 * @return
	 */
	List<AnquanshengchanVO> selectAnquanshengchanPage(IPage page, AnquanshengchanVO anquanshengchan);

	boolean insertAnQuanShengChan(Anquanshengchan anquanshengchan);

	boolean updateDel(String id);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	List<AnquanshengchanVO> selectPageList(AnquanshengchanPage anquanshengchanPage);
	/**
	 * 统计
	 * @param
	 * @return
	 */
	int selectTotal(AnquanshengchanPage anquanshengchanPage);

	AnquanshengchanVO selectByIds(String id);
}
