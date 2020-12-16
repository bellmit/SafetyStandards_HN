package org.springblade.anbiao.falvfagui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.falvfagui.entity.FaGui;
import org.springblade.anbiao.falvfagui.page.FaGuiPage;
import org.springblade.anbiao.falvfagui.vo.FaGuiVo;

/**
* @Description:
* @Param:
*/
public interface IFaGuiService extends IService<FaGui> {
	/**
	 * 自定义 分页
	 * @param faGuiPage
	 * @return
	 */
	FaGuiPage<FaGuiVo> selectFaGuiPage(FaGuiPage faGuiPage);
	/**
	 * 自定义删除
	 * @param id
	 * @return
	 */
	boolean deleteFagui(String id);

}
