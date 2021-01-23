package org.springblade.alarm;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 报警模块服务启动器
 */
@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class AlarmApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-alarm", AlarmApplication.class, args);
	}

}

