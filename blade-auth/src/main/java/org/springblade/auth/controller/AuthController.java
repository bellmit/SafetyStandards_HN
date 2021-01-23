
package org.springblade.auth.controller;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import net.dreamlu.mica.captcha.servlet.MicaCaptchaServlet;
import net.dreamlu.mica.core.utils.Base64Util;
import org.apache.commons.lang.StringUtils;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Organizations;
import org.springblade.anbiao.guanlijigouherenyuan.feign.IOrganizationsClient;
import org.springblade.common.configurationBean.AlarmServer;
import org.springblade.common.configurationBean.FileServer;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.secure.utils.SecureUtil;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.DigestUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.entity.Dept;
import org.springblade.system.feign.ISysClient;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.feign.IUserClient;
import org.springblade.upload.upload.feign.IFileUploadClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取用户登录验证
 */
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@Api(value = "获取用户登录验证", tags = "获取用户登录验证")
public class AuthController {

	private IUserClient client;

	private ISysClient sysClient;

	private FileServer fileServer;

	private AlarmServer alarmServer;

	private IOrganizationsClient orrganizationsClient;

	private IFileUploadClient fileUploadClient;

	private MicaCaptchaServlet micaCaptcha;

	@PostMapping("signIn")
	@ApiLog("验证登录")
	@ApiOperation(value = "验证登录", notes = "传入账号:name,密码:password", position = 1)
	public R<AuthInfoConfig> signIn(
		@ApiParam(value = "账号", required = true) @RequestParam String name,
	    @ApiParam(value = "密码", required = true) @RequestParam String password,
	    @ApiParam(value = "验证码", required = false) @RequestParam String clientVerifyCode,
	    @ApiParam(value = "是否需要验证码登录", required = false) @RequestParam String type,
	    HttpServletResponse response) throws ParseException {
		R r = new R();
		User user;
		// 修改的本次登陆错误时间
		Date thisErrorLoginTime = null;
		// 获取是否锁定状态
		Integer islocked = 0;
		if("true".equals(fileServer.getFalg())){
			if("1".equals(type)){
				if (Func.hasEmpty(name, password)) {
					return R.fail("请输入账号，密码！");
				}
			}else{
				if (Func.hasEmpty(name, password,clientVerifyCode)) {
					return R.fail("请输入账号，密码，验证码！");
				}
				boolean validated = micaCaptcha.validate(response, clientVerifyCode);
				if(clientVerifyCode !=null || clientVerifyCode!=""){
					if(validated==false){
						return R.fail("验证码不正确");
					}
				}
			}
		}else{
			if (Func.hasEmpty(name, password)) {
				return R.fail("请输入账号，密码！");
			}
		}
		//根据登录用户名查询是否存在该用户
		user = client.selectByName(name);
		String errMsg="";
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//返回accessToken
		AuthInfoConfig info=new AuthInfoConfig();
		//验证用户
		if(user !=null){
			if (user.getIsLocked() == null) {
				user.setIsLocked(islocked);
			} else if(!user.getPassword().equals(DigestUtil.encrypt(password))){
				if (user.getLoginErrorCount() == null) {
					user.setLoginErrorCount(0);
				}
				String datestr = format.format(date);
				thisErrorLoginTime = format.parse(datestr);
				if (user.getIsLocked() == 1) {
					// 账户被锁定
					// 被锁定是登陆错误次数一定是3，所以只判断一次
					Date lastLoginErrorTime = null;
					// 最后一次登陆错误时间
					Long timeSlot = 0L;
					if (user.getLastLoginErrorTime() == null) {
						lastLoginErrorTime = thisErrorLoginTime;
					} else {
						lastLoginErrorTime = user.getLastLoginErrorTime();
						timeSlot = thisErrorLoginTime.getTime() - lastLoginErrorTime.getTime();
					}
					if (timeSlot < 300000) {
						// 判断最后锁定时间,3分钟之内继续锁定
						errMsg = "您的账户已被锁定，请" + (5-Math.ceil((double)timeSlot/60000)) + "分钟之后再次尝试";
						return R.fail(errMsg);
					} else {
						// 判断最后锁定时间,5分钟之后仍是错误，继续锁定5分钟
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						user.setLastLoginErrorTime(simpleDateFormat.parse(datestr));
						//修改用户
						client.updateLocked(user.getIsLocked(),user.getLoginErrorCount(),format.format(user.getLastLoginErrorTime()),user.getId().toString());
						errMsg = "账户或密码错误,您的账户已被锁定，请5分钟之后再次尝试登录";
						return R.fail(errMsg);
					}
				} else if (user.getLoginErrorCount() == 2) {
					// 账户第3次登陆失败，此时登陆错误次数增加至3，以后错误仍是3，不再递增
					user.setLoginErrorCount(3);
					user.setIsLocked(1);
					user.setLastLoginErrorTime(thisErrorLoginTime);
					//修改用户
					client.updateLocked(user.getIsLocked(),user.getLoginErrorCount(),format.format(user.getLastLoginErrorTime()),user.getId().toString());
					errMsg = "您的账户已被锁定，请5分钟之后再次尝试登录";
					return R.fail(errMsg);
				} else {
					// 账户前3次登陆失败
					user.setIsLocked(0);
					user.setLoginErrorCount(user.getLoginErrorCount()+1);
					user.setLastLoginErrorTime(thisErrorLoginTime);
					//修改用户
					client.updateLocked(user.getIsLocked(),user.getLoginErrorCount(),format.format(user.getLastLoginErrorTime()),user.getId().toString());
					errMsg = "账户或密码错误,您还有" + (3-user.getLoginErrorCount()) +"次登录机会";
					return R.fail(errMsg);
				}
			}else {
				user = client.login(user.getId().toString(), DigestUtil.encrypt(password));
				System.out.println(user);
				//清除锁定数据
				user.setIsLocked(0);
				user.setLoginErrorCount(0);
				user.setLastLoginErrorTime(null);
				//修改用户
				client.updateLocked(user.getIsLocked(),user.getLoginErrorCount(),null,user.getId().toString());

				//设置jwt参数
				Map<String, String> param = new HashMap<>(16);
				param.put(SecureUtil.USER_ID, Func.toStr(user.getId()));
				param.put(SecureUtil.ROLE_ID, user.getRoleId());
				param.put(SecureUtil.TENANT_CODE, user.getTenantCode());
				param.put(SecureUtil.ACCOUNT, user.getAccount());
				param.put(SecureUtil.USER_NAME, user.getRealName());
				param.put(SecureUtil.ROLE_NAME, user.getPostId());
				//拼装accessToken
				String accessToken = SecureUtil.createJWT(param, "audience", "issuser", true);

				info.setAccount(user.getAccount());
				info.setPassWord(password);
				info.setUserName(user.getRealName());
				info.setAuthority("administrator");
				info.setAccessToken(accessToken);
				info.setTokenType(SecureUtil.BEARER);
				info.setPostId(user.getPostId());
				Dept dept=sysClient.selectByJGBM("机构",user.getPostId());
				info.setDeptId(dept.getId().toString());
				info.setDeptName(dept.getDeptName());
				info.setUserId(user.getId().toString());
				info.setPostName(sysClient.getDept(Integer.parseInt(user.getPostId())).getDeptName());
				//根据单位id获取企业基本信息
				Organizations organization=orrganizationsClient.selectByDeptId(dept.getId().toString());
				if(organization!=null){
					//获取配置logo
					if(StrUtil.isNotEmpty(organization.getLogoPhoto())){
						info.setLogoPhoto(fileUploadClient.getUrlUrl(organization.getLogoPhoto()));
					}else{
						if (!StringUtils.isBlank(alarmServer.getAddressPath())){
							info.setLogoPhoto(fileServer.getUrlPrefix()+fileServer.getPhotoLogo()+"/index_"+alarmServer.getAddressPath()+".png");
						}else{
							info.setLogoPhoto(fileServer.getUrlPrefix()+fileServer.getPhotoLogo()+"/index.png");
						}
					}
				}else{
					if (!StringUtils.isBlank(alarmServer.getAddressPath())){
						info.setLogoPhoto(fileServer.getUrlPrefix()+fileServer.getPhotoLogo()+"/index_"+alarmServer.getAddressPath()+".png");
					}else{
						info.setLogoPhoto(fileServer.getUrlPrefix()+fileServer.getPhotoLogo()+"/index.png");
					}
				}
				info.setUrlPrefix(fileServer.getUrlPrefix());
				//设置token过期时间
				info.setExpiresIn(SecureUtil.getExpire());
				return R.data(info);
			}
		}else{
			if(StrUtil.hasBlank(user.getPostId()) && user != null){
				return R.fail("账号异常，请联系管理人员");
			}else{
				return R.fail("没得该账户用户");
			}
		}
		return R.data(info);
	}

