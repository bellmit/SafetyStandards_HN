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
package org.springblade.anbiao.anquanmubiao.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.anquanmubiao.entity.Mubiaokaohe;
import org.springblade.anbiao.anquanmubiao.page.MubiaokaohePage;
import org.springblade.anbiao.anquanmubiao.vo.MubiaokaoheVO;

import java.util.List;

/**
 *  服务类
 *
 * @author Blade
 * @since 2019-04-28
 */
public interface IMubiaokaoheService extends IService<Mubiaokaohe> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param mubiaokaohe
	 * @return
	 */
	IPage<MubiaokaoheVO> selectMubiaokaohePage(IPage<MubiaokaoheVO> page, MubiaokaoheVO mubiaokaohe);

	boolean updateDel(String id);

	boolean insertMuBiaoKaoHe(Mubiaokaohe mubiaokaohe);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	MubiaokaohePage<MubiaokaoheVO> selectPageList(MubiaokaohePage mubiaokaohePage);

	MubiaokaoheVO selectByIds(String id);
}
