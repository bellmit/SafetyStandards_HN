package org.springblade.alarm.feign;

import lombok.AllArgsConstructor;
import org.springblade.alarm.service.IStopvehicleService;
import org.springblade.core.tool.api.R;
import org.springblade.gps.entity.VehicleStop;
import org.springblade.gps.feign.IGpsPointDataClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/417:36
 */

@RestController
@AllArgsConstructor
public class VehicleStopClient implements  IVehicleStopClientBack{
	private IGpsPointDataClient gpsPointDataClient;
	private IStopvehicleService stopvehicleService;


	@Override
	@GetMapping(API_PREFIX+"getdatastopveh")
	public R dataFormStopVehicle() {
		Long  a=System.currentTimeMillis();
		List<String> list = stopvehicleService.deptAll();
		String string="";

		for (int i = 0; i <list.size() ; i++) {
			List<VehicleStop> getvehiclestop = gpsPointDataClient.getvehiclestop(list.get(i));
			if(getvehiclestop==null || getvehiclestop.size()==0){
				continue;
			}
			stopvehicleService.insertStopvehicle(getvehiclestop);
			string=list.get(i);
			System.out.println(list.get(i));
		}


		Long  b=System.currentTimeMillis();
		return  R.data("用时"+(b-a)/1000+"秒");

	}
}
