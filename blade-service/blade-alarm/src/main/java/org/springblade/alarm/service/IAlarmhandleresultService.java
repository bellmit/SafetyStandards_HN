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
package org.springblade.alarm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.alarm.entity.AlarmWeichuliType;
import org.springblade.alarm.entity.Alarmhandleresult;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 *  服务类
 *
 * @author hyp
 * @since 2019-05-12
 */
public interface IAlarmhandleresultService extends IService<Alarmhandleresult> {

	/**
	 * 根据报警id串 查询处理记录
	 *
	 */
	List<Alarmhandleresult> selectIdList(Alarmhandleresult result);
	/**
	 * 根据报警id串 删除处理记录
	 *
	 */
	boolean removeByAlmIds(Alarmhandleresult result);
	/**
	 * 根据报警id查询处理详情
	 */
	Alarmhandleresult selectChuliDetail(Integer baojingid);
	/**
	 * 根据报警id查询是否被处理过
	 */
	List<Alarmhandleresult> selectBybaojin(String  id);

	/**
	 *根据ids和单位id查询报警数量
	 * @author: hyp
	 * @date: 2019/9/20 14:50
	 * @param idss
	 * @param deptName
	 * @return: int
	 */
    int selectAlarmCountByIdsAndDetpId(String[] idss, String deptName);
	/**
	  * 未处理报警处理
	 */
	List<AlarmWeichuliType>  weichulitongji(Integer deptId);
	/**
	 * 根据企业 cutoffTime时间更新处理率
	 */
	Integer updateribao(String cutoffTime,String company,String deptId);

	/**
	 * 更新二次处理信息
	 * @param twicechulixingshi
	 * @param twicechulimiaoshu
	 * @param twicechuliren
	 * @param twicechulishijian
	 * @param twicefujian
	 * @param twicechulirenid
	 * @return
	 */
	boolean updateAftertreatment(@RequestParam("twicechulixingshi") String twicechulixingshi, @RequestParam("twicechulimiaoshu") String twicechulimiaoshu, @RequestParam("twicechuliren") String twicechuliren,
								 @RequestParam("twicechulishijian") String twicechulishijian, @RequestParam("twicechulirenid") Integer twicechulirenid, @RequestParam("twicefujian") String twicefujian, @RequestParam("id") String id);


}
