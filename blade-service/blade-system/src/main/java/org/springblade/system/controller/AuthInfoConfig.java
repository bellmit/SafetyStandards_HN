package org.springblade.system.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: SafetyStandards
 * @description: AuthInfo
 **/
@ApiModel(
	description = "认证信息"
)
public class AuthInfoConfig {
	@ApiModelProperty("令牌")
	private String accessToken;
	@ApiModelProperty("令牌类型")
	private String tokenType;
	@ApiModelProperty("头像")
	private String avatar = "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png";
	@ApiModelProperty("角色名")
	private String authority;
	@ApiModelProperty("用户名")
	private String userName;
	@ApiModelProperty("账号名")
	private String account;
	@ApiModelProperty("过期时间")
	private long expiresIn;
	@ApiModelProperty("许可证")
	private String license = "made by blade";
	@ApiModelProperty("单位id")
	private String deptId;
	@ApiModelProperty("岗位id")
	private String postId;

	@ApiModelProperty("机构名称")
	private String deptName;
	@ApiModelProperty("验证码")
	private String clientVerifyCode;
	@ApiModelProperty("岗位名称")
	private String postName;
	@ApiModelProperty("人员id")
	private String userId;
	@ApiModelProperty(value = "home图片")
	private String homePhoto;
	@ApiModelProperty(value = "profilePhoto")
	private String profilePhoto;
	@ApiModelProperty(value = "logoPhoto")
	private String logoPhoto;
	@ApiModelProperty(value = "passWord")
	private String passWord;
	@ApiModelProperty(value = "home页附件(App)")
	private String homePhotoApp;
	@ApiModelProperty(value = "简介页附件(App)")
	private String profilePhotoApp;
	@ApiModelProperty(value = "login页附件(App)")
	private String loginPhotoApp;

	public AuthInfoConfig() {
	}


	public String getAccessToken() {
		return this.accessToken;
	}

	public String getTokenType() {
		return this.tokenType;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public String getAuthority() {
		return this.authority;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getAccount() {
		return this.account;
	}

	public long getExpiresIn() {
		return this.expiresIn;
	}

	public String getLicense() {
		return this.license;
	}

	public void setAccessToken(final String accessToken) {
		this.accessToken = accessToken;
	}

	public void setTokenType(final String tokenType) {
		this.tokenType = tokenType;
	}

	public void setAvatar(final String avatar) {
		this.avatar = avatar;
	}

	public void setAuthority(final String authority) {
		this.authority = authority;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public void setAccount(final String account) {
		this.account = account;
	}

	public void setExpiresIn(final long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setLicense(final String license) {
		this.license = license;
	}

	@Override
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof AuthInfoConfig)) {
			return false;
		} else {
			AuthInfoConfig other = (AuthInfoConfig)o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				Object this$accessToken = this.getAccessToken();
				Object other$accessToken = other.getAccessToken();
				if (this$accessToken == null) {
					if (other$accessToken != null) {
						return false;
					}
				} else if (!this$accessToken.equals(other$accessToken)) {
					return false;
				}

				Object this$tokenType = this.getTokenType();
				Object other$tokenType = other.getTokenType();
				if (this$tokenType == null) {
					if (other$tokenType != null) {
						return false;
					}
				} else if (!this$tokenType.equals(other$tokenType)) {
					return false;
				}

				Object this$avatar = this.getAvatar();
				Object other$avatar = other.getAvatar();
				if (this$avatar == null) {
					if (other$avatar != null) {
						return false;
					}
				} else if (!this$avatar.equals(other$avatar)) {
					return false;
				}

				label78: {
					Object this$authority = this.getAuthority();
					Object other$authority = other.getAuthority();
					if (this$authority == null) {
						if (other$authority == null) {
							break label78;
						}
					} else if (this$authority.equals(other$authority)) {
						break label78;
					}

					return false;
				}

				label71: {
					Object this$userName = this.getUserName();
					Object other$userName = other.getUserName();
					if (this$userName == null) {
						if (other$userName == null) {
							break label71;
						}
					} else if (this$userName.equals(other$userName)) {
						break label71;
					}

					return false;
				}

				Object this$account = this.getAccount();
				Object other$account = other.getAccount();
				if (this$account == null) {
					if (other$account != null) {
						return false;
					}
				} else if (!this$account.equals(other$account)) {
					return false;
				}

				if (this.getExpiresIn() != other.getExpiresIn()) {
					return false;
				} else {
					Object this$license = this.getLicense();
					Object other$license = other.getLicense();
					if (this$license == null) {
						if (other$license != null) {
							return false;
						}
					} else if (!this$license.equals(other$license)) {
						return false;
					}

					return true;
				}
			}
		}
	}

	protected boolean canEqual(final Object other) {
		return other instanceof AuthInfoConfig;
	}

	@Override
	public int hashCode() {
		boolean PRIME = true;
		int result = 1;
		Object $accessToken = this.getAccessToken();
		result = result * 59 + ($accessToken == null ? 43 : $accessToken.hashCode());
		Object $tokenType = this.getTokenType();
		result = result * 59 + ($tokenType == null ? 43 : $tokenType.hashCode());
		Object $avatar = this.getAvatar();
		result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
		Object $authority = this.getAuthority();
		result = result * 59 + ($authority == null ? 43 : $authority.hashCode());
		Object $userName = this.getUserName();
		result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
		Object $account = this.getAccount();
		result = result * 59 + ($account == null ? 43 : $account.hashCode());
		long $expiresIn = this.getExpiresIn();
		result = result * 59 + (int)($expiresIn >>> 32 ^ $expiresIn);
		Object $license = this.getLicense();
		result = result * 59 + ($license == null ? 43 : $license.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AuthInfo(accessToken=" + this.getAccessToken() + ", tokenType=" + this.getTokenType() + ", avatar=" + this.getAvatar() + ", authority=" + this.getAuthority() + ", userName=" + this.getUserName() + ", account=" + this.getAccount() + ", expiresIn=" + this.getExpiresIn() + ", license=" + this.getLicense() + ")";
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getClientVerifyCode() {
		return clientVerifyCode;
	}

	public void setClientVerifyCode(String clientVerifyCode) {
		this.clientVerifyCode = clientVerifyCode;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHomePhoto() {
		return homePhoto;
	}

	public void setHomePhoto(String homePhoto) {
		this.homePhoto = homePhoto;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getLogoPhoto() {
		return logoPhoto;
	}

	public void setLogoPhoto(String logoPhoto) {
		this.logoPhoto = logoPhoto;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getHomePhotoApp() {
		return homePhotoApp;
	}

	public void setHomePhotoApp(String homePhotoApp) {
		this.homePhotoApp = homePhotoApp;
	}

	public String getProfilePhotoApp() {
		return profilePhotoApp;
	}

	public void setProfilePhotoApp(String profilePhotoApp) {
		this.profilePhotoApp = profilePhotoApp;
	}

	public String getLoginPhotoApp() {
		return loginPhotoApp;
	}

	public void setLoginPhotoApp(String loginPhotoApp) {
		this.loginPhotoApp = loginPhotoApp;
	}
}
