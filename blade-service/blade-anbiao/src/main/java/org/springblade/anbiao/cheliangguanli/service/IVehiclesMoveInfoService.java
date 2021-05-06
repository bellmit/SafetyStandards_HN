package org.springblade.anbiao.cheliangguanli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.cheliangguanli.entity.VehiclesMoveInfo;
import org.springblade.anbiao.cheliangguanli.page.VehiclesMoveInfoPage;

import java.util.List;

/**
 * 车辆自定义 接口
 * */
public interface IVehiclesMoveInfoService extends IService<VehiclesMoveInfo> {

	/**
	 * 自定义分页
	 * @param vehiclesMoveInfoPage
	 * @return
	 */
	VehiclesMoveInfoPage<VehiclesMoveInfo> selectVehiclePage(VehiclesMoveInfoPage vehiclesMoveInfoPage);

	/**
	 * 车辆异动
	 * @return
	 */
	boolean insertSelective(VehiclesMoveInfo vehiclesMoveInfo);

}
