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
package org.springblade.anbiao.shigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.shigu.entity.Shiguchuli;
import org.springblade.anbiao.shigu.mapper.ShiguchuliMapper;
import org.springblade.anbiao.shigu.page.ShiguchuliPage;
import org.springblade.anbiao.shigu.service.IShiguchuliService;
import org.springblade.anbiao.shigu.vo.ShiguchuliVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事故报告调查处理-事故处理 服务实现类
 *
 * @author hyp
 * @since 2019-04-29
 */
@Service
@AllArgsConstructor
public class ShiguchuliServiceImpl extends ServiceImpl<ShiguchuliMapper, Shiguchuli> implements IShiguchuliService {

    private ShiguchuliMapper shiguchuliMapper;

    @Override
    public ShiguchuliPage<ShiguchuliVO> selectShiguchuliPage(ShiguchuliPage shiguchuliPage) {
        Integer total = shiguchuliMapper.selectShiguchuliTotal(shiguchuliPage);
        Integer pagetotal = 0;
        if (total > 0) {
            pagetotal = total / shiguchuliPage.getSize() + 1;
        }
        if (pagetotal >= shiguchuliPage.getCurrent() && pagetotal > 0) {
            return null;
        } else {
            shiguchuliPage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (shiguchuliPage.getCurrent() > 1) {
                offsetNo = shiguchuliPage.getSize() * (shiguchuliPage.getCurrent() - 1);
            }
            shiguchuliPage.setTotal(total);
            shiguchuliPage.setOffsetNo(offsetNo);
            List<ShiguchuliVO> vehlist = shiguchuliMapper.selectShiguchuliPage(shiguchuliPage);
            return (ShiguchuliPage<ShiguchuliVO>) shiguchuliPage.setRecords(vehlist);
        }
    }

    @Override
    public ShiguchuliVO selectByKey(String id) {
        return shiguchuliMapper.selectByKey(id);
    }

    @Override
    public boolean deleleShiguchuli(String id) {
        return shiguchuliMapper.deleteShiguchuli(id);
    }

}
