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
package org.springblade.anbiao.shigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.shigu.entity.Shigubaogao;
import org.springblade.anbiao.shigu.page.ShigubaogaoPage;
import org.springblade.anbiao.shigu.vo.ShigubaogaoVO;

import java.util.List;

/**
 * 事故报告调查处理-事故报告 Mapper 接口
 *
 * @author elvis.he
 * @since 2019-04-28
 */
public interface ShigubaogaoMapper extends BaseMapper<Shigubaogao> {

    /**
     * 自定义分页
     *
     * @param shigubaogaoPage
     * @return
     */
    List<ShigubaogaoVO> selectShigubaogaoPage(ShigubaogaoPage shigubaogaoPage);

    /**
     * 统计
     *
     * @param shigubaogaoPage
     * @return
     */
    int selectShigubaogaoTotal(ShigubaogaoPage shigubaogaoPage);

    /**
     * 根据id获取数据
     * *@param id
     *
     * @return
     */
    ShigubaogaoVO selectByKey(String id);

    /**
     * 自定义删除
     *
     * @param id
     * @return
     */
    boolean deleteShigubaogao(String id);

}