	@GetMapping("signOut")
	@ApiOperation(value = "退出登录", position = 2)
	public R signOut(BladeUser user) {
		user.setRoleName("");
		user.setAccount("");
		user.setRoleId("");
		user.setTenantCode("");
		user.setUserId(0);
		user.setUserName("");
		return R.success("退出成功");
	}

	@GetMapping(value = "getVerificationCode")
	@ApiOperation(value = "获取验证码", notes = "获取验证码", position = 3)
	@ResponseBody
	public R<AuthInfoConfig> getVerificationCode(HttpServletResponse response,String deptId) {
		micaCaptcha.setCookieName("blade-Captcha");
		micaCaptcha.setCacheName("blade-Captcha");
		byte[] imgBytes =micaCaptcha.generateByteArray(response);
		String base64 = "data:image/jpeg;base64," +
			Base64Util.encodeToString(imgBytes);

		AuthInfoConfig info=new AuthInfoConfig();
		if (!alarmServer.getAddressPath().equals("ah")){
			info.setUrlPrefix(fileServer.getUrlPrefix()+fileServer.getPhotoLogo()+"/login_"+alarmServer.getAddressPath()+".png");
		}else{
			info.setUrlPrefix(fileServer.getUrlPrefix()+fileServer.getPhotoLogo()+"/login_ah.png");
		}
		info.setAccount(base64);
		return R.data(info);
	}

