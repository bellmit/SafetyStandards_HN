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
package org.springblade.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.system.entity.PostMenu;
import org.springblade.system.entity.RoleMenu;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 服务类
 *
 * @author hyp
 */
public interface IPostMenuService extends IService<PostMenu> {
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
	 * 根据postIds批量删除
	 * @param postIds
	 * @param i
	 */
    void deleteByPostIds(List<Integer> postIds, int i);

    /**
     *根据postIds获取所有postmenu
     * @author: hyp
     * @date: 2019/10/24 16:26
     * @param postIds
     * @param type
     * @return: java.util.List<org.springblade.system.entity.PostMenu>
     */
	List<PostMenu> getByPostIds(List<Integer> postIds, Integer type);
}
