/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * limitations under the License.
 */
package org.springblade.anbiao.zhengfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.zhengfu.entity.XinXiJiaoHuHuiFu;

/**
 * @author 呵呵哒
 * @描述
 */
public interface XinXiJiaoHuHuiFuMapper extends BaseMapper<XinXiJiaoHuHuiFu> {

	boolean insertSelective(XinXiJiaoHuHuiFu xinXiJiaoHuHuiFu);
}
