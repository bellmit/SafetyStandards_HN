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

import org.springblade.doc.biaozhunhuamuban.entity.BiaoZhunHua;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.biaozhunhuamuban.entity.BiaozhunhuamubanList;
import org.springblade.doc.biaozhunhuamuban.page.BiaozhunhuamubanPage;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO;
import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;

import java.util.List;

/**
 *  Mapper 接口
 * @author 呵呵哒
 */
public interface BiaozhunhuamubanMapper extends BaseMapper<Biaozhunhuamuban> {

	/** 获取目录树形结构
	  * @Author 呵呵哒
	  * @Param [deptId]
	  * @return java.util.List<org.springblade.anbiao.BiaozhunhuamubanVO>
	  **/
	@SqlParser(filter=true)
	List<BiaozhunhuamubanVO> tree(@Param("deptId") Integer deptId, @Param("parentId") Integer parentId);

	/**
	 * 树形结构(权限设置)
	 *
	 * @return
	 */
	List<BiaozhunhuamubanVO> JurgrantTree(@Param("deptId") String deptId);

	/**
	 * 根据岗位id获取当前岗位所拥有的权限菜单id
	 * @param postId
	 * @return
	 */
	List<BiaozhunhuamubanVO> JurpostTreeKeys(@Param("postId") String postId);

	/**
	 *获取标准化目录最大id
	 * @author: 呵呵哒
	 * @return: java.lang.Integer
	 */
	Integer selectMaxId();

	/**
	 *根据parentId查询下级节点
	 * @author: 呵呵哒
	 * @param parentId
	 * @return: java.util.List<org.springblade.anbiao.Biaozhunhuamuban>
	 */
	List<Biaozhunhuamuban> getByParentId(Integer parentId);

	/**
	 *查询下级节点的最大sort
	 * @author: 呵呵哒
	 * @param id
	 * @return: java.lang.Integer
	 */
	Integer selectMaxSorByParentId(Integer id);

	/**
	 *获取根据文件性质查询目录
	 * @author: 呵呵哒
	 * @return: java.util.List<org.springblade.anbiao.BiaozhunhuamubanVO>
	 */
	@SqlParser(filter=true)
	List<BiaozhunhuamubanVO> filePropertyTree(@Param("deptId") Integer deptId, @Param("fileProperty") String fileProperty);


	/**
	 *根据文件性质查询文件列表数据
	 * @author: 呵呵哒
	 * @param biaozhunhuamubanPage
	 * @return: java.util.List<org.springblade.anbiao.Biaozhunhuamuban>
	 */
	List<BiaozhunhuamubanVO> fileList(BiaozhunhuamubanPage biaozhunhuamubanPage);

	int selectTotal(BiaozhunhuamubanPage biaozhunhuamubanPage);

	/**
	 *修改文件性质
	 * @author: 呵呵哒
	 * @param id
	 * @param fileProperty
	 * @return: boolean
	 */
	boolean updateFilePropertyById(@Param("id") Integer id, @Param("fileProperty") String fileProperty);

	/**
	 *根据id修改文件所属人
	 * @author: 呵呵哒
	 * @param id
	 * @param fileSuoshurenId
	 * @return: boolean
	 */
	boolean updatefileSuoshurenById(@Param("id") Integer id, @Param("fileSuoshurenId") Integer fileSuoshurenId);

	/**
	 *根据id修改文档编号
	 * @author: 呵呵哒
	 * @param id
	 */
	boolean updateDocumentNumberById(@Param("id") Integer id, @Param("documentNumber") String documentNumber);


	/**
	 *获取根据模板文件id实现两文件排序号对调,实现文件排序上下移动
	 * @author: 呵呵哒
	 */
	@SqlParser(filter=true)
	boolean swapFileSort(@Param("originId") Integer originId, @Param("targetId") Integer targetId);

	/**
	 *获取更改模板文件排序号
	 * @author: 呵呵哒
	 * @return: boolean
	 */
	boolean updateSortById(@Param("id") Integer id, @Param("sort") Integer sort);

