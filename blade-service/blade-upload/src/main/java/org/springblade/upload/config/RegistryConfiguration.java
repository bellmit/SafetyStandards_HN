/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * limitations under the License.
 */
package org.springblade.upload.config;


import org.springblade.core.secure.registry.SecureRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * secure模块api放行配置
 */
@Configuration
public class RegistryConfiguration implements WebMvcConfigurer {

	@Bean
	public SecureRegistry secureRegistry() {
		SecureRegistry secureRegistry = new SecureRegistry();
		secureRegistry.excludePathPatterns("/upload/**");
		return secureRegistry;
	}
//	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		//multipartResolver.setMaxUploadSize(environment.getProperty("file.upload.max.size", Long.class, 104857600L));
//		return multipartResolver;
//	}


}
