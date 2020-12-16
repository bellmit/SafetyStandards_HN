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
package org.springblade.alarm.service.impl;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import org.springblade.alarm.entity.Alarmvehdailyreport;
import org.springblade.alarm.entity.Vehdailyreport;
import org.springblade.alarm.page.VehdailyreportPage;
import org.springblade.alarm.tool.Json;
import org.springblade.alarm.vo.VehdailyreportVO;
import org.springblade.alarm.mapper.VehdailyreportMapper;
import org.springblade.alarm.service.IVehdailyreportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-06-28
 */
@Service
@AllArgsConstructor
public class VehdailyreportServiceImpl extends ServiceImpl<VehdailyreportMapper, Vehdailyreport> implements IVehdailyreportService {
	VehdailyreportMapper vehdailyreportMapper;

	@Override
	public IPage<VehdailyreportVO> selectVehdailyreportPage(IPage<VehdailyreportVO> page, VehdailyreportVO vehdailyreport) {
		return page.setRecords(baseMapper.selectVehdailyreportPage(page, vehdailyreport));
	}

	@Override
	public VehdailyreportPage<Vehdailyreport> selectall(VehdailyreportPage vehdailyreportPage) {
		//System.out.println(vehdailyreportPage.toString());
		Integer total =vehdailyreportMapper.findpageList(vehdailyreportPage);
		if(vehdailyreportPage.getSize()==0){
			if(vehdailyreportPage.getTotal()==0){
				vehdailyreportPage.setTotal(total);
			}

			List<Vehdailyreport> list=vehdailyreportMapper.selectall(vehdailyreportPage);
			vehdailyreportPage.setRecords(list);
			return vehdailyreportPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / vehdailyreportPage.getSize() + 1;
		}
		if (pagetotal >= vehdailyreportPage.getCurrent() && pagetotal > 0) {
			vehdailyreportPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (vehdailyreportPage.getCurrent() > 1) {
				offsetNo = vehdailyreportPage.getSize() * (vehdailyreportPage.getCurrent() - 1);
			}

			vehdailyreportPage.setTotal(total);
			vehdailyreportPage.setOffsetNo(offsetNo);
			System.out.println(vehdailyreportPage.toString());
			List<Vehdailyreport> list=vehdailyreportMapper.selectall(vehdailyreportPage);
//				for (Vehdailyreport data:list){
//					//请求高德地图 获取经度纬度位置 获取位置
//						String  kaishiweizhi=Json.getjson(data.getX().toString(),data.getY().toString());
//						data.setKaishiweizhi(kaishiweizhi);
//						String  jieshuweizhi=Json.getjson(data.getX2().toString(),data.getY2().toString());
//						data.setJieshuweizhi(jieshuweizhi);
//
//				}


			vehdailyreportPage.setRecords(list);
		}






		return vehdailyreportPage;
	}


}





