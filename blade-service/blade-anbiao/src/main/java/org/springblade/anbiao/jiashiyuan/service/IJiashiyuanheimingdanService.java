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
package org.springblade.anbiao.jiashiyuan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.jiashiyuan.entity.Jiashiyuanheimingdan;
import org.springblade.anbiao.jiashiyuan.page.JiashiyuanheimingdanPage;
import org.springblade.anbiao.jiashiyuan.vo.JiashiyuanheimingdanVO;

/**
 *  服务类
 */
public interface IJiashiyuanheimingdanService extends IService<Jiashiyuanheimingdan> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param jiashiyuanheimingdan
	 * @return
	 */
	IPage<JiashiyuanheimingdanVO> selectJiashiyuanheimingdanPage(IPage<JiashiyuanheimingdanVO> page, JiashiyuanheimingdanVO jiashiyuanheimingdan);

	boolean updateDel(String id);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	JiashiyuanheimingdanPage<JiashiyuanheimingdanVO> selectPageList(JiashiyuanheimingdanPage jiashiyuanheimingdanPage);

	JiashiyuanheimingdanVO selectByIds(String id);
}
