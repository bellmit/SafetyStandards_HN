package org.springblade.job.doc;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.log.logger.BladeLogger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author th
 * @description: 呵呵好啊吧
 * @projectName SafetyStandards
 * @date 2019/6/2117:59
 */
@Component
@Slf4j
@AllArgsConstructor
public class documentNumberCrontab {

	private static final Object KEY = new Object();

	private static boolean taskFlag = false;

	private  BladeLogger logger;

	@Scheduled(cron = "0 31 17 * * ?")
	private void configureTasks() {
		synchronized (KEY) {
			if (documentNumberCrontab.taskFlag) {
				//logger.warn("定时任务-文档编号同步已经启动", DateUtil.now());
				return;
			}
			documentNumberCrontab.taskFlag = true;
		}
		//logger.warn("定时任务-文档编号同步开始", DateUtil.now());

		try {
			System.out.println("to do");
		} catch (Exception e) {
			logger.error("定时任务-文档编号同步处理-执行出错", e.getMessage());
		}
		documentNumberCrontab.taskFlag = false;
		System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	}
}
