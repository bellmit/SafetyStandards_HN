package org.springblade.app.weixin.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.DigestUtil;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springblade.system.user.feign.IUserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@AllArgsConstructor
@RequestMapping("/weixinerweima/erWeiMa")
public class weixinLoginController {

	private IUserClient client;

	@GetMapping("/getOpenId")
	@ApiLog("获取openid-微信")
	@ApiOperation(value = "获取openid-微信", notes = "传入openid", position = 1)
	public String getOpenId(String openid){
		String str = "未找到该openid对应的用户";
		User user = client.getopenid(openid);
		if(user!=null){
			str="success";
		}
		return str;
	}

	@GetMapping("/updateDengluQR")
	@ApiLog("确认登录-微信")
	@ApiOperation(value = "确认登录-微信", notes = "传入openid", position =2)
	public String updateDengluQR(String openid) {

		return "success";

	}
	@GetMapping("/updateUserBD")
	@ApiLog("确认绑定-微信")
	@ApiOperation(value = "确认绑定-微信", notes = "传入openid，账号，密码", position = 3)
	public String updateUserBD(String openid, String loginName, String loginPwd) {

		String errMsg = "";
		R<UserInfo> res = client.userInfo(loginName, DigestUtil.encrypt(loginPwd));
		User user = res.getData().getUser();
		if (user != null) {
			if (StringUtils.isNotEmpty(user.getOpenid())) {
				errMsg = "该账户已经绑定";
			} else {
				client.bindDriverOpenId(loginName,openid);
				errMsg = "success";
			}

		} else {
			errMsg = "账号或密码错误";
		}

		try {
			errMsg= URLEncoder.encode(errMsg, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return errMsg;

	}
}
