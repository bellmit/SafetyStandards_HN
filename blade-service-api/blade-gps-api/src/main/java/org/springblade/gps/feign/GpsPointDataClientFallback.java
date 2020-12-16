package org.springblade.gps.feign;

import org.springblade.gps.entity.GpsVehicle;
import org.springblade.gps.entity.VehiclePT;
import org.springblade.gps.entity.VehiclePTCompany;
import org.springblade.gps.entity.VehicleStop;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SpringBlade
 * @description: BlogClientFallback
 * @author: 呵呵哒
 **/
@Component
public class GpsPointDataClientFallback implements IGpsPointDataClient {


	@Override
	public List<VehiclePT> getVehiclePT2(String company) {

		return null;
	}

	@Override
	public List<VehicleStop> getvehiclestop(String company) {
		return null;
	}

	@Override
	public GpsVehicle getgpsvehicle(String cph, String color) {
		return null;
	}

	@Override
	public List<VehiclePTCompany> getvehicle(String company) {
		return null;
	}
}
