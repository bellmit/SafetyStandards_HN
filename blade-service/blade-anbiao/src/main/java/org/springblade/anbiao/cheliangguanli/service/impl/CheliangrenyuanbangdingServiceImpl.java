/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * limitations under the License.
 */
package org.springblade.anbiao.cheliangguanli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.cheliangguanli.entity.Cheliangrenyuanbangding;
import org.springblade.anbiao.cheliangguanli.mapper.CheliangrenyuanbangdingMapper;
import org.springblade.anbiao.cheliangguanli.page.CheliangrenyuanbangdingPage;
import org.springblade.anbiao.cheliangguanli.service.ICheliangrenyuanbangdingService;
import org.springblade.anbiao.cheliangguanli.vo.CheliangrenyuanbangdingVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 *  服务实现类
 */
@Service
@AllArgsConstructor
public class CheliangrenyuanbangdingServiceImpl extends ServiceImpl<CheliangrenyuanbangdingMapper, Cheliangrenyuanbangding> implements ICheliangrenyuanbangdingService {

	private CheliangrenyuanbangdingMapper mapper;

	@Override
	public IPage<CheliangrenyuanbangdingVO> selectCheliangrenyuanbangdingPage(IPage<CheliangrenyuanbangdingVO> page, CheliangrenyuanbangdingVO cheliangrenyuanbangding) {
		return page.setRecords(baseMapper.selectCheliangrenyuanbangdingPage(page, cheliangrenyuanbangding));
	}

	@Override
	public boolean updateDel(String id) {
		return mapper.updateDel(id);
	}

	@Override
	public CheliangrenyuanbangdingPage<CheliangrenyuanbangdingVO> selectPageList(CheliangrenyuanbangdingPage Page) {
		Integer total = mapper.selectTotal(Page);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%Page.getSize()==0){
				pagetotal = total / Page.getSize();
			}else {
				pagetotal = total / Page.getSize() + 1;
			}
		}
		if (pagetotal < Page.getCurrent()) {
			return Page;
		} else {
			Page.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (Page.getCurrent() > 1) {
				offsetNo = Page.getSize() * (Page.getCurrent() - 1);
			}
			Page.setTotal(total);
			Page.setOffsetNo(offsetNo);
			List<CheliangrenyuanbangdingVO> vehlist = mapper.selectPageList(Page);
			return (CheliangrenyuanbangdingPage<CheliangrenyuanbangdingVO>) Page.setRecords(vehlist);
		}
	}

	@Override
	public CheliangrenyuanbangdingVO selectByIds(String id) {
		return mapper.selectByIds(id);
	}

}
