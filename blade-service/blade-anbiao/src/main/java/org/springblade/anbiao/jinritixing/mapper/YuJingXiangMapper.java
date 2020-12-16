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
package org.springblade.anbiao.jinritixing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.anbiao.jinritixing.entity.Yujingquanxian;
import org.springblade.anbiao.jinritixing.entity.Yujingxiang;
import org.springblade.anbiao.jinritixing.page.YujingquanxianPage;
import org.springblade.anbiao.jinritixing.vo.YujingquanxianVO;
import org.springblade.anbiao.qiyeshouye.page.YuJingXiangPage;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author hyp
 * @since 2019-06-04
 */
public interface YuJingXiangMapper extends BaseMapper<Yujingxiang> {

	/**
	 * 自定义分页
	 * @return
	 */

	List<Yujingxiang> selectGetYJListTJ(YuJingXiangPage yuJingXiangPage);
	int selectGetYJListTJTotal(YuJingXiangPage yuJingXiangPage);

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
