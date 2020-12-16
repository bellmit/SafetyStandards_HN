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
import org.springblade.alarm.entity.Notlocatedetail;
import org.springblade.alarm.mapper.NotlocatedetailMapper;
import org.springblade.alarm.page.NotlocatePage;
import org.springblade.alarm.service.INotlocatedetailService;
import org.springblade.alarm.vo.NotlocatedetailVO;
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
public class NotlocatedetailServiceImpl extends ServiceImpl<NotlocatedetailMapper, Notlocatedetail> implements INotlocatedetailService {

    private NotlocatedetailMapper notlocatedetailMapper;

    @Override
    public NotlocatePage<NotlocatedetailVO> selectAlarmPage(NotlocatePage notlocatePage) {
        Integer total = notlocatedetailMapper.selectNotlocateTotal(notlocatePage);
		if(notlocatePage.getSize()==0){
			if(notlocatePage.getTotal()==0){
				notlocatePage.setTotal(total);
			}
			List<NotlocatedetailVO> list = notlocatedetailMapper.selectNotlocatePage(notlocatePage);
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
			notlocatePage.setRecords(list);
			return  notlocatePage;
		}
        Integer pagetotal = 0;
        if (total > 0) {
            pagetotal = total / notlocatePage.getSize() + 1;
        }
        if (pagetotal >= notlocatePage.getCurrent() && pagetotal > 0) {
            notlocatePage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (notlocatePage.getCurrent() > 1) {
                offsetNo = notlocatePage.getSize() * (notlocatePage.getCurrent() - 1);
            }
            notlocatePage.setTotal(total);
            notlocatePage.setOffsetNo(offsetNo);
            List<NotlocatedetailVO> list = notlocatedetailMapper.selectNotlocatePage(notlocatePage);
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
            notlocatePage.setRecords(list);
            //添加报警统计
            AlarmBaojingTongji baojingTongji = notlocatedetailMapper.selectBaojingtongji(notlocatePage);
            notlocatePage.setBaojingTongji(baojingTongji);
        }
        return notlocatePage;
    }

}
