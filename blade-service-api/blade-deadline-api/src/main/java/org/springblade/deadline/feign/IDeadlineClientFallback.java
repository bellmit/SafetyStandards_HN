package org.springblade.deadline.feign;

import org.springblade.deadline.entity.Deadline;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @program: SpringBlade
 * @author: 呵呵哒
 **/
@Component
public class IDeadlineClientFallback implements IDeadlineClient {

	@Override
	public Boolean saveOrUpdate(@Valid Deadline personnel) {
		return null;
	}

	@Override
	public Deadline selectByMainboard(String mainboard) {
		return null;
	}
}
