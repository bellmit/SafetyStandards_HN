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
package org.springblade.anbiao.cheliangguanli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.anbiao.cheliangguanli.entity.Cheliangweihu;
import org.springblade.anbiao.cheliangguanli.page.CheliangweihuPage;
import org.springblade.anbiao.cheliangguanli.vo.CheliangweihuVO;

/**
 *  服务类
 */
public interface ICheliangweihuService extends IService<Cheliangweihu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param cheliangweihu
	 * @return
	 */
	IPage<CheliangweihuVO> selectCheliangweihuPage(IPage<CheliangweihuVO> page, CheliangweihuVO cheliangweihu);

	CheliangweihuVO selectByIds(String id);

	boolean updateDel(String id);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	CheliangweihuPage<CheliangweihuVO> selectPageList(CheliangweihuPage Page);
}
