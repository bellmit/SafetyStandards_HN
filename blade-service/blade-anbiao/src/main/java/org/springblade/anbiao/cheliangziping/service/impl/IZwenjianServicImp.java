package org.springblade.anbiao.cheliangziping.service.impl;

import lombok.AllArgsConstructor;

import org.springblade.anbiao.cheliangziping.entity.Zipingwenjian;
import org.springblade.anbiao.cheliangziping.mapper.ZipinwendangMapper;
import org.springblade.anbiao.cheliangziping.page.ZipinwenjianPage;
import org.springblade.anbiao.cheliangziping.service.IZipinwenjianServic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/316:19
 */
@Service
@AllArgsConstructor
public class IZwenjianServicImp implements IZipinwenjianServic {
	private ZipinwendangMapper zipinwendangMapper;
	@Override
	public ZipinwenjianPage selectpage(ZipinwenjianPage zipinjianchajieguoPage) {

		String deptname=zipinwendangMapper.Deptname(String.valueOf(zipinjianchajieguoPage.getDeptId()));
		Integer total = zipinwendangMapper.selectTotal(zipinjianchajieguoPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%zipinjianchajieguoPage.getSize()==0){
				pagetotal = total / zipinjianchajieguoPage.getSize();
			}else {
				pagetotal = total / zipinjianchajieguoPage.getSize() + 1;
			}
		}
		if (pagetotal < zipinjianchajieguoPage.getCurrent()) {
			return zipinjianchajieguoPage;
		} else {
			zipinjianchajieguoPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (zipinjianchajieguoPage.getCurrent() > 1) {
				offsetNo = zipinjianchajieguoPage.getSize() * (zipinjianchajieguoPage.getCurrent() - 1);
			}
			zipinjianchajieguoPage.setTotal(total);
			zipinjianchajieguoPage.setOffsetNo(offsetNo);

			List<Zipingwenjian> vehlist = zipinwendangMapper.selectPageList(zipinjianchajieguoPage);
			for(Zipingwenjian a:vehlist){
				a.setDeptName(deptname);
			}
			zipinjianchajieguoPage.setRecords(vehlist);
			return zipinjianchajieguoPage;

		}






	}

	@Override
	public int deletawendang(String id) {
		return zipinwendangMapper.deletawendang(id);
	}

	@Override
	public int insertwendang(Zipingwenjian zIpingwenjian) {
		return zipinwendangMapper.insertwendang(zIpingwenjian);
	}

	@Override
	public int deletelishi(String id) {
		return zipinwendangMapper.deletelishi(id);
	}
}
