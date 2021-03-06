package org.springblade.anbiao.cheliangguanli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.cheliangguanli.entity.VehicleCP;
import org.springblade.anbiao.cheliangguanli.entity.VehicleGDSTJ;
import org.springblade.anbiao.cheliangguanli.entity.VehicleToGps;
import org.springblade.anbiao.cheliangguanli.page.VehiclePage;
import org.springblade.anbiao.cheliangguanli.vo.VehicleVO;

import java.util.List;
import java.util.Map;

/**
 * 车辆自定义 接口
 * @author :hyp
 * */
public interface IVehicleService extends IService<Vehicle> {

    /**
     * 自定义 分页
     * @param vehiclePage
     * @return
     */
    VehiclePage<VehicleVO> selectVehiclePage(VehiclePage vehiclePage);
    /**
     * 根据id获取数据
     * *@param id
     * @return
     */
    VehicleVO  selectByKey(String id);
    /**
    * @Description: 根据车辆牌照和车牌颜色获取数据
    * @Param: [cheliangpaizhao, chepaiyanse]
    * @return: org.springblade.anbiao.cheliangguanli.vo.VehicleVO
    */
	VehicleVO selectByCPYS(String cheliangpaizhao,String chepaiyanse);
	VehicleVO selectCPYS(String cheliangpaizhao,String chepaiyanse);

    /**
     * 自定义 假删除
     * @param  id
     * @author :hyp
     * */
    boolean deleleVehicle(String id);

	/**
	 * 自定义停用
	 *
	 * @param id
	 * @return
	 */
	boolean updateVehicleOutStatus(String id);

	/**
	 * 自定义启用
	 * @param id
	 * @return
	 */
	boolean updateVehicleSignStatus(String id);

	/**
	 * 自定义报废
	 *
	 * @param id
	 * @return
	 */
	boolean updateVehicleScrapStatus(String id);

	/**
	 * 车牌搜索
	 * @param deptId
	 * @param cheliangpaizhao
	 * @return
	 */
	List<VehicleCP> selectCL(String deptId, String cheliangpaizhao);
	/**
	 * 车辆运行状况 统计企业车辆总数 停运车辆
	 */
	/**
	 * 车辆统计 车牌
	 */
	int  vehicleDayCount(Integer deptId);
	/**
	 * 闲置车辆统计 车牌
	 */
	int xianzhiVecleCount(Integer deptId);
	/**
	 * 根据车牌 车牌颜色查询详情
	 */
	Vehicle  vehileOne( String cheliangpaizhao,String chepaiyanse,Integer deptId);

	/**
	 * 车辆资料增量接口
	 * @param caozuoshijian
	 * @return
	 */
	List<VehicleVO> selectVehicleAll(String caozuoshijian);

	/**
	 * 根据车辆id查询相关运营商信息
	 * @param id
	 * @return
	 */
	Vehicle selectByYYS(@Param("id") String id);

	/**
	 * 车辆异动
	 * @param deptId
	 * @param id
	 * @return
	 */
	boolean updateDeptId(@Param("deptId") String deptId,@Param("id") String id);

	/**
	 * 验证车辆颜色是否存在
	 * @param color
	 * @return
	 */
	VehicleVO selectVehicleColor(@Param("color") String color);

	/**
	 * 导入车辆
	 * @param vehicle
	 * @return
	 */
	boolean insertSelective(Vehicle vehicle);

	/**
	 * 根据企业ID、车辆牌照、车牌颜色修改相应车辆信息
	 * @param vehicle
	 * @return
	 */
	boolean updateSelective(Vehicle vehicle);

	/**
	 * 验证车辆终端id是否存在
	 * @param id
	 * @return
	 */
	VehicleVO selectByZongDuan(@Param("id") String id);

	/**
	 * 各地市车辆变更统计
	 * @param vehiclePage
	 * @return
	 */
	VehiclePage<VehicleGDSTJ> selectGDSVehiclePage(VehiclePage vehiclePage);

	/**
	 * 各地市车辆变更明细统计
	 * @param vehiclePage
	 * @return
	 */
	VehiclePage<VehicleGDSTJ> selectGDSMXVehiclePage(VehiclePage vehiclePage);

	/**
	 * 根据企业ID获取当前企业所有车辆信息
	 * @param deptId
	 * @return
	 */
	List<Vehicle> vehileList(@Param("deptId") Integer deptId);

	/**
	 * 根据车辆ID修正车辆终端ID
	 * @param zongduanid
	 * @param caozuoren
	 * @param caozuorenid
	 * @param id
	 * @return
	 */
	boolean updateVehicleZongDuanId(@Param("zongduanid") String zongduanid,
									@Param("caozuoren") String caozuoren,
									@Param("caozuorenid") String caozuorenid,
									@Param("id") String id);

}
