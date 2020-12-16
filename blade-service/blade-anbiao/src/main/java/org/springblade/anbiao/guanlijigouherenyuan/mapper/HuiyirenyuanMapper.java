/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * limitations under the License.
 */
package org.springblade.anbiao.guanlijigouherenyuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Huiyirenyuan;
import org.springblade.anbiao.guanlijigouherenyuan.page.HuiyirenyuanPage;
import org.springblade.anbiao.guanlijigouherenyuan.vo.HuiyirenyuanVO;

import java.util.List;

/**
 *  Mapper 接口
 */
public interface HuiyirenyuanMapper extends BaseMapper<Huiyirenyuan> {

	/**
	 * 自定义分页
	 * @param huiyirenyuanPage
	 * @return
	 */
	List<HuiyirenyuanVO> selectPageQuery(HuiyirenyuanPage huiyirenyuanPage);
	/**
	 * 统计
	 * @param huiyirenyuanPage
	 * @return
	 */
	int selectTotal(HuiyirenyuanPage  huiyirenyuanPage);

	/**
	 * 自定义删除
	 * @param id
	 * @return
	 */
	boolean deleteHuiYi(String id);

}
