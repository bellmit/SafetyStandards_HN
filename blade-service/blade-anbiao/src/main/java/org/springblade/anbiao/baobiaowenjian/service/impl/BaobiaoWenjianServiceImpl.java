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
import org.springblade.anbiao.baobiaowenjian.entity.BaobiaoWenjian;
import org.springblade.anbiao.baobiaowenjian.entity.ReportFileParse;
import org.springblade.anbiao.baobiaowenjian.mapper.BaobiaoWenjianMapper;
import org.springblade.anbiao.baobiaowenjian.service.IBaobiaoWenjianService;
import org.springblade.anbiao.baobiaowenjian.vo.BaobiaoWenjianVO;
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
public class BaobiaoWenjianServiceImpl extends ServiceImpl<BaobiaoWenjianMapper, BaobiaoWenjian> implements IBaobiaoWenjianService {

    private BaobiaoWenjianMapper baobiaoWenjianMapper;
    private ReportFileParse fileParse;

    @Override
    public List<BaobiaoWenjianVO> fujianList(Integer id) {
        List<BaobiaoWenjianVO> list = baobiaoWenjianMapper.fujianList(id);
        for (BaobiaoWenjianVO vo : list) {
            vo.setPath(fileParse.getPath(vo.getPath()));
        }
        return list;
    }

    @Override
    public BaobiaoWenjianVO selectPicPath(Integer muluid, Integer fileType) {
        return baobiaoWenjianMapper.selectPicPath(muluid, fileType);
    }

    @Override
    public int updatePreviewRecordById(Integer id) {
        return baobiaoWenjianMapper.updatePreviewRecordById(id);
    }

}
