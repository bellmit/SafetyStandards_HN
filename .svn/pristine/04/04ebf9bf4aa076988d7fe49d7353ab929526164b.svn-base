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
package org.springblade.anbiao.cheliangziping.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangziping.entity.ZipingQuery;

import org.springblade.anbiao.cheliangziping.entity.ZipinjiachaXiangQing;
import org.springblade.anbiao.cheliangziping.entity.Zipinjiancha;
import org.springblade.anbiao.cheliangziping.entity.ZipinjianchaneirongMuban;
import org.springblade.anbiao.cheliangziping.page.ZipinjianchajieguoPage;
import org.springblade.anbiao.cheliangziping.vo.ZipinjianchaneirongMubanVO;
import org.springblade.anbiao.cheliangziping.mapper.ZipinjianchaneirongMubanMapper;
import org.springblade.anbiao.cheliangziping.service.IZipinjianchaneirongMubanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 *  服务实现类
 *
 * @author Blade
 * @since 2019-09-02
 */
@Service
@AllArgsConstructor
public class ZipinjianchaneirongMubanServiceImpl extends ServiceImpl<ZipinjianchaneirongMubanMapper, ZipinjianchaneirongMuban> implements IZipinjianchaneirongMubanService {


	private   ZipinjianchaneirongMubanMapper zipinjianchaneirongMubanMapper;

	@Override
	public List<ZipinjianchaneirongMubanVO> selecttable(String type) {



		return zipinjianchaneirongMubanMapper.selecttable(type);
	}

	@Override
	public Zipinjiancha selectzipingjianchajieguo(Integer deptid,String zijianzhouqi) {
		return zipinjianchaneirongMubanMapper.selectzijianjieguomuban(deptid,zijianzhouqi);
	}

	@Override
	public Integer insretzipingmuban(Zipinjiancha zipingjianchajieguoMuban) {
		return zipinjianchaneirongMubanMapper.inertjianchajieguomuban(zipingjianchajieguoMuban);
	}

	@Override
	public Integer updatewanjie(String id,String  date) {


		return zipinjianchaneirongMubanMapper.updatewanjie(id,date);
	}

	@Override
	public List<ZipinjianchaneirongMubanVO> selectjieguotable(ZipingQuery zipingQuery) {
		return zipinjianchaneirongMubanMapper.selectjieguotable(zipingQuery);
	}

	@Override
	public Integer delete(String id) {
		return zipinjianchaneirongMubanMapper.delete(id);
	}

	@Override
	public ZipinjianchajieguoPage selectpage(ZipinjianchajieguoPage zipinjianchajieguoPage) {
		Integer total = zipinjianchaneirongMubanMapper.selectTotal(zipinjianchajieguoPage);
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
			List<Zipinjiancha> vehlist = zipinjianchaneirongMubanMapper.selectPageList(zipinjianchajieguoPage);
			for(Zipinjiancha a:vehlist){
				if(a.getIsWanjie()==0){
					a.setIsWanjieshow("否");
				}else if(a.getIsWanjie()==1){
					a.setIsWanjieshow("是");
				}
			}
			zipinjianchajieguoPage.setRecords(vehlist);
			return zipinjianchajieguoPage;

		}



	}

	@Override
	public Zipinjiancha selectByid(String id) {

		//根据id查询zipinjiacha表
		Zipinjiancha zipingjianchajieguoMuban = zipinjianchaneirongMubanMapper.selectByid(id);

		ZipingQuery zipingQuery=new ZipingQuery();
		//设置zipinjiacha表id
		zipingQuery.setId(zipingjianchajieguoMuban.getId());
		//设置营运类型
		zipingQuery.setYunyingleixing(zipingjianchajieguoMuban.getYunyingleixing());
		//查询表对应检查结果
		List<ZipinjianchaneirongMubanVO> selectjieguotable = zipinjianchaneirongMubanMapper.selectjieguotable(zipingQuery);

		//返回检查表结果
		ZipinjiachaXiangQing jieguo=new ZipinjiachaXiangQing();
		//设置总检查项
		jieguo.setSum(String.valueOf(selectjieguotable.size()));
		jieguo.setXianchangjiancha(String.valueOf(zipinjianchaneirongMubanMapper.CountXianChangjiancha(zipingjianchajieguoMuban.getYunyingleixing())));
		int  ishege=0;
		for (ZipinjianchaneirongMubanVO a:selectjieguotable){
			if (a.getIsHege()==1){
				ishege++;
			}
		}
		//设置已检查项数量
		jieguo.setWanshan(String.valueOf(ishege));
		//设置未检查项
		jieguo.setWeiwanshan(String.valueOf(selectjieguotable.size()-ishege));
		//设置计算精度
		DecimalFormat df = new DecimalFormat("#0.00"); //保留小数点后两位
		Double issum=Double.valueOf(jieguo.getSum());
		Double  ishegejiancha=Double.valueOf(jieguo.getWanshan());
		//设置完善率
		jieguo.setWanshanlv(df.format(ishegejiancha/issum*100)+"%");

		zipingjianchajieguoMuban.setZipinjiachaXiangQing(jieguo);
		zipingjianchajieguoMuban.setList(selectjieguotable);

		return zipingjianchajieguoMuban;
	}

	@Override
	public int CountXianChangjiancha(String yunyingleixing) {
		return zipinjianchaneirongMubanMapper.CountXianChangjiancha(yunyingleixing);
	}

	@Override
	public Integer updateChlilv(String id, String chulilv) {
		return zipinjianchaneirongMubanMapper.updateChlilv(id, chulilv);
	}


}
