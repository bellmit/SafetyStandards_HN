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
package org.springblade.doc.qiyewenjian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.doc.qiyewenjian.entity.Qiyewenjian;
import org.springblade.doc.qiyewenjian.vo.QiyewenjianVO;

import java.util.List;

/**
 *  服务类
 *
 * @since 2019-05-28
 */
public interface IQiyewenjianService extends IService<Qiyewenjian> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param qiyewenjian
	 * @return
	 */
	IPage<QiyewenjianVO> selectQiyewenjianPage(IPage<QiyewenjianVO> page, QiyewenjianVO qiyewenjian);

	/**
	 *查询企业文件最大id
	 */
	Integer selectMaxId();

	/**
	 *查询同级文件最大排序号
	 */
	Integer selectMaxSorByParentId(Integer id);

	/**
	 *企业文件树形结构
	 * @author: hyp
	 * @CreateDate2021-05-29 23:16
	 * @param deptId
	 * @param parentId
	 * @return: java.util.List<org.springblade.anbiao.QiyewenjianVO>
	 */
	List<QiyewenjianVO> tree(Integer deptId, Integer parentId);

	/**
	 *查询是否存在下级节点
	 * @author: hyp
	 * @date: 2019/5/30 9:37
	 * @param id
	 * @return: java.util.List<org.springblade.anbiao.Qiyewenjian>
	 */
	List<Qiyewenjian> getByParentId(Integer id);

	/**
	 *修改文件编号
	 * @author: hyp
	 * @date: 2019/5/30 17:23
	 * @param id
	 * @param documentNumber
	 * @return: boolean
	 */
	boolean updateDocumentNumberById(Integer id, String documentNumber);

	/**
	 * 修改文件排序号
	 * @param originId
	 * @param sort
	 * @return
	 */
	boolean updateSortById(Integer originId, Integer sort);

	/**
	 *修改访问记录
	 * @author: hyp
	 * @date: 2019/8/13 10:56
	 * @param id
	 * @return: int
	 */
	int updatePreviewRecordById(Integer id);
}
