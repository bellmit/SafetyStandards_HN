package org.springblade.anbiao.falvfagui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.falvfagui.entity.FaGui;
import org.springblade.anbiao.falvfagui.mapper.FaGuiMapper;
import org.springblade.anbiao.falvfagui.page.FaGuiPage;
import org.springblade.anbiao.falvfagui.service.IFaGuiService;
import org.springblade.anbiao.falvfagui.vo.FaGuiVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SafetyStandards
 **/
@Service
@AllArgsConstructor
public class FaGuiServiceImpl  extends ServiceImpl<FaGuiMapper, FaGui> implements IFaGuiService {

	private FaGuiMapper faguiMapper;


	@Override
	public FaGuiPage<FaGuiVo> selectFaGuiPage(FaGuiPage faGuiPage) {
		Integer total = faguiMapper.selectFaGuiTotal(faGuiPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%faGuiPage.getSize()==0){
				pagetotal = total / faGuiPage.getSize();
			}else {
				pagetotal = total / faGuiPage.getSize() + 1;
			}
		}
		if (pagetotal < faGuiPage.getCurrent()) {
			return faGuiPage;
		} else {
			faGuiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (faGuiPage.getCurrent() > 1) {
				offsetNo = faGuiPage.getSize() * (faGuiPage.getCurrent() - 1);
			}
			faGuiPage.setTotal(total);
			faGuiPage.setOffsetNo(offsetNo);
			List<FaGuiVo> list = faguiMapper.selectFaGuiPage(faGuiPage);
			return (FaGuiPage<FaGuiVo>) faGuiPage.setRecords(list);
		}
	}

	@Override
	public boolean deleteFagui(String id) {
		return faguiMapper.deleteFagui(id);
	}

}
