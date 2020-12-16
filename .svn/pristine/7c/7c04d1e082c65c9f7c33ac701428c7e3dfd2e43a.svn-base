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
package org.springblade.anbiao.anquanmubiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.anquanmubiao.entity.Fangzhenmubiao;
import org.springblade.anbiao.anquanmubiao.page.FangzhenmubiaoPage;
import org.springblade.anbiao.anquanmubiao.vo.FangzhenmubiaoVO;

import java.util.List;

/**
 * 安全工作方针与目标 Mapper 接口
 *
 * @author elvis.he
 * @since 2019-04-28
 */
public interface FangzhenmubiaoMapper extends BaseMapper<Fangzhenmubiao> {

    /**
     * 自定义分页
     *
     * @param fangzhenmubiaoPage
     * @return
     */
    List<FangzhenmubiaoVO> selectFangzhenmubiaoPage(FangzhenmubiaoPage fangzhenmubiaoPage);

    /**
     * 统计
     *
     * @param fangzhenmubiaoPage
     * @return
     */
    int selectFangzhenmubiaoTotal(FangzhenmubiaoPage fangzhenmubiaoPage);

    /**
     * 根据id获取数据
     * *@param id
     *
     * @return
     */
    FangzhenmubiaoVO selectByKey(String id);

    /**
     * 自定义删除
     *
     * @param id
     * @return
     */
    boolean deleteFangzhenmubiao(String id);
}
