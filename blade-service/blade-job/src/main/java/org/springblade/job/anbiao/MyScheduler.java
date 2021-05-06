/**
 * Copyright (C), 2015-2021
 * FileName: MyScheduler
 * Author:   呵呵哒
 * Date:     2021/3/25 15:01
 * Description:
 */
package org.springblade.job.anbiao;

/**
 * @创建人 hyp
 * @创建时间 2021/3/25
 * @描述
 */
public class MyScheduler {

//	public static void main(String[] args) throws SchedulerException, InterruptedException {
//		// 1、创建调度器Scheduler
//		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//		Scheduler scheduler = schedulerFactory.getScheduler();
//		// 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
//		JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
//			.withIdentity("job1", "group1").build();
//		// 3、构建Trigger实例,每隔1s执行一次
//		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
//			.startNow()//立即生效
//			.withSchedule(SimpleScheduleBuilder.simpleSchedule()
//				.withIntervalInSeconds(1)//每隔1s执行一次
//				.repeatForever()).build();//一直执行
//
//		//4、执行
//		scheduler.scheduleJob(jobDetail, trigger);
//		System.out.println("--------scheduler start ! ------------");
//		scheduler.start();
//
//		//睡眠
//		TimeUnit.MINUTES.sleep(1);
//		scheduler.shutdown();
//		System.out.println("--------scheduler shutdown ! ------------");
//
//
//	}
}

