package org.springblade.alarm.feign;

import org.springblade.core.tool.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/417:29
 */
@FeignClient(
	//定义Feign指向的service-id
	value = "blade-alarm",
	fallback = IVehicleStopClient.class
)
public interface IVehicleStopClientBack {
		String API_PREFIX = "/alarm/dataCenter";

		@GetMapping(API_PREFIX+"getdatastopveh")
	    R  dataFormStopVehicle();

}
