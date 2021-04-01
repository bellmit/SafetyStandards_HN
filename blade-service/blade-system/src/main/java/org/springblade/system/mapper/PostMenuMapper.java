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
package org.springblade.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;
import org.springblade.system.entity.PostMenu;

import java.util.List;

/**
 * Mapper 接口
 */
public interface PostMenuMapper extends BaseMapper<PostMenu> {

	/**
	 * 自定义删除
	 * @param postId
	 * @return
	 */
	boolean deleteByPostId(Integer postId,Integer type);

	List<PostMenu> selectListByPostId(Integer postId,Integer type);

	List<PostMenu> selectListByPostIdBusiness(Integer postId,Integer type);

	List<PostMenu> selectListByPostIdApp(Integer postId,Integer type);


	/**
	 *根据postIds批量删除权限
	 * @author: hyp
	 * @date: 2019/10/24 16:20
	 * @param postIds
	 * @param type
	 * @return: void
	 */
    void deleteByPostIds(@Param("postIds") List<Integer> postIds, @Param("type") int type);

    /**
     *根据postIds获取所有postmenu
     * @author: hyp
     * @date: 2019/10/24 16:27
     * @param postIds
     * @param type
     * @return: java.util.List<org.springblade.system.entity.PostMenu>
     */
	List<PostMenu> getByPostIds(@Param("postIds") List<Integer> postIds, @Param("type") Integer type);
}
