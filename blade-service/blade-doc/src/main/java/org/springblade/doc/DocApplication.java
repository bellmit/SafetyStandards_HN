package org.springblade.doc;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Doc启动器
 *
 * @author Chill
 */
@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class DocApplication {

	public static void main(String[] args) {
		BladeApplication.run("blade-doc", DocApplication.class, args);
	}

}

