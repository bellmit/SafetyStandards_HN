package org.springblade.job.alarm;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.alarm.feign.IVehicleStopClient;
import org.springblade.alarm.feign.IVehicleStopClientBack;
import org.springblade.core.log.logger.BladeLogger;
import org.springblade.job.doc.documentNumberCrontab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/417:09
 */
@Component
@Slf4j
@AllArgsConstructor
public class alarmstopCrontab {
//	private static final Object KEY = new Object();
//
//	private static boolean taskFlag = false;
//	@Autowired
//	private  IVehicleStopClientBack vehicleStopClient;
//	//private BladeLogger logger;
//
//	@Scheduled(cron = "0 20 10 * * ?")
//	private void configureTasks() {
//		synchronized (KEY) {
//			if (alarmstopCrontab.taskFlag) {
//				//logger.warn("定时任务-文档编号同步已经启动", DateUtil.now());
//				return;
//			}
//			alarmstopCrontab.taskFlag = true;
//		}
//		//logger.warn("定时任务-文档编号同步开始", DateUtil.now());
//
//		try {
//			System.out.println("执行结算停车 车辆");
//			vehicleStopClient.dataFormStopVehicle();
//			System.out.println("执行完成");
//		} catch (Exception e) {
//			//logger.error("定时任务-文档编号同步处理-执行出错", e.getMessage());
//		}
//		alarmstopCrontab.taskFlag = false;
//		System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
//	}
//


}
