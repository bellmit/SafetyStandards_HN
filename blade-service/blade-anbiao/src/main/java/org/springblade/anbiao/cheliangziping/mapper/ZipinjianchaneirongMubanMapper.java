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
package org.springblade.anbiao.cheliangziping.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;

import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.cheliangziping.entity.ZipingQuery;

import org.springblade.anbiao.cheliangziping.entity.Zipinjiancha;
import org.springblade.anbiao.cheliangziping.entity.ZipinjianchaneirongMuban;
import org.springblade.anbiao.cheliangziping.page.ZipinjianchajieguoPage;
import org.springblade.anbiao.cheliangziping.vo.ZipinjianchaneirongMubanVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import java.util.List;

/**
 *  Mapper 接口
 *
 * @author Blade
 * @since 2019-09-02
 */
public interface ZipinjianchaneirongMubanMapper extends BaseMapper<ZipinjianchaneirongMuban> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param zipinjianchaneirongMuban
	 * @return
	 */
	  List<ZipinjianchaneirongMubanVO>  selecttable(String type);
	Zipinjiancha selectzijianjieguomuban(@Param("deptid") Integer deptid, @Param("zijianzhouqi") String zijianzhouqi);
	  Integer inertjianchajieguomuban(Zipinjiancha zipingPage);
	  Integer updatewanjie(@Param("id") String id,@Param("date")String date);
	  List<ZipinjianchaneirongMubanVO> selectjieguotable(ZipingQuery zipingQuery);
	  @SqlParser(filter=true)
	  Integer delete(String id);
	/**
	 * 统计
	 * @param
	 * @return
	 */
	int selectTotal(ZipinjianchajieguoPage zipinjianchajieguoPage);
	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	List<Zipinjiancha> selectPageList(ZipinjianchajieguoPage zipinjianchajieguoPage);
	/**
	 * 详情
	 */
	Zipinjiancha  selectByid(String  id);
	/**
	 * 获取现场检查项目
	 */
	int  CountXianChangjiancha(String  yunyingleixing);
	/**
	 * 更新主表处理率
	 */
	Integer updateChlilv(@Param("id") String id, @Param("chulilv") String chulilv);
}
