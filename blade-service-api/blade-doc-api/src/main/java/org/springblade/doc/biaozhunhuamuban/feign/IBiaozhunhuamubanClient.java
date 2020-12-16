package org.springblade.doc.biaozhunhuamuban.feign;

import io.swagger.annotations.ApiParam;
import org.springblade.core.tool.api.R;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
	//定义Feign指向的service-id
	value = "blade-doc",
	//定义hystrix配置类
	fallback = BiaozhunhuamubanClientFallback.class
)
public interface IBiaozhunhuamubanClient{

	/**
	 * 接口前缀
	 */
	String API_PREFIX = "/doc/biaozhunhuamuban";

	/**
	 * 获取详情
	 *
	 * @param id 主键
	 * @return
	 */
	@GetMapping(API_PREFIX + "/getImgList")
	List<String> getImgList(@RequestParam("id") Integer id);
}
