package org.springblade.common.tool;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: SafetyStandards
 * @author: 呵呵哒
 **/
public class SessionUtil {
	/**
	 * 获取当前session
	 *
	 * @return
	 */
	public static HttpSession session() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		return request.getSession();
	}

}