	/**
	 *重命名文件
	 * @author: 呵呵哒
	 * @return: boolean
	 */
	boolean updateNameById(@Param("id") Integer id, @Param("name") String name);

	/**
	 *获取更新记录
	 * @author: 呵呵哒
	 * @return: int
	 * @param id
	 */
	int updatePreviewRecordById(Integer id);

	/**
	 *获取模板树
	 * @author: 呵呵哒
	 * @return: java.util.List<org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO>
	 */
	List<BiaozhunhuamubanVO> getMubanTree(@Param("yunyingleixing") Integer yunyingleixing,@Param("isOnlyDir") Integer isOnlyDir);

	/**
	 *获取机构的标准化文件数量
	 * @author: 呵呵哒
	 * @param id
	 * @return: int
	 */
    int getCountByDetpId(Integer id);

    /**
     *插入标准化文件与安全生产文档绑定关系
     * @author: 呵呵哒
     * @param id
     */
    void insertBind(@Param("id") Integer id, @Param("safetyIds") String[] safetyIds);

    /**
     *取消绑定(删除)
     * @author: 呵呵哒
     * @return: void
     */
	void deleteBind(Integer id);

	/**
	 * 查询已生成标准化相关文件的企业信息
	 * @param biaozhunhuamubanPage
	 * @return
	 */
	List<BiaoZhunHua> selectGetBiaoZhunHuaList(BiaozhunhuamubanPage biaozhunhuamubanPage);
	int selectGetBiaoZhunHuaListTotal(BiaozhunhuamubanPage biaozhunhuamubanPage);

	/**
	 * 安全管理标准文档-一键生成，未生成的企业
	 * @param deptId
	 * @return
	 */
	List<BiaoZhunHua> selectGetQYWD(@Param("deptId") Integer deptId);

	/**
	 * 安全标准化文件-一键生成，未生成的企业
	 * @param deptId
	 * @return
	 */
	List<BiaoZhunHua> selectGetQYWJ(@Param("deptId") Integer deptId);

	/**
	 * 根据企业ID删除标准化模板文件
	 * @param deptId
	 * @return
	 */
	boolean deleteBiaozhunhuamuban(@Param("caozuorenid") Integer caozuorenid,@Param("caozuoren") String caozuoren
	,@Param("deptId") Integer deptId);

	/**
	 * 根据企业ID删除标准化文档文件
	 * @param deptId
	 */
	boolean deleteSafetyProductionFile(@Param("caozuorenid") Integer caozuorenid,@Param("caozuoren") String caozuoren
		,@Param("deptId") Integer deptId);

	/**
	 * 根据文件ID更新标准化文件相应数据（如分值、描述信息、报警等级等）
	 * @param biaozhunhuamuban
	 * @return
	 */
	boolean updateBiaozhunhuamuban(Biaozhunhuamuban biaozhunhuamuban);

	/**
	 * 根据企业ID获取相应标准化文件列表数据
	 * @param deptId
	 * @return
	 */
	@SqlParser(filter=true)
//	List<BiaozhunhuamubanList> listTree(@Param("deptId") Integer deptId,@Param("fileProperty") Integer fileProperty,@Param("Id") Integer Id);
	List<BiaozhunhuamubanList> listTree(@Param("deptId") Integer deptId, @Param("fileProperty") Integer fileProperty, @Param("Id") Integer Id, @Param("parentId") Integer parentId);
	/**
	 * 根据企业ID、标准化文件类型获取自评总分
	 * @param deptId
	 * @param fileProperty
	 * @return
	 */
	BiaozhunhuamubanList getTreeScores(@Param("deptId") Integer deptId, @Param("fileProperty") Integer fileProperty);

	/**
	 * 根据企业ID获取安全标准化文件树
	 * @param deptId
	 * @return
	 */
	List<BiaozhunhuamubanVO> getListTree(@Param("deptId") String deptId, @Param("fileProperty") Integer fileProperty);

	/**
	 * 根据企业ID查询企业标准化文件类型
	 * @param deptId
	 * @return
	 */
	BiaozhunhuamubanVO getByDeptId(@Param("deptId") String deptId);

}
