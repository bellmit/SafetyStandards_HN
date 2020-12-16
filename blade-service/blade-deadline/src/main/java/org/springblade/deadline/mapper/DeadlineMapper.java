package org.springblade.deadline.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.deadline.entity.Deadline;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: 呵呵哒
 */
public interface DeadlineMapper extends BaseMapper<Deadline> {

	Deadline selectByMainboard(String mainboard);

}
