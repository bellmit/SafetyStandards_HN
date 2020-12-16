package org.springblade.common.configurationBean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author elvis
 * @description: nacos动态获取点位数据、视频图片前缀
 * @projectName SafetyStandards
 * @date 2020/4/26 11:35
 */
@ConfigurationProperties("gpsserver")
@Component
@Data
public class GPSServer {

	/**
	 * 点位接口地址
	 */
	private String pointurlPrefix;
	/**
	 * 视频图片接口地址
	 */
	private String imgurlPrefix;

	private String spreadurlPrefix;

}
