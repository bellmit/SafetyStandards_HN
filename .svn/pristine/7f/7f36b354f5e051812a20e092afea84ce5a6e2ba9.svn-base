package org.springblade.gps.feign;

import org.springblade.gps.entity.GpsVehicle;
import org.springblade.gps.entity.VehiclePT;
import org.springblade.gps.entity.VehiclePTCompany;
import org.springblade.gps.entity.VehicleStop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
	//定义Feign指向的service-id
	value = "blade-gps",
	//定义hystrix配置类
	fallback = GpsPointDataClientFallback.class
)
public interface IGpsPointDataClient {

	/**
	 * 接口前缀
	 */
	String API_PREFIX = "gps/gpsdata";

	/**
	 * 获取详情
	 *
	 * @param company 企业名称
	 * @return
	 */
	@GetMapping(API_PREFIX + "/getVehiclePT2")
	List<VehiclePT> getVehiclePT2(@RequestParam("company") String company);


	@GetMapping(API_PREFIX+"/getvehiclestop")
	List<VehicleStop> getvehiclestop(@RequestParam("company") String  company);
	@GetMapping(API_PREFIX+"/getgpsvehicle")
	GpsVehicle  getgpsvehicle(@RequestParam("cph") String  cph,@RequestParam("color") String color);
	@GetMapping(API_PREFIX+"/getvehicle")
	List<VehiclePTCompany>  getvehicle(@RequestParam("company") String  company);

}
