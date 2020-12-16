package org.springblade.alarm.feign;

import org.springblade.core.tool.api.R;
import org.springframework.stereotype.Component;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/417:29
 */
@Component
public class IVehicleStopClient implements  IVehicleStopClientBack {
	@Override
	public R dataFormStopVehicle() {
		return  R.data("结算失败");
	}
}
