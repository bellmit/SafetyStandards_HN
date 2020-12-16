/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.manage.waybill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.manage.waybill.entity.Statistics;
import org.springblade.manage.waybill.page.StatisticsPage;

import java.util.List;


/**
 *  Mapper 接口
 */
public interface StatisicsMapper extends BaseMapper<Statistics> {

	/**
	 * 分页列表
	 * @param page
	 * @return
	 */
	List<Statistics> selectPageList(StatisticsPage page);

	/**
	 * 分页统计
	 * @param page
	 * @return
	 */
	int selectTotal(StatisticsPage page);
}
