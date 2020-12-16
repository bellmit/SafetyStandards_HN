/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * limitations under the License.
 */
package org.springblade.anbiao.guanlijigouherenyuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Anquanhuiyi;
import org.springblade.anbiao.guanlijigouherenyuan.mapper.AnquanhuiyiMapper;
import org.springblade.anbiao.guanlijigouherenyuan.page.AnquanhuiyiPage;
import org.springblade.anbiao.guanlijigouherenyuan.service.IAnquanhuiyiService;
import org.springblade.anbiao.guanlijigouherenyuan.vo.AnquanhuiyiVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 */
@Service
@AllArgsConstructor
public class AnquanhuiyiServiceImpl extends ServiceImpl<AnquanhuiyiMapper, Anquanhuiyi> implements IAnquanhuiyiService {

	private  AnquanhuiyiMapper AnquanhuiyiMapper;

	@Override
	public AnquanhuiyiPage<AnquanhuiyiVO> selectHuiYiPage(AnquanhuiyiPage AnquanhuiyiPage) {
		Integer total = AnquanhuiyiMapper.selectHuiYiTotal(AnquanhuiyiPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%AnquanhuiyiPage.getSize()==0){
				pagetotal = total / AnquanhuiyiPage.getSize();
			}else {
				pagetotal = total / AnquanhuiyiPage.getSize() + 1;
			}
		}
		if (pagetotal < AnquanhuiyiPage.getCurrent()) {
			return AnquanhuiyiPage;
		} else {
			AnquanhuiyiPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (AnquanhuiyiPage.getCurrent() > 1) {
				offsetNo = AnquanhuiyiPage.getSize() * (AnquanhuiyiPage.getCurrent() - 1);
			}
			AnquanhuiyiPage.setTotal(total);
			AnquanhuiyiPage.setOffsetNo(offsetNo);
			List<AnquanhuiyiVO> list = AnquanhuiyiMapper.selectHuiYiPage(AnquanhuiyiPage);
			return (AnquanhuiyiPage<AnquanhuiyiVO>) AnquanhuiyiPage.setRecords(list);
		}
	}

	@Override
	public boolean deleteHuiYi(String id) {
		return AnquanhuiyiMapper.deleteHuiYi(id);
	}

}
