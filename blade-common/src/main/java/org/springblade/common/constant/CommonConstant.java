package org.springblade.common.constant;

import org.springblade.core.launch.constant.AppConstant;

/**
 * 通用常量
 *
 * @author hyp
 */
public interface CommonConstant {

	/**
	 * demo模块名称
	 */
	String APPLICTATION_DEMO_NAME = AppConstant.APPLICATION_NAME_PREFIX+"deadline";

	/**
	 * nacos dev 地址
	 */
//	String NACOS_DEV_ADDR = "36.133.38.92:8848";
	String NACOS_DEV_ADDR = "127.0.0.1:8848";

	/**
	 * nacos prod 地址
	 */
	String NACOS_PROD_ADDR = "127.0.0.1:8848";

	/**
	 * sentinel dev 地址
	 */
	String SENTINEL_DEV_ADDR = "127.0.0.1:8848";

	/**
	 * sentinel prod 地址
	 */
	String SENTINEL_PROD_ADDR = "127.0.0.1:8858";

	/**
	 * sword 系统名
	 */
	String SWORD_NAME = "sword";

	/**
	 * saber 系统名
	 */
	String SABER_NAME = "saber";

	/**
	 * 顶级父节点id
	 */
	Integer TOP_PARENT_ID = 0;

	/**
	 * 顶级父节点名称
	 */
	String TOP_PARENT_NAME = "顶级";


	/**
	 * 默认密码
	 */
	String DEFAULT_PASSWORD = "123456";


}
