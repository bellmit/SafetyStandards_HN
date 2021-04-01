/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.anbiao.ts.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.baobiaowenjian.entity.BaobiaoMulu;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.cheliangguanli.vo.*;
import org.springblade.anbiao.jiashiyuan.vo.JiaShiYuanVO;
import org.springblade.anbiao.jiashiyuan.vo.ZhengjianshenyanVO;
import org.springblade.anbiao.ts.mapper.TsMapper;
import org.springblade.anbiao.ts.service.TsService;
import org.springblade.system.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author hyp
 * @since 2019-05-16
 */
@Service
@AllArgsConstructor
public class TsServiceImpl  implements TsService {

    private TsMapper tsMapper;

	@Override
	public void insertDept(Dept all) {
		tsMapper.insertDpet(all);
	}

	@Override
	public void isnertOrg(Dept all) {
		tsMapper.isnertOrg(all);
	}


	@Override
	public void insertVehicle(Vehicle all) {
		tsMapper.insertVehicle(all);
	}

	@Override
	public Integer getDeptIdByDeptName(String deptName) {
		return tsMapper.getDeptIdByDeptName(deptName);
	}

	@Override
	public void insertCheliangbaoxian(CheliangbaoxianVO all) {
		tsMapper.insertCheliangbaoxian(all);
	}

	@Override
	public void insertBaoxianmingxi(BaoxianxinxiVO all) {
		tsMapper.insertBaoxianmingxi(all);
	}

	@Override
	public void insertChelianganquan(ChelianganquanshebeiVO all) {
		tsMapper.insertChelianganquan(all);
	}

	@Override
	public void insertCheliangdengjipingding(CheliangdengjipingdingVO all) {
		tsMapper.insertCheliangdengjipingding(all);
	}

	@Override
	public void insertCheliangguanchejiancha(CheliangguanchejianchaVO all) {
		tsMapper.insertCheliangguanchejiancha(all);
	}

	@Override
	public void insertJiashiyuan(JiaShiYuanVO all) {
		tsMapper.insertJiashiyuan(all);
	}

	@Override
	public void insertCheliangweihu(CheliangweihuVO all) {
		tsMapper.insertCheliangweihu(all);
	}

	@Override
	public void insertCheliangyuejian(CheliangyuejianVO all) {
		tsMapper.insertCheliangyuejian(all);
	}

	@Override
	public void insertCheliangjingying(CheliangjingyingVO all) {
		tsMapper.insertCheliangjingying(all);
	}

	@Override
	public void insertCheliangrenyuan(CheliangrenyuanbangdingVO all) {
		tsMapper.insertCheliangrenyuan(all);
	}

	@Override
	public void insertCheliangbaofei(CheliangbaofeiVO all) {
		tsMapper.insertCheliangbaofei(all);
	}

	@Override
	public void insertguanchejianchamingxi(GuanchejianchaxinxiVO all) {
		tsMapper.insertguanchejianchamingxi(all);
	}

	@Override
	public void insertcheliangnianshen(CheliangnianshenVO all) {
		tsMapper.insertcheliangnianshen(all);
	}

	@Override
	public void insertZhengjianshenyan(ZhengjianshenyanVO all) {
		tsMapper.insertZhengjianshenyan(all);
	}
}
