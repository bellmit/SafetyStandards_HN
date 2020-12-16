package org.springblade.manage.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: SafetyStandards
 * @description: DruidDBConfig
 * @author: 呵呵哒
 **/
@Configuration
public class DruidConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource(){
		return new DruidDataSource();
	}

	/**
	 * 配置druid监控
	 * 配置一个管理后台的servlet
	 * 访问地址：http://localhost:8080/druid/
	 * @return
	 */
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		//属性见：com.alibaba.druid.support.http.ResourceServlet
		initParameters.put("loginUsername", "admin");
		initParameters.put("loginPassword", "123456");
		//默认允许所有
		initParameters.put("allow", "");
		initParameters.put("deny", "");
		bean.setInitParameters(initParameters);
		return bean;
	}

	/**
	 * 配置一个web监控的filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new WebStatFilter());
		filterBean.setUrlPatterns(Arrays.asList("/*"));

		Map<String, String> initParameters = new HashMap<String, String>();
		//属性见：com.alibaba.druid.support.http.WebStatFilter
		initParameters.put("exclusions", "*.js,*.css,/druid/*");
		filterBean.setInitParameters(initParameters);

		return filterBean;
	}
}
