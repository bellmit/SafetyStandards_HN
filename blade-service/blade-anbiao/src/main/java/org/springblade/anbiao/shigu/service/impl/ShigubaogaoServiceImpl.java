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
import org.springblade.anbiao.shigu.entity.Shigubaogao;
import org.springblade.anbiao.shigu.mapper.ShigubaogaoMapper;
import org.springblade.anbiao.shigu.page.ShigubaogaoPage;
import org.springblade.anbiao.shigu.service.IShigubaogaoService;
import org.springblade.anbiao.shigu.vo.ShigubaogaoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事故报告调查处理-事故报告 服务实现类
 *
 * @author hyp
 * @since 2019-04-28
 */
@Service
@AllArgsConstructor
public class ShigubaogaoServiceImpl extends ServiceImpl<ShigubaogaoMapper, Shigubaogao> implements IShigubaogaoService {

    private ShigubaogaoMapper shigubaogaoMapper;

    @Override
    public ShigubaogaoPage<ShigubaogaoVO> selectShigubaogaoPage(ShigubaogaoPage shigubaogaoPage) {
        Integer total = shigubaogaoMapper.selectShigubaogaoTotal(shigubaogaoPage);
        Integer pagetotal = 0;
        if (total > 0) {
			if(total%shigubaogaoPage.getSize()==0){
				pagetotal = total / shigubaogaoPage.getSize();
			}else {
				pagetotal = total / shigubaogaoPage.getSize() + 1;
			}
        }
        if (pagetotal >= shigubaogaoPage.getCurrent() && pagetotal > 0) {
            shigubaogaoPage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (shigubaogaoPage.getCurrent() > 1) {
                offsetNo = shigubaogaoPage.getSize() * (shigubaogaoPage.getCurrent() - 1);
            }
            shigubaogaoPage.setTotal(total);
            shigubaogaoPage.setOffsetNo(offsetNo);
            List<ShigubaogaoVO> vehlist = shigubaogaoMapper.selectShigubaogaoPage(shigubaogaoPage);
            shigubaogaoPage.setRecords(vehlist);
        }
        return shigubaogaoPage;
    }

    @Override
    public ShigubaogaoVO selectByKey(String id) {
        return shigubaogaoMapper.selectByKey(id);
    }

    @Override
    public boolean deleleShigubaogao(String id) {
        return shigubaogaoMapper.deleteShigubaogao(id);
    }

}
