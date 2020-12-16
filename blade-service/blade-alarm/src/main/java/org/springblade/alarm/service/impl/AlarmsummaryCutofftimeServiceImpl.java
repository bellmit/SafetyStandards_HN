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

import cn.hutool.core.date.DateUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.alarm.entity.AlarmBaojingTongji;
import org.springblade.alarm.entity.AlarmsummaryCutofftime;
import org.springblade.alarm.entity.AlarmsummaryCutofftimeMG;
import org.springblade.alarm.mapper.AlarmsummaryCutofftimeMapper;
import org.springblade.alarm.page.AlarmPage;
import org.springblade.alarm.page.AlarmTimePage;
import org.springblade.alarm.page.ShishiBaojingTongjiPage;
import org.springblade.alarm.service.IAlarmsummaryCutofftimeService;
import org.springblade.alarm.vo.AlarmsummaryCutofftimeVO;
import org.springblade.common.enumconstant.EnmuAlarm;
import org.springblade.common.tool.GpsToBaiduUtil;
import org.springblade.common.tool.LatLotForLocation;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * gps平台报警 服务实现类
 *
 * @author elvis.he
 * @since 2019-05-12
 */
@Service
@AllArgsConstructor
public class AlarmsummaryCutofftimeServiceImpl extends ServiceImpl<AlarmsummaryCutofftimeMapper, AlarmsummaryCutofftime> implements IAlarmsummaryCutofftimeService {

    private AlarmsummaryCutofftimeMapper cutofftimeMapper;
    private MongoTemplate mongoTemplate;

