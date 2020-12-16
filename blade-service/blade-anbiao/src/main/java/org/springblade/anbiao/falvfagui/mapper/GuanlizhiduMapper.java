package org.springblade.anbiao.falvfagui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.falvfagui.entity.Guanlizhidu;
import org.springblade.anbiao.falvfagui.page.GuanlizhiduPage;
import org.springblade.anbiao.falvfagui.vo.GuanlizhiduVO;

import java.util.List;

/**
 * 管理制度 Mapper 接口
 *
 * @author:elvis.he
 */
public interface GuanlizhiduMapper extends BaseMapper<Guanlizhidu> {

    /**
     * 自定义分页
     *
     * @param guanlizhiduPage
     * @return
     */
    List<GuanlizhiduVO> selectGuanlizhiduPage(GuanlizhiduPage guanlizhiduPage);

    /**
     * 统计
     *
     * @param guanlizhiduPage
     * @return
     */
    int selectGuanlizhiduTotal(GuanlizhiduPage guanlizhiduPage);

    /**
     * 根据id获取数据
     * *@param id
     *
     * @return
     */
    GuanlizhiduVO selectByKey(String id);

    /**
     * 自定义删除
     *
     * @param id
     * @return
     */
    boolean deleteGuanlizhidu(String id);

}
