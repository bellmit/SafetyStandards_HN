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
import org.springblade.alarm.entity.Offlinedetail;
import org.springblade.alarm.page.OfflinePage;
import org.springblade.alarm.vo.OfflinedetailVO;

import java.util.List;

/**
 * 24小时不在线 Mapper 接口
 *
 * @author hyp
 * @since 2019-05-11
 */
public interface OfflinedetailMapper extends BaseMapper<Offlinedetail> {

    /**
     * 自定义分页
     *
     * @param offlinePage
     * @return
     */
    List<OfflinedetailVO> selectOfflinePage(OfflinePage offlinePage);

    /**
     * 统计
     *
     * @param offlinePage
     * @return
     */
    int selectOfflineTotal(OfflinePage offlinePage);

    /**
     * 查询报警车辆、次数、处理率
     *
     * @param page
     * @return
     */
    AlarmBaojingTongji selectBaojingtongji(OfflinePage page);
}
