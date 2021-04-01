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
import org.springblade.anbiao.yingjijiuyuan.entity.Yingjiyuan;
import org.springblade.anbiao.yingjijiuyuan.mapper.YingjiyuanMapper;
import org.springblade.anbiao.yingjijiuyuan.page.YingjiyuanPage;
import org.springblade.anbiao.yingjijiuyuan.service.IYingjiyuanService;
import org.springblade.anbiao.yingjijiuyuan.vo.YingjiyuanVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应急预案 服务实现类
 *
 * @author hyp
 * @since 2019-04-24
 */
@Service
@AllArgsConstructor
public class YingjiyuanServiceImpl extends ServiceImpl<YingjiyuanMapper, Yingjiyuan> implements IYingjiyuanService {

    private YingjiyuanMapper yingjiyuanMapper;

    @Override
    public YingjiyuanPage<YingjiyuanVO> selectYingjiyuanPage(YingjiyuanPage yingjiyuanPage) {
        Integer total = yingjiyuanMapper.selectYingjiyuanTotal(yingjiyuanPage);
        Integer pagetotal = 0;
        if (total > 0) {
			if(total%yingjiyuanPage.getSize()==0){
				pagetotal = total / yingjiyuanPage.getSize();
			}else {
				pagetotal = total / yingjiyuanPage.getSize() + 1;
			}
        }
        if (pagetotal >= yingjiyuanPage.getCurrent() ) {
            yingjiyuanPage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (yingjiyuanPage.getCurrent() > 1) {
                offsetNo = yingjiyuanPage.getSize() * (yingjiyuanPage.getCurrent() - 1);
            }
            yingjiyuanPage.setTotal(total);
            yingjiyuanPage.setOffsetNo(offsetNo);
            List<YingjiyuanVO> vehlist = yingjiyuanMapper.selectYingjiyuanPage(yingjiyuanPage);
            yingjiyuanPage.setRecords(vehlist);
        }
        return yingjiyuanPage;
    }


    @Override
    public YingjiyuanVO selectByKey(String id) {
        return yingjiyuanMapper.selectByKey(id);
    }

    @Override
    public boolean deleleYingjiyuan(String id) {
        return yingjiyuanMapper.deleteYingjiyuan(id);
    }

}
