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
package org.springblade.system.user.feign;

import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springblade.system.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

/**
 * 用户服务Feign实现类
 *
 * @author hyp
 */
@ApiIgnore
@RestController
@AllArgsConstructor
public class UserClient implements IUserClient {

	IUserService service;

	@Override
	@GetMapping(API_PREFIX + "/user-info")
	public R<UserInfo> userInfo( String account, String password) {
		return R.data(service.userInfo( account, password));
	}

	@Override
	@GetMapping(API_PREFIX + "/login")
	public User login( String account, String password) {
		return service.login( account, password);
	}
	@Override
	@GetMapping(API_PREFIX + "/getOpenId")
	public User getopenid(String openid){
		return service.selectByopenId(openid);
	}
	@Override
	@GetMapping(API_PREFIX + "/bindDriverOpenId")
	public void bindDriverOpenId(String account,String openid){
		service.bindDriverOpenId(account,openid);
	}
	@Override
	@GetMapping(API_PREFIX + "/getWeixinUser")
	public R<UserInfo> getWeixinUser(String openid){
		return R.data(service.getWeixinUser(openid));
	}

	@Override
	public User ZFUser(String type, String userId) {
		return service.getZFUserInfo(type,userId);
	}

	@Override
	public User ZFlogin(String account, String password) {
		return service.ZFlogin(account, password);
	}

	@Override
	public boolean updateLocked(Integer isLocked, Integer loginErrorcount, String lastLoginErrorTime, String id) {
		return service.updateLocked(isLocked, loginErrorcount, lastLoginErrorTime, id);
	}

	@Override
	public User selectByName(String account) {
		return service.selectByName(account);
	}


}
