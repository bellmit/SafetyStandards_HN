package org.springblade.deadline.feign;

import org.springblade.deadline.entity.Deadline;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@FeignClient(
	//定义Feign指向的service-id
	value = "blade-deadline",
	//定义hystrix配置类
	fallback = IDeadlineClientFallback.class
)
public interface IDeadlineClient {

	/**
	 * 接口前缀
	 */
	String API_PREFIX = "/deadline";

	@PostMapping(API_PREFIX + "/saveOrUpdate")
	Boolean saveOrUpdate(@Valid @RequestBody Deadline deadline);
	/**
	 * 获取计算机标识是否存在
	 *
	 * @param mainboard 主键
	 * @return
	 */
	@GetMapping(API_PREFIX + "/selectByMainboard")
	Deadline selectByMainboard(@RequestParam("mainboard") String mainboard);


}
