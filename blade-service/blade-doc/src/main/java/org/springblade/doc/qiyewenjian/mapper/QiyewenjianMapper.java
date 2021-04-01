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
package org.springblade.doc.qiyewenjian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import feign.Param;
import org.springblade.doc.qiyewenjian.entity.Qiyewenjian;
import org.springblade.doc.qiyewenjian.vo.QiyewenjianVO;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author Blade
 * @since 2019-05-28
 */
public interface QiyewenjianMapper extends BaseMapper<Qiyewenjian> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param qiyewenjian
	 * @return
	 */
	List<QiyewenjianVO> selectQiyewenjianPage(IPage page, QiyewenjianVO qiyewenjian);

	/**
	 *查询企业文件最大id
	 * @author: hyp
	 * @date: 2019/5/28 16:54
	 * @param
	 * @return: java.lang.Integer
	 */
	Integer selectMaxId();

	/**
	 *查询同级文件最大排序号
	 * @author: hyp
	 * @date: 2019/5/28 16:57
	 * @param id
	 * @return: java.lang.Integer
	 */
	Integer selectMaxSorByParentId(Integer id);

	/**
	 *目录树
	 * @author: hyp
	 * @date: 2019/5/30 9:38
	 * @param deptId
	 * @param parentId
	 * @return: java.util.List<org.springblade.anbiao.QiyewenjianVO>
	 */
	List<QiyewenjianVO> tree(@Param("deptId") Integer deptId, @Param("parentId") Integer parentId);

	/**
	 *查询下级节点
	 * @author: hyp
	 * @date: 2019/5/30 9:38
	 * @param parentId
	 * @return: java.util.List<org.springblade.anbiao.Qiyewenjian>
	 */
	List<Qiyewenjian> getByParentId(Integer parentId);

	/**
	 *修改文件编号
	 * @author: hyp
	 * @date: 2019/5/30 17:24
	 * @param id
	 * @param documentNumber
	 * @return: boolean
	 */
	boolean updateDocumentNumberById(@Param("id") Integer id, @Param("documentNumber") String documentNumber);

	/**
	 *修改文件排序号
	 * @author: hyp
	 * @date: 2019/5/30 17:29
	 * @param id
	 * @param sort
	 * @return: boolean
	 */
	boolean updateSortById(@Param("id") Integer id, @Param("sort") Integer sort);

	/**
	 *修改记录
	 * @author: hyp
	 * @date: 2019/8/13 10:56
	 * @param id
	 * @return: int
	 */
	int updatePreviewRecordById(Integer id);
}
