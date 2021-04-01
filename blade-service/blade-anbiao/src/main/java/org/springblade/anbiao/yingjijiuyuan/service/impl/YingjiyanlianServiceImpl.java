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
package org.springblade.anbiao.yingjijiuyuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.yingjijiuyuan.entity.Yingjiyanlian;
import org.springblade.anbiao.yingjijiuyuan.mapper.YingjiyanlianMapper;
import org.springblade.anbiao.yingjijiuyuan.page.YingjiyanlianPage;
import org.springblade.anbiao.yingjijiuyuan.service.IYingjiyanlianService;
import org.springblade.anbiao.yingjijiuyuan.vo.YingjiyanlianVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应急演练 服务实现类
 *
 * @author hyp
 * @since 2019-04-28
 */
@Service
@AllArgsConstructor
public class YingjiyanlianServiceImpl extends ServiceImpl<YingjiyanlianMapper, Yingjiyanlian> implements IYingjiyanlianService {

    private YingjiyanlianMapper yingjiyanlianMapper;

    @Override
    public YingjiyanlianPage<YingjiyanlianVO> selectYingjiyanlianPage(YingjiyanlianPage yingjiyanlianPage) {
        Integer total = yingjiyanlianMapper.selectYingjiyanlianTotal(yingjiyanlianPage);
        Integer pagetotal = 0;
        if (total > 0) {
			if(total%yingjiyanlianPage.getSize()==0){
				pagetotal = total / yingjiyanlianPage.getSize();
			}else {
				pagetotal = total / yingjiyanlianPage.getSize() + 1;
			}
        }
        if (pagetotal >= yingjiyanlianPage.getCurrent() ) {
            yingjiyanlianPage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (yingjiyanlianPage.getCurrent() > 1) {
                offsetNo = yingjiyanlianPage.getSize() * (yingjiyanlianPage.getCurrent() - 1);
            }
            yingjiyanlianPage.setTotal(total);
            yingjiyanlianPage.setOffsetNo(offsetNo);
            List<YingjiyanlianVO> vehlist = yingjiyanlianMapper.selectYingjiyanlianPage(yingjiyanlianPage);
            yingjiyanlianPage.setRecords(vehlist);
        }
        return yingjiyanlianPage;
    }


    @Override
    public YingjiyanlianVO selectByKey(String id) {
        return yingjiyanlianMapper.selectByKey(id);
    }

    @Override
    public boolean deleleYingjiyanlian(String id) {
        return yingjiyanlianMapper.deleteYingjiyanlian(id);
    }

}
