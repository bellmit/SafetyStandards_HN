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
package org.springblade.anbiao.configure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import feign.Param;
import org.springblade.anbiao.configure.entity.Configure;

import java.util.List;

/**
 *  服务类
 */
public interface IConfigureService extends IService<Configure> {

	/**
	 * @Description:
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
