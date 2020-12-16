package org.springblade.alarm.service;

import com.baomidou.mybatisplus.extension.service.IService;

import org.springblade.alarm.entity.Alarmvehdailyreport;
import org.springblade.alarm.page.AlarmvehPage;

import java.util.List;

/**
 * 超速报警 及处理 （日）
 */

public interface IAlarmvehdailyreportService extends IService<Alarmvehdailyreport> {



	AlarmvehPage chaosu(AlarmvehPage alarmvehPage);
	AlarmvehPage pilao(AlarmvehPage alarmvehPage);
	AlarmvehPage zhudonganquan(AlarmvehPage alarmvehPage);
}
