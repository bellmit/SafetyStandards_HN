/**
 * Copyright (C), 2015-2021
 * FileName: PrintWordsJob
 * Author:   呵呵哒
 * Date:     2021/3/25 15:01
 * Description: \
 */
package org.springblade.job.anbiao;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @创建人 hyp
 * @创建时间 2021/3/25
 * @描述
 */
public class PrintWordsJob implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
		System.out.println("hyp111112222222222333333333333333333");
		System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));

	}
}
