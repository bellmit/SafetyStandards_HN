package org.springblade.anbiao.configure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;
import org.springblade.anbiao.configure.entity.Configure;

import java.util.List;
/**
* @Description:
*/
public interface ConfigureMapper extends BaseMapper<Configure> {

	/**
	* @Description:
	* @Param: [deptId]
	*/
	List<Configure> selectMapList(@Param("tableName") String tableName, @Param("deptId") Integer deptId);

	/**
	 * @Description: 逻辑删除
	 * @Param: [id]
	 */
	boolean delMap(@Param("tableName") String tableName,@Param("id") String id);
	/**
	* @Description:
	* @Param: [tableName, deptId]
	*/
	boolean delMapByDeptId(@Param("tableName") String tableName,@Param("deptId") String deptId);

	boolean delMapByDeptIdDel(@Param("tableName") String tableName,@Param("deptId") String deptId,@Param("shujubiaoziduan") String shujubiaoziduan);



	/**
	 * 根据id获取数据
	 * @param tableName
	 * @param id
	 * @return
	 */
	Configure selectByIds(@Param("tableName") String tableName,@Param("id") String id);
	/**
	* @Description: 自定义提交
	* @Param: [Configure]
	*/
	boolean insertMap(Configure Configure);

	/**
	* @Description: 自定义编辑
	* @Param: [Configure]
	*/
	boolean updateMap(Configure Configure);

	/**
	 * 获取当前系统存在的模板表
	 * @param
	 * @return
	 */
	List<Configure> selectByName();
}
