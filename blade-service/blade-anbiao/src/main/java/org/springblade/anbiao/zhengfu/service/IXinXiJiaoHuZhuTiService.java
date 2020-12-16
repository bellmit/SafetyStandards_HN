/**
 * Copyright (C), 2015-2020,
 * FileName: IXinXiJiaoHuZhuService
 * Author:   呵呵哒
 * Description:
 */
package org.springblade.anbiao.zhengfu.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
public interface IXinXiJiaoHuZhuTiService extends IService<XinXiJiaoHuZhuTi> {

	boolean insertTongZhiGongGao(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	boolean insertSelective(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	boolean updateByPrimaryKeySelective(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	boolean updateByPrimaryKey(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	XinXiJiaoHuZhuTiPage selectALLPage(XinXiJiaoHuZhuTiPage xinXiJiaoHuZhuTiPage);

	XinXiJiaoHuZhuTi selectById(XinXiJiaoHuZhuTi xinXiJiaoHuZhuTi);

	List<XinXiJiaoHuZhuTiVo> selectGetQiYe(@Param("deptId") String deptId, @Param("leixing") String leixing);

	Organization selectGetLeiXing(@Param("deptId") String deptId);

	XinXiJiaoHuZhuTi selectGetQYByOne(String deptId);

}
