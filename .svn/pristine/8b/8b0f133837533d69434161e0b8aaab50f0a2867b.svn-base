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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.alarm.entity.AlarmBaojingTongji;
import org.springblade.alarm.entity.Offlinedetail;
import org.springblade.alarm.mapper.OfflinedetailMapper;
import org.springblade.alarm.page.OfflinePage;
import org.springblade.alarm.service.IOfflinedetailService;
import org.springblade.alarm.vo.OfflinedetailVO;
import org.springblade.common.enumconstant.EnmuAlarm;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author elvis.he
 * @since 2019-05-11
 */
@Service
@AllArgsConstructor
public class OfflinedetailServiceImpl extends ServiceImpl<OfflinedetailMapper, Offlinedetail> implements IOfflinedetailService {

    private OfflinedetailMapper offlinedetailMapper;

    @Override
    public OfflinePage<OfflinedetailVO> selectAlarmPage(OfflinePage offlinePage) {
        Integer total = offlinedetailMapper.selectOfflineTotal(offlinePage);
		if(offlinePage.getSize()==0){
			if(offlinePage.getTotal()==0){
				offlinePage.setTotal(total);
			}
			List<OfflinedetailVO> list = offlinedetailMapper.selectOfflinePage(offlinePage);
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
				}else{
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
			});
			offlinePage.setRecords(list);
			return  offlinePage;

		}
        Integer pagetotal = 0;
        if (total > 0) {
            pagetotal = total / offlinePage.getSize() + 1;
        }
        if (pagetotal >= offlinePage.getCurrent() && pagetotal > 0) {
            offlinePage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (offlinePage.getCurrent() > 1) {
                offsetNo = offlinePage.getSize() * (offlinePage.getCurrent() - 1);
            }
            offlinePage.setTotal(total);
            offlinePage.setOffsetNo(offsetNo);
            List<OfflinedetailVO> list = offlinedetailMapper.selectOfflinePage(offlinePage);
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
				}else{
					EnmuAlarm.ShensuJieguo byValue = EnmuAlarm.ShensuJieguo.getByValue(Integer.valueOf(item.getChulizhuangtai()));
					item.setShensuzhuangtai(byValue.desc);
					item.setChulizhuangtai("未处理");
					item.setShensumiaoshu(item.getChulimiaoshu());
					item.setShensuxingshi(item.getChulixingshi());
					item.setChulimiaoshu("");
					item.setChulixingshi("");
				}
			});
            offlinePage.setRecords(list);
            //添加报警统计
            AlarmBaojingTongji baojingTongji = offlinedetailMapper.selectBaojingtongji(offlinePage);
            offlinePage.setBaojingTongji(baojingTongji);
        }
        return offlinePage;
    }

}
