/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.anbiao.guanlijigouherenyuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Huiyirenyuan;
import org.springblade.anbiao.guanlijigouherenyuan.mapper.HuiyirenyuanMapper;
import org.springblade.anbiao.guanlijigouherenyuan.page.HuiyirenyuanPage;
import org.springblade.anbiao.guanlijigouherenyuan.service.IHuiyirenyuanService;
import org.springblade.anbiao.guanlijigouherenyuan.vo.HuiyirenyuanVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 */
@Service
@AllArgsConstructor
public class HuiyirenyuanServiceImpl extends ServiceImpl<HuiyirenyuanMapper, Huiyirenyuan> implements IHuiyirenyuanService {


	private HuiyirenyuanMapper HuiyirenyuanMapper;

	@Override
	public HuiyirenyuanPage<HuiyirenyuanVO>  selectPageQuery(HuiyirenyuanPage HuiyirenyuanPage) {
		Integer total = HuiyirenyuanMapper.selectTotal(HuiyirenyuanPage);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%HuiyirenyuanPage.getSize()==0){
				pagetotal = total / HuiyirenyuanPage.getSize();
			}else {
				pagetotal = total / HuiyirenyuanPage.getSize() + 1;
			}
		}
		if (pagetotal < HuiyirenyuanPage.getCurrent()) {
			return HuiyirenyuanPage;
		} else {
			HuiyirenyuanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (HuiyirenyuanPage.getCurrent() > 1) {
				offsetNo = HuiyirenyuanPage.getSize() * (HuiyirenyuanPage.getCurrent() - 1);
			}
			HuiyirenyuanPage.setTotal(total);
			HuiyirenyuanPage.setOffsetNo(offsetNo);
			List<HuiyirenyuanVO> list = HuiyirenyuanMapper.selectPageQuery(HuiyirenyuanPage);
			return (HuiyirenyuanPage<HuiyirenyuanVO>) HuiyirenyuanPage.setRecords(list);
		}
	}
	@Override
	public boolean deleteHuiYi(String id) {
		return false;
	}
}
