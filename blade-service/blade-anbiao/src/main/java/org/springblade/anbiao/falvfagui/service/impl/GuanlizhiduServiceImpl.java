package org.springblade.anbiao.falvfagui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.falvfagui.entity.Guanlizhidu;
import org.springblade.anbiao.falvfagui.mapper.GuanlizhiduMapper;
import org.springblade.anbiao.falvfagui.page.GuanlizhiduPage;
import org.springblade.anbiao.falvfagui.service.IGuanlizhiduService;
import org.springblade.anbiao.falvfagui.vo.GuanlizhiduVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理制度自定义接口实现
 *
 * @author :hyp
 */
@Service
@AllArgsConstructor
public class GuanlizhiduServiceImpl extends ServiceImpl<GuanlizhiduMapper, Guanlizhidu> implements IGuanlizhiduService {

    private GuanlizhiduMapper guanlizhiduMapper;

    @Override
    public GuanlizhiduPage<GuanlizhiduVO> selectGuanlizhiduPage(GuanlizhiduPage guanlizhiduPage) {
        Integer total = guanlizhiduMapper.selectGuanlizhiduTotal(guanlizhiduPage);
        Integer pagetotal = 0;
        if (total > 0) {
			if(total%guanlizhiduPage.getSize()==0){
				pagetotal = total / guanlizhiduPage.getSize();
			}else {
				pagetotal = total / guanlizhiduPage.getSize() + 1;
			}
        }
        if (pagetotal >= guanlizhiduPage.getCurrent()) {
            guanlizhiduPage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (guanlizhiduPage.getCurrent() > 1) {
                offsetNo = guanlizhiduPage.getSize() * (guanlizhiduPage.getCurrent() - 1);
            }
            guanlizhiduPage.setTotal(total);
            guanlizhiduPage.setOffsetNo(offsetNo);
            List<GuanlizhiduVO> vehlist = guanlizhiduMapper.selectGuanlizhiduPage(guanlizhiduPage);
            guanlizhiduPage.setRecords(vehlist);
        }
        return guanlizhiduPage;

    }

    @Override
    public GuanlizhiduVO selectByKey(String id) {
        return guanlizhiduMapper.selectByKey(id);
    }

    @Override
    public boolean deleleGuanlizhidu(String id) {
        return guanlizhiduMapper.deleteGuanlizhidu(id);
    }

}
