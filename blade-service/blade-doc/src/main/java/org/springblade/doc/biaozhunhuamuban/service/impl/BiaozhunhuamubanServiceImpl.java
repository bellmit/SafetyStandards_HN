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
package org.springblade.doc.biaozhunhuamuban.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.node.ForestNodeMerger;
import org.springblade.doc.biaozhunhuamuban.entity.BiaoZhunHua;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.biaozhunhuamuban.mapper.BiaozhunhuamubanMapper;
import org.springblade.doc.biaozhunhuamuban.page.BiaozhunhuamubanPage;
import org.springblade.doc.biaozhunhuamuban.service.IBiaozhunhuamubanService;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author th
 * @since 2019-05-04
 */
@Service
@AllArgsConstructor
public class BiaozhunhuamubanServiceImpl extends ServiceImpl<BiaozhunhuamubanMapper, Biaozhunhuamuban> implements IBiaozhunhuamubanService {

	private BiaozhunhuamubanMapper Mapper;


	@Override
	public List<BiaozhunhuamubanVO> tree(Integer deptId, Integer parentId) {
		return ForestNodeMerger.merge(Mapper.tree(deptId,parentId));
	}

	@Override
	public List<BiaozhunhuamubanVO> JurgrantTree(String deptId) {
		return ForestNodeMerger.merge(Mapper.JurgrantTree(deptId));
	}

	@Override
	public List<BiaozhunhuamubanVO> JurpostTreeKeys(String postId) {
		return Mapper.JurpostTreeKeys(postId);
	}

	@Override
	public Integer selectMaxId() {
		return Mapper.selectMaxId();
	}

	@Override
	public List<Biaozhunhuamuban> getByParentId(Integer parentId) {
		return Mapper.getByParentId( parentId );
	}

	@Override
	public Integer selectMaxSorByParentId(Integer id) {
		return Mapper.selectMaxSorByParentId(id);
	}

	@Override
	public List<BiaozhunhuamubanVO> filePropertyTree(Integer deptId, String fileProperty) {
		return	ForestNodeMerger.merge(Mapper.filePropertyTree(deptId,fileProperty));
	}


	@Override
	public BiaozhunhuamubanPage<BiaozhunhuamubanVO> fileList(BiaozhunhuamubanPage biaozhunhuamubanPage) {
		Integer total = Mapper.selectTotal(biaozhunhuamubanPage);
		System.out.println(total);
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / biaozhunhuamubanPage.getSize() + 1;
		}
		if (pagetotal >= biaozhunhuamubanPage.getCurrent() && pagetotal > 0) {
			biaozhunhuamubanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (biaozhunhuamubanPage.getCurrent() > 1) {
				offsetNo = biaozhunhuamubanPage.getSize() * (biaozhunhuamubanPage.getCurrent() - 1);
			}
			biaozhunhuamubanPage.setTotal(total);
			biaozhunhuamubanPage.setOffsetNo(offsetNo);
			List<BiaozhunhuamubanVO> yingjichuzhilist = Mapper.fileList(biaozhunhuamubanPage);
			biaozhunhuamubanPage.setRecords(yingjichuzhilist);
		}
		return biaozhunhuamubanPage;
	}

	@Override
	public boolean updateFilePropertyById(Integer id, String fileProperty) {
		return Mapper.updateFilePropertyById(id,fileProperty);
	}

	@Override
	public boolean updatefileSuoshurenById(Integer id, Integer fileSuoshurenId) {
		return Mapper.updatefileSuoshurenById(id,fileSuoshurenId);
	}

	@Override
	public boolean updateDocumentNumberById(Integer id, String documentNumber) {
		return Mapper.updateDocumentNumberById(id,documentNumber);
	}

	@Override
	public boolean swapFileSort(Integer originId, Integer targetId) {
		return Mapper.swapFileSort(originId,targetId);
	}

	@Override
	public boolean updateSortById(Integer id, Integer sort) {
		return Mapper.updateSortById(id,sort);
	}

	@Override
	public boolean updateNameById(Integer id, String name) {
		return Mapper.updateNameById(id,name);
	}

	@Override
	public int updatePreviewRecordById(Integer id) {
		return Mapper.updatePreviewRecordById(id);
	}

	@Override
	public List<BiaozhunhuamubanVO> getMubanTree(Integer yunyingleixing,Integer isOnlyDir) {
		return  ForestNodeMerger.merge(Mapper.getMubanTree(yunyingleixing,isOnlyDir));
	}

    @Override
    public int getCountByDetpId(Integer id) {
        return Mapper.getCountByDetpId(id);
    }

    @Override
    public void insertBind(Integer id, String[] split) {
     	Mapper.insertBind(id,split);
    }

    @Override
    public void deleteBind(Integer id) {
		Mapper.deleteBind(id);
    }

	@Override
	public BiaozhunhuamubanPage selectGetBiaoZhunHuaList(BiaozhunhuamubanPage biaozhunhuamubanPage) {
		Integer total = Mapper.selectGetBiaoZhunHuaListTotal(biaozhunhuamubanPage);
		Integer pagetotal = 0;
		if (total > 0) {
			pagetotal = total / biaozhunhuamubanPage.getSize() + 1;
		}
		if (pagetotal >= biaozhunhuamubanPage.getCurrent() && pagetotal > 0) {
			biaozhunhuamubanPage.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (biaozhunhuamubanPage.getCurrent() > 1) {
				offsetNo = biaozhunhuamubanPage.getSize() * (biaozhunhuamubanPage.getCurrent() - 1);
			}
			biaozhunhuamubanPage.setTotal(total);
			biaozhunhuamubanPage.setOffsetNo(offsetNo);
			List<BiaoZhunHua> yingjichuzhilist = Mapper.selectGetBiaoZhunHuaList(biaozhunhuamubanPage);
			biaozhunhuamubanPage.setRecords(yingjichuzhilist);
		}
		return biaozhunhuamubanPage;
	}

	@Override
	public List<BiaoZhunHua> selectGetQYWD(Integer deptId) {
		return Mapper.selectGetQYWD(deptId);
	}

	@Override
	public List<BiaoZhunHua> selectGetQYWJ(Integer deptId) {
		return Mapper.selectGetQYWJ(deptId);
	}


}
