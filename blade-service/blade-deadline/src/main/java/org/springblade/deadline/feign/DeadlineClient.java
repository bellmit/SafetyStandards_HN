package org.springblade.deadline.feign;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.deadline.entity.Deadline;
import org.springblade.deadline.service.DeadlineService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * @program: SpringBlade
 * @description: IDeadlineClient
 */
@ApiIgnore
@RestController
@AllArgsConstructor
public class DeadlineClient implements IDeadlineClient {

	private  DeadlineService DeadlineService;

	@Override
	@PostMapping(DeadlineClient.API_PREFIX + "/saveOrUpdate")
	@ApiOperation(value = "新增or编辑(feign使用)", notes = "传入deadline", position = 1)
	public Boolean saveOrUpdate(@Valid @RequestBody Deadline deadline) {
		return DeadlineService.saveOrUpdate(deadline);
	}

	@Override
	@GetMapping(DeadlineClient.API_PREFIX + "/selectByMainboard")
	public Deadline selectByMainboard(@RequestParam("mainboard") String mainboard) {
		return DeadlineService.selectByMainboard(mainboard);
	}
}
