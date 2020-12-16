package org.springblade.anbiao.muban.mapper;

import feign.Param;
import org.springblade.anbiao.muban.entity.MubanMap;

import java.util.List;

/**
* @Description:
*/
public interface MubanMapMapper {

	/**
	* @return: java.util.List<org.springblade.anbiao.entity.configure>
	*/
	List<MubanMap> selectMapList(@Param("tableName") String tableName);

	/**
	 * @Description: 逻辑删除
	 */
	boolean delMap( @Param("id") String id);

	/**
	* @Description: 自定义提交
	* @Param: [Configure]
	* @return: boolean
	* @Author: 呵呵哒
	*/
	boolean insertMap(MubanMap Configure);

	/**
	* @Description: 自定义编辑
	* @Param: [Configure]
	* @Author: 呵呵哒
	*/
	boolean updateMap(MubanMap Configure);

	/**
	 *查询配置
	 * @author: th
	 * @date: 2019/7/23 11:16
	 * @param deptId
	 * @param table
	 * @return: java.util.List<org.springblade.anbiao.muban.entity.MubanMap>
	 */

	List<MubanMap> getConfByDeptIdForTable(@Param("deptID") Integer deptId, @Param("table")String table);

	/**
	 *批量插入mubanMap
	 * @author: th
	 * @date: 2019/7/23 12:25
	 * @param mubanMapList
	 * @return: int
	 */
	int insertList(List<MubanMap> mubanMapList);

	/**
	 *清空
	 * @author: th
	 * @date: 2019/7/23 12:25
	 * @param
	 * @return: int
	 */
	int delAll();
}

