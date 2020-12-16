package org.springblade.anbiao.muban.feign;

import org.springblade.common.constant.CommonConstant;
import org.springblade.core.tool.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 呵呵哒
 * @description: 远程调用
 * @projectName SafetyStandards
 */
@FeignClient(value = "blade-anbiao" )
public interface IMubanClient {


		/**
		 * 接口前缀
		 */
		String API_PREFIX = "/anbiao/muban";

		/**
		 * 配置同步
		 *
		 * @return
		 */
		@PostMapping(API_PREFIX + "/initConf")
		R initConf(@RequestParam("deptId")Integer deptId,@RequestParam("tables")String [] tables);
}
