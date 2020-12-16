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
package org.springblade.alarm.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import org.springblade.alarm.entity.AlarmdangerousCount;
import org.springblade.alarm.page.AlarmPlatePage;
import org.springblade.alarm.page.AlarmdangerousPage;
import org.springblade.alarm.service.IAlarmdangerousService;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import org.springblade.core.boot.ctrl.BladeController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * VIEW 控制器
 *
 * @author Blade
 * @since 2019-11-13
 */
@RestController
@AllArgsConstructor
@RequestMapping("/alarm/alarmdangerous")
@Api(value = "严重报警接口", tags = "严重报警接口")
public class AlarmdangerousController extends BladeController {
		private IAlarmdangerousService  alarmdangerousService;
		@GetMapping("/severityCount")
		@ApiLog("严重报警统计-分类")
		@ApiOperation(value = "严重报警-分类", notes = "", position = 1)
		public R  severityCount(String beginTime,String endTime, String company){


			return  R.data(alarmdangerousService.yanzhongCount(beginTime,endTime,company));

		}
		@PostMapping("/alarmTypeplateCout")
		@ApiLog("严重报警统计-报警类型车牌统计")
		@ApiOperation(value = "严重报警-报警类型车牌统计", notes = "", position = 2)
		public R  alarmTypeplateCout(@RequestBody AlarmdangerousPage alarmdangerousPage){
			//gps 严重报警 车牌统计
			if(alarmdangerousPage.getType()==0){
				AlarmdangerousPage gpsdangerous = alarmdangerousService.Gpsdangerous(alarmdangerousPage);
				List<AlarmdangerousCount> list = gpsdangerous.getRecords();
				Map<String,Object> map=new HashMap<String,Object>();
				int index=0;
				for(AlarmdangerousCount data:list){
					index+=data.getNumber();
				}
				map.put("vehicleCount",list.size());
				map.put("alarmCount",index);
				map.put("list",gpsdangerous);
				return  R.data(map);

			}
			//主动防御 严重报警 车牌统计
			if(alarmdangerousPage.getType()==1){
				AlarmdangerousPage zhudongdangerous = alarmdangerousService.zhudongdangerous(alarmdangerousPage);
				List<AlarmdangerousCount> list=zhudongdangerous.getRecords();
				Map<String,Object> map=new HashMap<String,Object>();
				int index=0;
				for(AlarmdangerousCount data:list){
					index+=data.getNumber();
				}
				map.put("vehicleCount",list.size());
				map.put("alarmCount",index);
				map.put("list",zhudongdangerous);
				return  R.data(map);

			}

				return  R.fail("查询失败");
		}

		@PostMapping("/alarmlist")
		@ApiLog("严重报警统计-gps分页")
		@ApiOperation(value = "严重报警-gps分页", notes = "AlarmPlatePage 对象", position = 3)
		public  R alarmlist(@RequestBody AlarmPlatePage alarmPlatePage){


				return  R.data(alarmdangerousService.gpslistpage(alarmPlatePage));
		}
		@PostMapping("/driverlist")
		@ApiLog("严重报警统计-driver分页")
		@ApiOperation(value = "严重报警-driver分页", notes = "AlarmPlatePage 对象", position = 3)
		public  R driverlist(@RequestBody AlarmPlatePage alarmPlatePage){


			return  R.data(alarmdangerousService.zhudonglistpage(alarmPlatePage));
		}



}
