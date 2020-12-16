package org.springblade.doc.safetyproductionfile.feign;

import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springblade.doc.safetyproductionfile.entity.SafetyProductionFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
	//定义Feign指向的service-id
	value = "blade-doc",
	//定义hystrix配置类
	fallback = SafetyProductionFileClientFallback.class
)
public interface ISafetyProductionFileClient {

	/**
	 * 接口前缀
	 */
	String API_PREFIX = "doc/SafetyProductionFile";

	/**
	 * 获取详情
	 *
	 * @param id 主键
	 * @return
	 */
	@GetMapping(API_PREFIX + "/getImgList")
	List<String> getImgList(@RequestParam("id") Integer id);
}
