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
package org.springblade.anbiao.jiaoyupeixun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.jiaoyupeixun.entity.JiaoyupeixunRenyuan;
import org.springblade.anbiao.jiaoyupeixun.page.JiaoyupeixunRenyuanPage;
import org.springblade.anbiao.jiaoyupeixun.vo.JiaoyupeixunRenyuanVO;

/**
 *  服务类
 *
 * @author Blade
 * @since 2019-04-25
 */
public interface IJiaoyupeixunRenyuanService extends IService<JiaoyupeixunRenyuan> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param jiaoyupeixunRenyuan
	 * @return
	 */
	IPage<JiaoyupeixunRenyuanVO> selectJiaoyupeixunRenyuanPage(IPage<JiaoyupeixunRenyuanVO> page, JiaoyupeixunRenyuanVO jiaoyupeixunRenyuan);

	boolean updateDel(String id);

	boolean insertRenYuan(JiaoyupeixunRenyuan jiaoyupeixunRenyuan);

	/**
	 * 自定义 分页
	 * @param
	 * @return
	 */
	JiaoyupeixunRenyuanPage<JiaoyupeixunRenyuanVO> selectPageList(JiaoyupeixunRenyuanPage jiaoyupeixunRenyuanPage);
}
