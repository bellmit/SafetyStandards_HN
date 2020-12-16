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
package org.springblade.alarm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.alarm.entity.AlarmBaojingTongji;
import org.springblade.alarm.entity.Notlocatedetail;
import org.springblade.alarm.page.NotlocatePage;
import org.springblade.alarm.vo.NotlocatedetailVO;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author elvis.he
 * @since 2019-05-11
 */
public interface NotlocatedetailMapper extends BaseMapper<Notlocatedetail> {

    /**
     * 自定义分页
     *
     * @param notlocatePage
     * @return
     */
    List<NotlocatedetailVO> selectNotlocatePage(NotlocatePage notlocatePage);

    /**
     * 统计
     *
     * @param notlocatePage
     * @return
     */
    int selectNotlocateTotal(NotlocatePage notlocatePage);

    /**
     * 查询报警车辆、次数、处理率
     *
     * @param page
     * @return
     */
    AlarmBaojingTongji selectBaojingtongji(NotlocatePage page);
	/**
	 * 根据id查询详情
	 */
	NotlocatedetailVO selectAlarmDetail(String id);
}
