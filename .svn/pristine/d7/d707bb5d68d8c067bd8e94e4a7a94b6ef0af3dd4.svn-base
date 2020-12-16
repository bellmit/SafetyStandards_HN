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
package org.springblade.anbiao.ranyoubutie.service.impl;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.ranyoubutie.entity.Gpsfuelveh;
import org.springblade.anbiao.ranyoubutie.page.GpsfuelvehPage;
import org.springblade.anbiao.ranyoubutie.mapper.GpsfuelvehMapper;
import org.springblade.anbiao.ranyoubutie.service.IGpsfuelvehService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *  服务实现类
 *
 * @author jx
 * @since 2019-10-20
 */
@Service
@AllArgsConstructor
public class GpsfuelvehServiceImpl extends ServiceImpl<GpsfuelvehMapper, Gpsfuelveh> implements IGpsfuelvehService {

	private GpsfuelvehMapper mapper;
/*
	@Override
	public IPage<GpsfuelvehVO> selectGpsfuelvehPage(IPage<GpsfuelvehVO> page, GpsfuelvehVO gpsfuelveh) {
		return page.setRecords(baseMapper.selectGpsfuelvehPage(page, gpsfuelveh));
	}*/

	@Override
	public void selectPageList(GpsfuelvehPage page) {
		String deptId = page.getDeptId();
		if(deptId.equals("1")){
			page.setDeptId(null);
		}
		List<Map<String,Object>> list = mapper.selectPageList(page);
		//添加查询条件
		List<Map<String,Object>> temp = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : list) {
			String chePai =(String)map.get("plate");
			String chePaiQuery = page.getChepaihao();
			if(StringUtils.isBlank(chePaiQuery)||chePai.contains(chePaiQuery)){
				temp.add(map);
			}
		}
		page.setTotal(temp.size());

		List<Map<String,Object>> temp2 = new ArrayList<Map<String,Object>>();              //创建list数组 ,用来保存分割后的list
		int j=0;
		int pages = page.getCurrent();
		int pageSize = page.getSize();
		if(pageSize>0){
			for(int i=0;i<temp.size();i++) {                                                         //按照数组大小遍历
				if(i>=pageSize*(pages-1)&&i<=pageSize*pages-1){
					temp2.add(temp.get(i));
					j++;
				}
				if(j>pageSize){
					break;
				}
			}
			page.setRecords(temp2);
		}else{
			page.setRecords(temp);
		}
	}

	@Override
	public GpsfuelvehPage selectAllList(GpsfuelvehPage page) {
		String sql = mapper.selectConcat(page);
		List<String> timeString = getColumn(page.getBeginTime(),page.getEndTime());
		page.setTimeString(timeString);
		page.setSql(sql);
		Integer total = mapper.selectTotal(page);
		if(page.getSize()==0){
			if(page.getTotal()==0){
				page.setTotal(total);
			}
			List<Map<String,Object>> list = mapper.selectAllList(page);
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
			List<Map<String,Object>> list = mapper.selectAllList(page);
			page.setRecords(list);
		}
			return page;



	}


	private List<String> getColumn(String beginTime,String endTime) {

		Calendar beginTimeCal = Calendar.getInstance();
		Calendar endTimeCal = Calendar.getInstance();
		Date beginTimeDate = DateUtil.parse(beginTime, "yyyy-MM-dd");
		Date endTimeDate = DateUtil.parse(endTime, "yyyy-MM-dd");
		beginTimeCal.setTime(beginTimeDate);
		endTimeCal.setTime(endTimeDate);
		// 测试此日期是否在指定日期之后
		if (endTimeCal.compareTo(beginTimeCal) >= 0) {
			List<String> columns = new ArrayList<String>();
			while (endTimeCal.compareTo(beginTimeCal)>=0) {
				/*int month = beginTimeCal.get(Calendar.MONTH);
				int day = beginTimeCal.get(Calendar.DAY_OF_MONTH);
				month++;*/
				//columns.add(month+"-"+day+"日");
				Date date = beginTimeCal.getTime();
				columns.add(DateUtil.format(date, "yyyy-MM-dd"));
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				beginTimeCal.add(Calendar.DAY_OF_MONTH, 1);

			}
			return columns;
		} else {
			return null;
		}

		/*if(endTimeCal.compareTo(beginTimeCal)>=0){

			while (endTimeCal.compareTo(beginTimeCal)>=0) {

				int month = beginTimeCal.get(Calendar.MONTH);
				int day = beginTimeCal.get(Calendar.DAY_OF_MONTH);
				month++;
				columns.add(month+"-"+day+"日");
				beginTimeCal.add(Calendar.DAY_OF_MONTH, 1);
			}
			return columns;
		}
	}*/
	}

}
