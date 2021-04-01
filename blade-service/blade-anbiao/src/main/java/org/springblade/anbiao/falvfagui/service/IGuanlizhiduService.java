package org.springblade.anbiao.falvfagui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.falvfagui.entity.Guanlizhidu;
import org.springblade.anbiao.falvfagui.page.GuanlizhiduPage;
import org.springblade.anbiao.falvfagui.vo.GuanlizhiduVO;

/**
 * 管理制度自定义 接口
 * @author :hyp
 * */
public interface IGuanlizhiduService extends IService<Guanlizhidu> {

    /**
     * 自定义 分页
     * @param guanlizhiduPage
     * @return
     */
    GuanlizhiduPage<GuanlizhiduVO> selectGuanlizhiduPage(GuanlizhiduPage guanlizhiduPage);

    /**
     * 根据id获取数据
     * *@param id
     * @return
     */
    GuanlizhiduVO selectByKey(String id);

    /**
     * 自定义 假删除
     * @param  id
     * @author :hyp
     * */
    boolean deleleGuanlizhidu(String id);

}
