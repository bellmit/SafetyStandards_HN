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
package org.springblade.anbiao.zhengfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.zhengfu.entity.AppVersionInfo;
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTi;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTiVo;
import org.springblade.anbiao.zhengfu.page.AppVersionInfoPage;
import org.springblade.anbiao.zhengfu.page.XinXiJiaoHuZhuTiPage;

import java.util.List;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2020/6/18
 * @描述
 */
public interface AppVersionInfoMapper extends BaseMapper<AppVersionInfo> {

	/**
	 * 新增APP版本文件
	 * @param appVersionInfo
	 * @return
	 */
	boolean insertSelective(AppVersionInfo appVersionInfo);

	/**
	 * 查询所欲APP版本文件
	 * @param appVersionInfoPage
	 * @return
	 */
	List<AppVersionInfo> selectALLPage(AppVersionInfoPage appVersionInfoPage);
	int selectAllTotal(AppVersionInfoPage appVersionInfoPage);

	/**
	 * 更新状态
	 * @param appVersionInfo
	 * @return
	 */
	boolean updateByPrimaryKey(AppVersionInfo appVersionInfo);
}
