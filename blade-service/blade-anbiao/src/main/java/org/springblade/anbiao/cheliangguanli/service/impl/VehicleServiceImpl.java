package org.springblade.anbiao.cheliangguanli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.cheliangguanli.entity.VehicleCP;
import org.springblade.anbiao.cheliangguanli.entity.VehicleGDSTJ;
import org.springblade.anbiao.cheliangguanli.entity.VehicleToGps;
import org.springblade.anbiao.cheliangguanli.mapper.VehicleMapper;
import org.springblade.anbiao.cheliangguanli.page.VehiclePage;
import org.springblade.anbiao.cheliangguanli.service.IVehicleService;
import org.springblade.anbiao.cheliangguanli.vo.VehicleVO;
import org.springblade.anbiao.zhengfu.entity.ZhengFuBaoJingTongJiLv;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆自定义接口实现
 *
 * @author :elvis.he
 */
@Service
@AllArgsConstructor
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, Vehicle> implements IVehicleService {

    private VehicleMapper vehicleMapper;

    @Override
    public VehiclePage<VehicleVO> selectVehiclePage(VehiclePage vehiclePage) {
        Integer total = vehicleMapper.selectVehicleTotal(vehiclePage);
		if(vehiclePage.getSize()==0){
			if(vehiclePage.getTotal()==0){
				vehiclePage.setTotal(total);
			}
			List<VehicleVO> vehlist = vehicleMapper.selectVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
			return vehiclePage;
		}
        Integer pagetotal = 0;
        if (total > 0) {
        	if(total%vehiclePage.getSize()==0){
				pagetotal = total / vehiclePage.getSize();
			}else {
				pagetotal = total / vehiclePage.getSize() + 1;
			}
			List<VehicleVO> vehlist = vehicleMapper.selectVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
        }
        if (pagetotal >= vehiclePage.getCurrent()) {
            vehiclePage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (vehiclePage.getCurrent() > 1) {
                offsetNo = vehiclePage.getSize() * (vehiclePage.getCurrent() - 1);
            }
            vehiclePage.setTotal(total);
            vehiclePage.setOffsetNo(offsetNo);
            List<VehicleVO> vehlist = vehicleMapper.selectVehiclePage(vehiclePage);
            vehiclePage.setRecords(vehlist);
        }
        return vehiclePage;
    }

    @Override
    public VehicleVO selectByKey(String id) {
        return vehicleMapper.selectByKey(id);
    }

	@Override
	public VehicleVO selectByCPYS(String cheliangpaizhao, String chepaiyanse) {
		return vehicleMapper.selectByCPYS(cheliangpaizhao,chepaiyanse);
	}

	@Override
	public VehicleVO selectCPYS(String cheliangpaizhao, String chepaiyanse) {
		return vehicleMapper.selectCPYS(cheliangpaizhao, chepaiyanse);
	}

	@Override
    public boolean deleleVehicle(String id) {
        return vehicleMapper.deleteVehicle(id);
    }

	@Override
	public boolean updateVehicleOutStatus(String id) {
		return vehicleMapper.updateVehicleOutStatus(id);
	}

	@Override
	public boolean updateVehicleSignStatus(String id) {
		return vehicleMapper.updateVehicleSignStatus(id);
	}

	@Override
	public boolean updateVehicleScrapStatus(String id) {
		return vehicleMapper.updateVehicleScrapStatus(id);
	}

	@Override
	public List<VehicleCP> selectCL(String deptId, String cheliangpaizhao) {
		return vehicleMapper.selectCL(deptId,cheliangpaizhao);
	}

	@Override
	public int vehicleDayCount(Integer deptId) {
		return vehicleMapper.vehicleDayCount(deptId);
	}

	@Override
	public int xianzhiVecleCount(Integer deptId) {
		return vehicleMapper.xianzhiVehcleCount(deptId);
	}

	@Override
	public Vehicle vehileOne(String cheliangpaizhao, String chepaiyanse,Integer deptId) {
		return vehicleMapper.vehileOne(cheliangpaizhao,chepaiyanse,deptId);
	}

	@Override
	public List<VehicleVO> selectVehicleAll(String caozuoshijian) {
		return vehicleMapper.selectVehicleAll(caozuoshijian);
	}

	@Override
	public VehicleVO selectByYYS(String id) {
		return vehicleMapper.selectByYYS(id);
	}

	@Override
	public boolean updateDeptId(String deptId, String id) {
		return vehicleMapper.updateDeptId(deptId,id);
	}

	@Override
	public VehicleVO selectVehicleColor(String color) {
		return vehicleMapper.selectVehicleColor(color);
	}

	@Override
	public boolean insertSelective(Vehicle vehicle) {
		return vehicleMapper.insertSelective(vehicle);
	}

	@Override
	public VehicleVO selectByZongDuan(String id) {
		return vehicleMapper.selectByZongDuan(id);
	}

	@Override
	public VehiclePage<VehicleGDSTJ> selectGDSVehiclePage(VehiclePage vehiclePage) {
		Integer total = vehicleMapper.selectGDSVehicleTotal(vehiclePage);
		if(vehiclePage.getSize()==0){
			if(vehiclePage.getTotal()==0){
				vehiclePage.setTotal(total);
			}
			List<VehicleGDSTJ> vehlist = vehicleMapper.selectGDSVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
			return vehiclePage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%vehiclePage.getSize()==0){
				pagetotal = total / vehiclePage.getSize();
			}else {
				pagetotal = total / vehiclePage.getSize() + 1;
			}
			List<VehicleGDSTJ> vehlist = vehicleMapper.selectGDSVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
		}
		if (pagetotal >= vehiclePage.getCurrent()) {
			vehiclePage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (vehiclePage.getCurrent() > 1) {
				offsetNo = vehiclePage.getSize() * (vehiclePage.getCurrent() - 1);
			}
			vehiclePage.setTotal(total);
			vehiclePage.setOffsetNo(offsetNo);
			List<VehicleGDSTJ> vehlist = vehicleMapper.selectGDSVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
		}
		return vehiclePage;
	}

	@Override
	public VehiclePage<VehicleGDSTJ> selectGDSMXVehiclePage(VehiclePage vehiclePage) {
		Integer total = vehicleMapper.selectGDSMXVehicleTotal(vehiclePage);
		if(vehiclePage.getSize()==0){
			if(vehiclePage.getTotal()==0){
				vehiclePage.setTotal(total);
			}
			List<VehicleGDSTJ> vehlist = vehicleMapper.selectGDSMXVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
			return vehiclePage;
		}
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%vehiclePage.getSize()==0){
				pagetotal = total / vehiclePage.getSize();
			}else {
				pagetotal = total / vehiclePage.getSize() + 1;
			}
			List<VehicleGDSTJ> vehlist = vehicleMapper.selectGDSMXVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
		}
		if (pagetotal >= vehiclePage.getCurrent()) {
			vehiclePage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (vehiclePage.getCurrent() > 1) {
				offsetNo = vehiclePage.getSize() * (vehiclePage.getCurrent() - 1);
			}
			vehiclePage.setTotal(total);
			vehiclePage.setOffsetNo(offsetNo);
			List<VehicleGDSTJ> vehlist = vehicleMapper.selectGDSMXVehiclePage(vehiclePage);
			vehiclePage.setRecords(vehlist);
		}
		return vehiclePage;
	}
}
