package org.springblade.anbiao.cheliangguanli.controller;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.cheliangguanli.entity.VehiclesMoveInfo;
import org.springblade.anbiao.cheliangguanli.page.VehiclesMoveInfoPage;
import org.springblade.anbiao.cheliangguanli.service.IVehiclesMoveInfoService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author 呵呵哒
 * @program : SafetyStandards
 * @description: VehicleController
 */

@RestController
@RequestMapping("/anbiao/vehiclesMoveInfo")
@AllArgsConstructor
@Api(value = "车辆资料管理-车辆异动", tags = "车辆资料管理-车辆异动")
public class VehiclesMoveInfoController {

    private IVehiclesMoveInfoService iVehiclesMoveInfoService;

    @PostMapping("/list")
	@ApiLog("分页-车辆异动列表")
    @ApiOperation(value = "分页-车辆异动列表", notes = "传入vehiclesMoveInfoPage", position = 1)
    public R<VehiclesMoveInfoPage<VehiclesMoveInfo>> list(@RequestBody VehiclesMoveInfoPage vehiclesMoveInfoPage) {
		R r = new R();
    	if(StringUtils.isBlank(vehiclesMoveInfoPage.getDeptId())){
			r.setCode(500);
    		r.setMsg("deptId不能为空");
    		return r;
		}

    	VehiclesMoveInfoPage<VehiclesMoveInfo> pages = iVehiclesMoveInfoService.selectVehiclePage(vehiclesMoveInfoPage);
        if(pages != null){
        	r.setMsg("获取成功");
        	r.setCode(200);
        	r.setData(pages);
		}else{
			r.setMsg("获取失败");
			r.setCode(500);
			r.setData("");
		}
    	return r;
    }

    @PostMapping("/insert")
	@ApiLog("新增-车辆异动信息")
    @ApiOperation(value = "新增-车辆异动信息", notes = "传入vehiclesMoveInfo", position = 2)
    public R insert(@RequestBody VehiclesMoveInfo vehiclesMoveInfo,BladeUser user) {
    	R r = new R();
		String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		vehiclesMoveInfo.setUpdateTime(date);
		String uuid = UUID.randomUUID().toString().replace("-", "");
		vehiclesMoveInfo.setId(uuid);
		vehiclesMoveInfo.setUpdateUserId(user.getUserId().toString());
		vehiclesMoveInfo.setUpdateUser(user.getUserName());
		boolean i = iVehiclesMoveInfoService.insertSelective(vehiclesMoveInfo);
		if(i == true){
			r.setCode(200);
			r.setMsg("异动成功");
		}else{
			r.setCode(500);
			r.setMsg("异动失败");
		}
        return r;
    }

}
