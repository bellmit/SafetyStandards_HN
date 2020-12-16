package org.springblade.deadline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.deadline.entity.Deadline;
import org.springblade.deadline.mapper.DeadlineMapper;
import org.springblade.deadline.service.DeadlineService;
import org.springframework.stereotype.Service;

/**
 * @program: SpringBlade
 * @description: DeadlineServiceImpl
 */
@Service
@AllArgsConstructor
public class DeadlineServiceImpl extends ServiceImpl<DeadlineMapper, Deadline> implements DeadlineService {

    private  DeadlineMapper deadlineMapper;


	@Override
	public Deadline selectByMainboard(String mainboard) {
		return deadlineMapper.selectByMainboard(mainboard);
	}
}
