package org.springblade.system.user.feign;

import org.springblade.core.tool.api.R;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: SafetyStandards
 * @description: IUserClientBack
 **/
@Component
public class IUserClientBack  implements IUserClient{
	@Override
	public R<UserInfo> userInfo(String account, String password) {
		return null;
	}

	@Override
	public User login(String account, String password) {
		return null;
	}

	@Override
	public User getopenid(String openid) {
		return null;
	}

	@Override
	public void bindDriverOpenId(String account, String openid) {

	}

	@Override
	public R<UserInfo> getWeixinUser(String openid) {
		return null;
	}

	@Override
	public User ZFUser(String type, String userId) {
		return null;
	}

	@Override
	public User ZFlogin(String account, String password) {
		return null;
	}

	@Override
	public boolean updateLocked(Integer isLocked, Integer loginErrorcount, String lastLoginErrorTime, String id) {
		return false;
	}

	@Override
	public User selectByName(String account) {
		return null;
	}

}
