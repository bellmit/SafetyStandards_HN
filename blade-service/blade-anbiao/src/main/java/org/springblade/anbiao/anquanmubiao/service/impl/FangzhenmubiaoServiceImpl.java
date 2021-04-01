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
package org.springblade.anbiao.anquanmubiao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.anquanmubiao.entity.Fangzhenmubiao;
import org.springblade.anbiao.anquanmubiao.mapper.FangzhenmubiaoMapper;
import org.springblade.anbiao.anquanmubiao.page.FangzhenmubiaoPage;
import org.springblade.anbiao.anquanmubiao.service.IFangzhenmubiaoService;
import org.springblade.anbiao.anquanmubiao.vo.FangzhenmubiaoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 安全工作方针与目标 服务实现类
 * @author hyp
 * @since 2019-04-28
 */
@Service
@AllArgsConstructor
public class FangzhenmubiaoServiceImpl extends ServiceImpl<FangzhenmubiaoMapper, Fangzhenmubiao> implements IFangzhenmubiaoService {

    private FangzhenmubiaoMapper fangzhenmubiaoMapper;

    @Override
    public FangzhenmubiaoPage<FangzhenmubiaoVO> selectFangzhenmubiaoPage(FangzhenmubiaoPage fangzhenmubiaoPage) {
        Integer total = fangzhenmubiaoMapper.selectFangzhenmubiaoTotal(fangzhenmubiaoPage);
        Integer pagetotal = 0;
        if (total > 0) {
			if(total%fangzhenmubiaoPage.getSize()==0){
				pagetotal = total / fangzhenmubiaoPage.getSize();
			}else {
				pagetotal = total / fangzhenmubiaoPage.getSize() + 1;
			}
        }
        if (pagetotal >= fangzhenmubiaoPage.getCurrent() ) {
            fangzhenmubiaoPage.setPageTotal(pagetotal);
            Integer offsetNo = 0;
            if (fangzhenmubiaoPage.getCurrent() > 1) {
                offsetNo = fangzhenmubiaoPage.getSize() * (fangzhenmubiaoPage.getCurrent() - 1);
            }
            fangzhenmubiaoPage.setTotal(total);
            fangzhenmubiaoPage.setOffsetNo(offsetNo);
            List<FangzhenmubiaoVO> vehlist = fangzhenmubiaoMapper.selectFangzhenmubiaoPage(fangzhenmubiaoPage);
            fangzhenmubiaoPage.setRecords(vehlist);
        }
        return fangzhenmubiaoPage;
    }

    @Override
    public FangzhenmubiaoVO selectByKey(String id) {
        return fangzhenmubiaoMapper.selectByKey(id);
    }

    @Override
    public boolean deleleFangzhenmubiao(String id) {
        return fangzhenmubiaoMapper.deleteFangzhenmubiao(id);
    }

}
