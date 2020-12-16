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
package org.springblade.doc.biaozhunhuamuban.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import feign.Param;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuawenjian;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuawenjianVO;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author th
 * @since 2019-05-10
 */
public interface BiaozhunhuawenjianMapper extends BaseMapper<Biaozhunhuawenjian> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param biaozhunhuawenjian
	 * @return
	 */
	List<BiaozhunhuawenjianVO> selectBiaozhunhuawenjianPage(IPage page, BiaozhunhuawenjianVO biaozhunhuawenjian);

	BiaozhunhuawenjianVO selectPicPath(Integer biaozhunhuamubanId, Integer fileType);

	/**
	 *逻辑删除文件
	 * @author: th
	 * @CreateDate: 2019-05-15 21:12
	 * @param mubanId
	 * @return: int
	 */
	int removeByMubanId(Integer mubanId);

	/**
	 *根据模板id获取文件
	 * @author: th
	 * @CreateDate: 2019-05-15 21:18
	 * @param mubanId
	 * @return: java.util.List<org.springblade.anbiao.Biaozhunhuawenjian>
	 */
	List<Biaozhunhuawenjian> getByMubanId(Integer mubanId);

	/**
	 *根据文件所属人查询文件路径
	 * @author: th
	 * @date: 2019/5/19 14:41
	 * @param fileProperty
	 * @param fileSuoshurenId
	 * @return: org.springblade.anbiao.BiaozhunhuawenjianVO
	 */
	BiaozhunhuawenjianVO selectPicPathBySuoshurenId(@Param("fileProperty") String fileProperty, @Param("fileSuoshurenId") Integer fileSuoshurenId);

	/**
	 *更新记录
	 * @author: th
	 * @date: 2019/8/13 11:05
	 * @param id
	 * @return: int
	 */
	int updatePreviewRecordById(Integer id);
}
