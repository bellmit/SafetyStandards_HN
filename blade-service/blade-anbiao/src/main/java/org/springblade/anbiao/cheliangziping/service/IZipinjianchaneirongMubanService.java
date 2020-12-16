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
package org.springblade.anbiao.cheliangziping.service;

import org.springblade.anbiao.cheliangziping.entity.ZipingQuery;

import org.springblade.anbiao.cheliangziping.entity.Zipinjiancha;
import org.springblade.anbiao.cheliangziping.entity.ZipinjianchaneirongMuban;
import org.springblade.anbiao.cheliangziping.page.ZipinjianchajieguoPage;
import org.springblade.anbiao.cheliangziping.vo.ZipinjianchaneirongMubanVO;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
 *  服务类
 *
 * @author Blade
 * @since 2019-09-02
 */
public interface IZipinjianchaneirongMubanService extends IService<ZipinjianchaneirongMuban> {


	List<ZipinjianchaneirongMubanVO>  selecttable(String type);
	Zipinjiancha  selectzipingjianchajieguo(Integer deptid,String zijianzhouqi);
	Integer  insretzipingmuban(Zipinjiancha zipingjianchajieguoMuban);
	Integer updatewanjie(String id,String  date);
	List<ZipinjianchaneirongMubanVO> selectjieguotable(ZipingQuery zipingQuery);
	Integer delete(String id);

	/**
	 * 分页查询
	 * @return
	 */
	ZipinjianchajieguoPage selectpage(ZipinjianchajieguoPage zipinjianchajieguoPage);
	/**
	 * 详情
	 */
	Zipinjiancha selectByid(String  id);
	/**
	 * 统计现场检查项
	 */
	int  CountXianChangjiancha(String  yunyingleixing);
	/**
	 * 更新主表处理率
	 */
	Integer updateChlilv(String id,String chulilv);
}
