package org.springblade.anbiao.cheliangziping.service;

import org.springblade.anbiao.cheliangziping.entity.Zipingjieguocongbiao;
import org.springblade.anbiao.cheliangziping.entity.Zipingwenjian;
import org.springblade.anbiao.cheliangziping.page.ZipinwenjianPage;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/316:19
 */
public interface IZipinwenjianServic {

	/**
	 * 分页查询
	 * @return
	 */
	ZipinwenjianPage selectpage(ZipinwenjianPage zipinjianchajieguoPage);
	/**
	 * 删除文档
	 */
	int deletawendang(String id);

	/**
	 * 新增
	 */
	int insertwendang(Zipingwenjian zIpingwenjian);
	/**
	 * 删除历史清空 记录
	 */

	int deletelishi(String id);

}