    @Override
    public AlarmPage<AlarmsummaryCutofftimeVO> selectAlarmPage(AlarmPage alarmPage) {

    	if("未申诉".equals(alarmPage.getShifoushenshu()) && "已处理".equals(alarmPage.getShifouchuli())){
			alarmPage.setShifoushenshu("");
		}else if("已申诉".equals(alarmPage.getShifoushenshu()) && "未处理".equals(alarmPage.getShifouchuli())){
			alarmPage.setShifouchuli("");
		}else if("已申诉".equals(alarmPage.getShifoushenshu()) && "已处理".equals(alarmPage.getShifouchuli())){

		}
        Integer total = cutofftimeMapper.selectAlarmTotal(alarmPage);
        if(total==0){
            return alarmPage;
        }
        //导出
		if(alarmPage.getSize()==0){
			if(alarmPage.getTotal()==0){
				alarmPage.setTotal(total);
			}
			List<AlarmsummaryCutofftimeVO> list=cutofftimeMapper.selectAlarmPage(alarmPage);
			list.forEach(item->{
				if(item.getRemark()==null){
					item.setShensuzhuangtai("未申诉");
					item.setChulizhuangtai("未处理");
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}else if(item.getRemark()==1){
					EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
					item.setChulizhuangtai(byValue.desc);
					item.setShensuzhuangtai("未申诉");
				}else if(item.getRemark() == 0 && item.getShensushenhebiaoshi() == 0){
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(4));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}else if(item.getRemark() == 0 && item.getShensushenhebiaoshi() == 1){
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(5));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}else if(item.getRemark() == 0 && item.getShensushenhebiaoshi() == 2){
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(6));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}else{
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude().toString());
					double lon = Double.parseDouble(item.getLongitude().toString());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP));
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP));
					String LocalName= LatLotForLocation.getProvince(item.getLatitude().toString(),item.getLongitude().toString());
					item.setRoadName(LocalName);
				}
            });
			alarmPage.setRecords(list);
			return alarmPage;
		}
		//分页查询
        Integer pagetotal = 0;
        if (total > 0) {
            pagetotal = total / alarmPage.getSize() + 1;
        }
        if (pagetotal >= alarmPage.getCurrent() && pagetotal > 0) {
            alarmPage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (alarmPage.getCurrent() > 1) {
                offsetNo = alarmPage.getSize() * (alarmPage.getCurrent() - 1);
            }
            alarmPage.setTotal(total);
            alarmPage.setOffsetNo(offsetNo);
            List<AlarmsummaryCutofftimeVO> rows = cutofftimeMapper.selectAlarmPage(alarmPage);
            rows.forEach(item->{
                if(item.getRemark()==null){
                    item.setShensuzhuangtai("未申诉");
                    item.setChulizhuangtai("未处理");
                    item.setChulimiaoshu("");
                    item.setChulixingshi("");
                }else if(item.getRemark()==1){
                    EnmuAlarm.ChuliJieguo byValue = EnmuAlarm.ChuliJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
                    item.setChulizhuangtai(byValue.desc);
                    item.setShensuzhuangtai("未申诉");
                }else if(item.getRemark() == 0 && item.getShensushenhebiaoshi() == 0){
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(4));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}else if(item.getRemark() == 0 && item.getShensushenhebiaoshi() == 1){
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(5));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}else if(item.getRemark() == 0 && item.getShensushenhebiaoshi() == 2){
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(6));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}else{
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
					item.setShensuzhuangtai(byValue.desc);
                    item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
                }
				if(StringUtils.isBlank(item.getRoadName())){
					double lat = Double.parseDouble(item.getLatitude().toString());
					double lon = Double.parseDouble(item.getLongitude().toString());
					double[] zuobiao = GpsToBaiduUtil.wgs2bd(lat,lon);
					item.setLatitude(new BigDecimal(zuobiao[0]).setScale(6,BigDecimal.ROUND_HALF_UP));
					item.setLongitude(new BigDecimal(zuobiao[1]).setScale(6,BigDecimal.ROUND_HALF_UP));
					String LocalName= LatLotForLocation.getProvince(item.getLatitude().toString(),item.getLongitude().toString());
					item.setRoadName(LocalName);
				}
            });
            alarmPage.setRecords(rows);
            //添加报警统计
            AlarmBaojingTongji baojingTongji = cutofftimeMapper.selectBaojingtongji(alarmPage);
            baojingTongji.setAlarmType(alarmPage.getAlarmType());
            baojingTongji.setCountDate(alarmPage.getBeginTime() + "-" + alarmPage.getEndTime());
            int handlecount = baojingTongji.getHandledCount();
            int alarmcount = baojingTongji.getAlarmCount();
            String handlerate = "0%";
            if (handlecount > 0 && alarmcount > 0) {
                handlerate = (float)Math.round((float) handlecount / (float) alarmcount * 10000)/100 + "%";
            }
            baojingTongji.setHandledRate(handlerate);
            alarmPage.setBaojingTongji(baojingTongji);
        }
        return alarmPage;
    }

    @Override
    public Map<String, Object> selectShishiBaojingTongji(ShishiBaojingTongjiPage page) {
        return cutofftimeMapper.selectShishiBaojingTongji(page);
    }

    @Override
    public AlarmsummaryCutofftimeVO selectAlarmDetail(String id) {
        return cutofftimeMapper.selectAlarmDetail(id);
    }

    @Override
    public Map<String, Object> selectShifouBaojing(ShishiBaojingTongjiPage shishiBaojingTongjiPage) {
        List<String> strings = cutofftimeMapper.selectShifouBaojing(shishiBaojingTongjiPage);
        Map<String,Object> gpsMap = new HashMap<String,Object>();
        gpsMap.put("chaosu",0);
        gpsMap.put("pilao",0);
        gpsMap.put("yejian",0);
        gpsMap.put("yichang",0);
        strings.forEach(item->{
            if("超速报警".equals(item)){
                gpsMap.put("chaosu",1);
            }else if("疲劳驾驶报警".equals(item)){
                gpsMap.put("pilao",1);
            }else if("夜间行驶报警".equals(item)){
                gpsMap.put("yejian",1);
            }else{
                gpsMap.put("yichang",1);
            }
        });
        return gpsMap;
    }

    @Override
    public AlarmPage selectAlarmMGPage(AlarmPage alarmPage) {
        List<String> companys = cutofftimeMapper.getCompany(alarmPage.getDeptId());
        //子级企业集合是否包含单个企业名称
        Boolean flg = null;
        if(StringUtil.isNotEmpty(alarmPage.getJigouName())){
            flg = companys.contains(alarmPage.getJigouName());
        }
        //报警类型过滤
        Criteria lte = Criteria.where("AlarmType").is(alarmPage.getAlarmType());
        /*
         * 1.如果不存在单个企业条件，则查询所有子级企业
         * 2.企业过滤，如果存在单个企业的条件并且子级企业包含该单个企业，那就以该单个企业的名称检索
         * 3.如果存在单个企业条件，并且该企业不存在于子级企业集合，那么直接返回null，避免查询消耗
         */
        if(flg==null && companys!=null && companys.size()!=0){
            lte.and("company").in(companys);
        }else if(flg!=null && flg){
            lte.and("company").is(alarmPage.getJigouName());
        }else if(flg!=null && !flg){
            return alarmPage;
        }
        //报警时间过滤
        if(StringUtil.isNotEmpty(alarmPage.getBeginTime()) && StringUtil.isNotEmpty(alarmPage.getEndTime())){
            long bgtime = DateUtil.parse(alarmPage.getBeginTime(), "yyyy-MM-dd").getTime();
            long edtime = DateUtil.parse(alarmPage.getEndTime(), "yyyy-MM-dd").getTime()+86400000;
            lte.andOperator( Criteria.where("CutoffTime").gte(bgtime) ,Criteria.where("CutoffTime").lt(edtime));
        }

        Query q = new Query(lte);
        int total = new Long(mongoTemplate.count(q, AlarmsummaryCutofftimeMG.class)).intValue();
        alarmPage.setTotal(total);
        //如果总条数为0，直接返回，避免不必要查询
        if(total<=0){
            return alarmPage;
        }
        //排序条件
        if(StringUtil.isNotEmpty(alarmPage.getOrderColumn())){
            if(alarmPage.getOrder()!=0){
                q.with(Sort.by(Sort.Order.desc(alarmPage.getOrderColumn())));
            }else{
                q.with(Sort.by(Sort.Order.asc(alarmPage.getOrderColumn())));
            }
        }else{
            //默认车辆牌照降序
            q.with(Sort.by(Sort.Order.desc("plateNumber")));
        }
        List<AlarmsummaryCutofftimeMG> a = null;
        //如果pagesize=0则为导出，否则为分页查询
        if(alarmPage.getSize()==0) {
            if (alarmPage.getTotal() >20000) {
                throw new RuntimeException("导出总条数数不能超过20000");
            }else{
                a = mongoTemplate.find(q,AlarmsummaryCutofftimeMG.class);
                for (int i = 0; i < a.size(); i++) {
                    a.get(i).setOrderNum(i+1);
                }
            }
        }else{
            //总页数
            int pagetotal =  total / alarmPage.getSize() + 1;
            //跳过数量
            int offsetNo = 0;
            if (pagetotal >= alarmPage.getCurrent() && pagetotal > 0) {
                alarmPage.setPageTotal(pagetotal);
                if (alarmPage.getCurrent() > 1) {
                    offsetNo = alarmPage.getSize() * (alarmPage.getCurrent() - 1);
                }
                alarmPage.setOffsetNo(offsetNo);
            }
            a = mongoTemplate.find(q.skip(alarmPage.getOffsetNo()).limit(alarmPage.getSize()),AlarmsummaryCutofftimeMG.class);
            for (int i = 0; i < a.size(); i++) {
                a.get(i).setOrderNum(offsetNo+i+1);
            }
        }



        alarmPage.setRecords(a);

        return alarmPage;
    }

	@Override
	public List<AlarmsummaryCutofftime> timeAlarm(AlarmTimePage alarmTimePage) {
		return cutofftimeMapper.timeAlarm(alarmTimePage);
	}

	@Override
	public List<String> findoperattype(String deptId) {
		List<String> findoperattype = cutofftimeMapper.findoperattype(deptId);
		   findoperattype.add("全部");


		return findoperattype;
	}

	@Override
	public List<AlarmsummaryCutofftimeVO> alarmDay(String company, String AlarmType) {
		String date = DateUtil.format(new Date(), "yyyy-MM-dd");
		List<AlarmsummaryCutofftimeVO> alarmDays = cutofftimeMapper.alarmDay(company,AlarmType);
		return alarmDays;
	}


}
