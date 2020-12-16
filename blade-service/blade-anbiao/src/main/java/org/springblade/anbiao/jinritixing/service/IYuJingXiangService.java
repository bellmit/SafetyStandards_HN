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
package org.springblade.anbiao.jinritixing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.jinritixing.entity.Yujingxiang;
import org.springblade.anbiao.qiyeshouye.page.YuJingXiangPage;

/**
 *  服务类
 *
 * @author hyp
 * @since 2019-06-04
 */
public interface IYuJingXiangService extends IService<Yujingxiang> {

	/**
	 * 自定义分页
	 *
	 * @param yuJingXiangPage
	 * @return
	 */
	YuJingXiangPage<Yujingxiang> selectGetYJListTJ(YuJingXiangPage yuJingXiangPage);

	/**
	 * 新增
	 * @param yujingxiang
	 * @return
	 */
	boolean insertSelective(Yujingxiang yujingxiang);

	/**
	 * 编辑
	 * @param yujingxiang
	 * @return
	 */
	boolean updateByPrimaryKeySelective(Yujingxiang yujingxiang);

	/**
	 * 查看
	 * @param id
	 * @return
	 */
	Yujingxiang selectGetQYByOne(String id);
}