	@PostMapping("ZFSignIn")
	@ApiLog("获取政府登录验证")
	@ApiOperation(value = "获取政府登录验证", notes = "传入账号:name,密码:password", position = 4)
	public R<AuthInfoConfig> ZFSignIn(
		@ApiParam(value = "账号", required = true) @RequestParam String name,
		@ApiParam(value = "密码", required = true) @RequestParam String password,
		@ApiParam(value = "验证码", required = true) @RequestParam String clientVerifyCode,
		 HttpServletResponse response) {
		if (Func.hasEmpty(name, password,clientVerifyCode)) {
			return R.fail("请输入账号，密码，验证码！");
		}
		boolean validated = micaCaptcha.validate(response, clientVerifyCode);
		if(clientVerifyCode!=null||clientVerifyCode!=""){
			if(validated==false){
				return R.fail("验证码不正确");
			}
		}
		User user = client.ZFlogin(name, DigestUtil.encrypt(password));

		//验证用户
		if(user==null){
			return R.fail("用户名或密码不正确");
		}
		if(StrUtil.hasBlank(user.getPostId())){
			return R.fail("账号异常，请联系管理人员");
		}
		//设置jwt参数
		Map<String, String> param = new HashMap<>(16);
		param.put(SecureUtil.USER_ID, Func.toStr(user.getId()));
		param.put(SecureUtil.ROLE_ID, user.getRoleId());
		param.put(SecureUtil.TENANT_CODE, user.getTenantCode());
		param.put(SecureUtil.ACCOUNT, user.getAccount());
		param.put(SecureUtil.USER_NAME, user.getRealName());
		param.put(SecureUtil.ROLE_NAME, user.getPostId());
		//拼装accessToken
		String accessToken = SecureUtil.createJWT(param, "audience", "issuser", true);
		//返回accessToken
		AuthInfoConfig info=new AuthInfoConfig();
		info.setAccount(user.getAccount());
		info.setPassWord(password);
		info.setUserName(user.getRealName());
		info.setAuthority("administrator");
		info.setAccessToken(accessToken);
		info.setTokenType(SecureUtil.BEARER);
		info.setPostId(user.getPostId());
		User u = client.ZFUser("机构",user.getId().toString());
		info.setDeptId(u.getDeptId());
		info.setDeptName(u.getDeptName());
		info.setUserId(user.getId().toString());
		info.setPostName(u.getPostName());
		info.setDiqu(user.getAreaname());
		info.setMingcheng(user.getMingcheng());
		info.setUrlPrefix(fileServer.getUrlPrefix());
		//设置token过期时间
		info.setExpiresIn(SecureUtil.getExpire());
		return R.data(info);
	}

}
