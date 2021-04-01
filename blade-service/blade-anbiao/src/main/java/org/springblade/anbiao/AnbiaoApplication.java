package org.springblade.anbiao;
import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Desk启动器
 *
 * @author hyp
 */
@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class AnbiaoApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-anbiao", AnbiaoApplication.class, args);
	}

}

