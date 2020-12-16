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
import org.springblade.anbiao.zhengfu.entity.Organization;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTi;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuZhuTiVo;
import org.springblade.anbiao.zhengfu.page.XinXiJiaoHuZhuTiPage;

import java.util.List;

/**
 * @author 呵呵哒
 * @描述
 */
public interface XinXiJiaoHuZhuTiMapper extends BaseMapper<XinXiJiaoHuZhuTi> {

	boolean insertTongZhiGongGao(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	boolean insertSelective(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	boolean updateByPrimaryKeySelective(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	boolean updateByPrimaryKey(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	List<XinXiJiaoHuZhuTi> selectALLPage(XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage);

	int selectAllTotal(XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage);

	XinXiJiaoHuZhuTi selectById(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	List<XinXiJiaoHuZhuTiVo> selectGetQiYe(@Param("deptId") String deptId,@Param("leixing") String leixing);

	Organization selectGetLeiXing(@Param("deptId") String deptId);

	XinXiJiaoHuZhuTi selectGetQYByOne(String deptId);

	List<XinXiJiaoHuZhuTi> selectHFALLPage(XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage);
	int selectHFAllTotal(XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage);

}
