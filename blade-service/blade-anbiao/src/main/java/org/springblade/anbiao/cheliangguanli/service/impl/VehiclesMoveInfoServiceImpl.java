package org.springblade.anbiao.cheliangguanli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangguanli.entity.VehiclesMoveInfo;
import org.springblade.anbiao.cheliangguanli.mapper.VehiclesMoveInfoMapper;
import org.springblade.anbiao.cheliangguanli.page.VehiclesMoveInfoPage;
import org.springblade.anbiao.cheliangguanli.service.IVehiclesMoveInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆自定义接口实现
 */
@Service
@AllArgsConstructor
public class VehiclesMoveInfoServiceImpl extends ServiceImpl<VehiclesMoveInfoMapper, VehiclesMoveInfo> implements IVehiclesMoveInfoService {

    private VehiclesMoveInfoMapper vehiclesMoveInfoMapper;

	@Override
	public VehiclesMoveInfoPage<VehiclesMoveInfo> selectVehiclePage(VehiclesMoveInfoPage vehiclesMoveInfoPage) {

		Integer total = vehiclesMoveInfoMapper.selectVehicleTotal(vehiclesMoveInfoPage);
		if(vehiclesMoveInfoPage.getSize()==0){
			if(vehiclesMoveInfoPage.getTotal()==0){
				vehiclesMoveInfoPage.setTotal(total);
			}
			List<VehiclesMoveInfo> vehiclesMoveInfoList = vehiclesMoveInfoMapper.selectVehiclePage(vehiclesMoveInfoPage);
			vehiclesMoveInfoPage.setRecords(vehiclesMoveInfoList);
			return vehiclesMoveInfoPage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%vehiclesMoveInfoPage.getSize()==0){
				pagetotal = total / vehiclesMoveInfoPage.getSize();
			}else {
				pagetotal = total / vehiclesMoveInfoPage.getSize() + 1;
			}
		}
		if (pagetotal >= vehiclesMoveInfoPage.getCurrent()) {
			vehiclesMoveInfoPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (vehiclesMoveInfoPage.getCurrent() > 1) {
				offsetNo = vehiclesMoveInfoPage.getSize() * (vehiclesMoveInfoPage.getCurrent() - 1);
			}
			vehiclesMoveInfoPage.setTotal(total);
			vehiclesMoveInfoPage.setOffsetNo(offsetNo);
			List<VehiclesMoveInfo> vehiclesMoveInfoList = vehiclesMoveInfoMapper.selectVehiclePage(vehiclesMoveInfoPage);
			vehiclesMoveInfoPage.setRecords(vehiclesMoveInfoList);
		}
		return vehiclesMoveInfoPage;
	}

	@Override
	public boolean insertSelective(VehiclesMoveInfo vehiclesMoveInfo) {
		return vehiclesMoveInfoMapper.insertSelective(vehiclesMoveInfo);
	}
}
