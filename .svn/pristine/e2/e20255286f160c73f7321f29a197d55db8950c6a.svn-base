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
package org.springblade.anbiao.baobiaowenjian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.baobiaowenjian.entity.BaobiaoMulu;
import org.springblade.anbiao.baobiaowenjian.entity.ReportFileParse;
import org.springblade.anbiao.baobiaowenjian.mapper.BaobiaoMuluMapper;
import org.springblade.anbiao.baobiaowenjian.page.BaobiaoWenjianPage;
import org.springblade.anbiao.baobiaowenjian.service.IBaobiaoMuluService;
import org.springblade.anbiao.baobiaowenjian.vo.BaobiaoMuluVO;
import org.springblade.anbiao.falvfagui.page.FaGuiPage;
import org.springblade.anbiao.falvfagui.vo.FaGuiVo;
import org.springblade.common.configurationBean.FileServer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author elvis.he
 * @since 2019-05-16
 */
@Service
@AllArgsConstructor
public class BaobiaoMuluServiceImpl extends ServiceImpl<BaobiaoMuluMapper, BaobiaoMulu> implements IBaobiaoMuluService {

    private BaobiaoMuluMapper baobiaoMuluMapper;
	private ReportFileParse fileParse;

    @Override
    public BaobiaoWenjianPage<BaobiaoMuluVO> selectBaogaoPage(BaobiaoWenjianPage baobiaoWenjianPage) {
        Integer total = baobiaoMuluMapper.selectBaogaoTotal(baobiaoWenjianPage);
        System.out.println(total);
        Integer pagetotal = 0;
        if (total > 0) {
            pagetotal = total / baobiaoWenjianPage.getSize() + 1;
        }
		if (pagetotal < baobiaoWenjianPage.getCurrent()) {
			return null;
		} else {
			baobiaoWenjianPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (baobiaoWenjianPage.getCurrent() > 1) {
				offsetNo = baobiaoWenjianPage.getSize() * (baobiaoWenjianPage.getCurrent() - 1);
			}
			baobiaoWenjianPage.setTotal(total);
			baobiaoWenjianPage.setOffsetNo(offsetNo);
			List<BaobiaoMuluVO> baobiaowenjian = baseMapper.selectBaogaoPage(baobiaoWenjianPage);
			for (BaobiaoMuluVO vo : baobiaowenjian){
				vo.setPath(fileParse.getPath(vo.getPath()));
			}
			return (BaobiaoWenjianPage<BaobiaoMuluVO>) baobiaoWenjianPage.setRecords(baobiaowenjian);
		}
    }
}
