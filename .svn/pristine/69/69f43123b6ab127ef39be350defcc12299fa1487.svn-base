package org.springblade.deadline;
import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Desk启动器
 *
 * @author Chill
 */
@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class DeadlineApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-deadline", DeadlineApplication.class, args);
	}

}

