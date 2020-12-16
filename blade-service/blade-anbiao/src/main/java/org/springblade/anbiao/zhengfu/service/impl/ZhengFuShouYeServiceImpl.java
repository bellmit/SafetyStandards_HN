/**
 * FileName: XinXiJiaoHuZhuServiceImpl
 * Author:   呵呵哒
 */
package org.springblade.anbiao.zhengfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.zhengfu.entity.ZhengFuShouYe;
import org.springblade.anbiao.zhengfu.mapper.ZhengFuShouYeMapper;
import org.springblade.anbiao.zhengfu.service.IZhengFuShouYeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 呵呵哒
 * @描述
 */
@Service
@AllArgsConstructor
public class ZhengFuShouYeServiceImpl extends ServiceImpl<ZhengFuShouYeMapper, ZhengFuShouYe> implements IZhengFuShouYeService {

	private ZhengFuShouYeMapper zhengFuShouYeMapper;

	@Override
	public ZhengFuShouYe selectGetBaoJing(String deptId) {
		return zhengFuShouYeMapper.selectGetBaoJing(deptId);
	}

	@Override
	public List<ZhengFuShouYe> selectGetBaoJing_XiaJi(String xiaJiDeptId) {
		return zhengFuShouYeMapper.selectGetBaoJing_XiaJi(xiaJiDeptId);
	}

	@Override
	public ZhengFuShouYe selectGetJianKongQiYe(String deptId) {
		return zhengFuShouYeMapper.selectGetJianKongQiYe(deptId);
	}

	@Override
	public List<ZhengFuShouYe> selectGetJianKongQiYe_XiaJi(String xiaJiDeptId) {
		return zhengFuShouYeMapper.selectGetJianKongQiYe_XiaJi(xiaJiDeptId);
	}

	@Override
	public List<ZhengFuShouYe> selectGetVehicleStatus(String deptId,String xiaJiDeptId) {
		return zhengFuShouYeMapper.selectGetVehicleStatus(deptId,xiaJiDeptId);
	}

	@Override
	public List<ZhengFuShouYe> selectGetVehicleStatus_XiaJi(String xiaJiDeptId) {
		return zhengFuShouYeMapper.selectGetVehicleStatus_XiaJi(xiaJiDeptId);
	}

	@Override
	public List<ZhengFuShouYe> selectGetSevenBaoJing(String deptId, String shangyue, String benyue) {
		return zhengFuShouYeMapper.selectGetSevenBaoJing(deptId, shangyue, benyue);
	}

	@Override
	public List<ZhengFuShouYe> selectGetSevenBaoJing_XiaJi(String xiaJiDeptId, String shangyue, String benyue) {
		return zhengFuShouYeMapper.selectGetSevenBaoJing(xiaJiDeptId, shangyue, benyue);
	}

}
