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
package org.springblade.doc.biaozhunhuamuban.service;

import feign.Param;
import org.springblade.doc.biaozhunhuamuban.entity.BiaoZhunHua;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.biaozhunhuamuban.page.BiaozhunhuamubanPage;
import org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  服务类
 *
 * @author th
 * @since 2019-05-04
 */
public interface IBiaozhunhuamubanService extends IService<Biaozhunhuamuban> {


	/** 获取目录树形结构
	  * @Author th
	  * @CreateDate 2019-05-05 12:46
	  * @param deptId
	  * @return java.util.List<org.springblade.anbiao.BiaozhunhuamubanVO>
	  **/
	List<BiaozhunhuamubanVO> tree(Integer deptId, Integer parentId);

	/**
	 * 树形结构(权限设置)
	 *
	 * @return
	 */
	List<BiaozhunhuamubanVO> JurgrantTree(String deptId);

	/**
	 * 根据岗位id获取当前岗位所拥有的权限菜单id
	 * @param postId
	 * @return
	 */
	List<BiaozhunhuamubanVO> JurpostTreeKeys(String postId);

	/**
	 *查询标准化目录最大id
	 * @author: th
	 * @CreateDate: 2019-05-06 12:51
	 * @param
	 * @return: java.lang.Integer
	 */
	Integer selectMaxId();

	/**
	 *根据parentId查询下级节点
	 * @author: th
	 * @CreateDate: 2019-05-08 18:23
	 * @param parentId
	 * @return: java.util.List<org.springblade.anbiao.Biaozhunhuamuban>
	 */
	List<Biaozhunhuamuban> getByParentId(Integer parentId);

	/**
	 *查询下级节点最大sort
	 * @author: th
	 * @CreateDate: 2019-05-09 19:25
	 * @param id
	 * @return: java.lang.Integer
	 */
	Integer selectMaxSorByParentId(Integer id);

	/**
	 *根据文件性质查询目录
	 * @author: th
	 * @CreateDate: 2019-05-10 23:49
	 * @param deptId
	 * @param fileProperty
	 * @return: java.util.List<org.springblade.anbiao.BiaozhunhuamubanVO>
	 */
	List<BiaozhunhuamubanVO> filePropertyTree(Integer deptId, String fileProperty);


	/**
	 *根据文件性质查询文件列表数据
	 * @author: th
	 * @CreateDate: 2019-05-11 18:44
	 * @param biaozhunhuamubanPage
	 * @return: java.util.List<org.springblade.anbiao.Biaozhunhuamuban>
	 */
	BiaozhunhuamubanPage<BiaozhunhuamubanVO> fileList(BiaozhunhuamubanPage biaozhunhuamubanPage);

	/**
	 *修改文件性质
	 * @author: th
	 * @CreateDate: 2019-05-15 17:13
	 * @param id
	 * @param fileProperty
	 * @return: boolean
	 */
	boolean updateFilePropertyById(Integer id, String fileProperty);

	/**
	 *修改文件所属人
	 * @author: th
	 * @date: 2019/5/19 14:23
	 * @param id
	 * @param fileSuoshurenId
	 * @return: boolean
	 */
	boolean updatefileSuoshurenById(Integer id, Integer fileSuoshurenId);

	/**
	 *根据id修改文档编号
	 * @author: th
	 * @date: 2019/5/27 9:56
	 * @param id
	 * @param documentNumber
	 * @return: boolean
	 */
	boolean updateDocumentNumberById(Integer id, String documentNumber);


	/**
	 *根据模板文件id实现两文件排序号对调,实现文件排序上下移动
	 * @author: th
	 * @date: 2019/5/27 15:47
	 * @param originId
	 * @param targetId
	 * @return: boolean
	 */
	boolean swapFileSort(Integer originId, Integer targetId);

	/**
	 * 更改模板文件排序号
	 * @param id
	 * @param sort
	 * @return
	 */
	boolean updateSortById(Integer id, Integer sort);

	/**
	 *文件重命名
	 * @author: th
	 * @date: 2019/6/19 17:09
	 * @param id
	 * @param name
	 * @return: boolean
	 */
	boolean updateNameById(Integer id, String name);

	/**
	 *更新记录
	 * @author: th
	 * @date: 2019/8/12 23:38
	 * @param id
	 * @return: int
	 */
	int updatePreviewRecordById(Integer id);

	/**
	 *获取模板树
	 * @author: th
	 * @date: 2019/9/3 10:45
	 * @param
	 * @return: java.util.List<org.springblade.doc.biaozhunhuamuban.vo.BiaozhunhuamubanVO>
	 */
	List<BiaozhunhuamubanVO> getMubanTree(Integer yunyingleixing,Integer isOnlyDir);

	/**
	 * 查询机构下标准化模板文件的数量
	 * @param id
	 * @return
	 */
    int getCountByDetpId(Integer id);

    /**
     *插入标准化文件与安全生产文档绑定关系
     * @author: th
     * @date: 2019/11/12 21:48
     * @param id
     * @param split
     * @return: void
     */
    void insertBind(Integer id, String[] split);

    /**
     *取消绑定
     * @author: th
     * @date: 2019/11/12 22:52
     * @param id
     * @return: void
     */
	void deleteBind(Integer id);

	/**
	 * 查询已生成标准化相关文件的企业信息
	 * @param biaozhunhuamubanPage
	 * @return
	 */
	BiaozhunhuamubanPage selectGetBiaoZhunHuaList(BiaozhunhuamubanPage biaozhunhuamubanPage);

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
}
