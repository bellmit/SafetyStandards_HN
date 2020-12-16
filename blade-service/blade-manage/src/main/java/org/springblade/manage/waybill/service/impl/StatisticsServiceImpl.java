package org.springblade.manage.waybill.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.manage.waybill.entity.Statistics;
import org.springblade.manage.waybill.mapper.StatisicsMapper;
import org.springblade.manage.waybill.page.StatisticsPage;
import org.springblade.manage.waybill.service.IStatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SafetyStandards
 * @description: StatisticsServiceImpl
 **/
@Service
@AllArgsConstructor
public class StatisticsServiceImpl implements IStatisticsService {

	private StatisicsMapper statisicsMapper;

	@Override
	public StatisticsPage<Statistics> selectPageList(StatisticsPage page) {
		int total = statisicsMapper.selectTotal(page);
		if(page.getSize()==0){
			if(page.getTotal()==0){
				page.setTotal(total);
			}

			List<Statistics> list = statisicsMapper.selectPageList(page);
			page.setRecords(list);
			return page;

		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / page.getSize() + 1;
		}
		if (pagetotal >= page.getCurrent() && pagetotal > 0) {
			page.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (page.getCurrent() > 1) {
				offsetNo = page.getSize() * (page.getCurrent() - 1);
			}
			page.setTotal(total);
			page.setOffsetNo(offsetNo);
			List<Statistics> list = statisicsMapper.selectPageList(page);
			page.setRecords(list);
		}
		return page;
	}
}
