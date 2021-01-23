package org.springblade.common.configurationBean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 呵呵哒
 * @description: nacos动态获取文件路径/url前缀
 * @projectName SafetyStandards
 * @date 2019/5/2211:35
 */
@ConfigurationProperties("fileserver")
@Component
@Data
public class FileServer {

	/**
	 * 物理路径通用前缀
	 */
	private String pathPrefix;
	/**
	 * url通用前缀
	 */
	private String urlPrefix;

	/**
	 * 界定是否需要验证码
	 */
	private String falg;

	/**
	 * gps相关数据地址
	 */
	private String gpsVehiclePath;

	/**
	 * 获取logo
	 */
	private String photoLogo;

}
