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
package org.springblade.anbiao.config;


import org.springblade.core.secure.registry.SecureRegistry;
import org.springblade.doc.biaozhunhuamuban.entity.FileParse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * secure模块api放行配置
 * @author 呵呵哒
 */
@Configuration
public class RegistryConfiguration implements WebMvcConfigurer {

	@Bean
	public SecureRegistry secureRegistry() {
		SecureRegistry secureRegistry = new SecureRegistry();
		secureRegistry.excludePathPatterns("/anbiao/**");
		secureRegistry.excludePathPatterns("/upload/**");
		return secureRegistry;
	}

	@Bean
	public FileParse fileParse(){
		return new FileParse();
	}

//	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		//multipartResolver.setMaxUploadSize(environment.getProperty("file.upload.max.size", Long.class, 104857600L));
//		return multipartResolver;
//	}


}
