package org.springblade.deadline.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.deadline.entity.Deadline;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: 呵呵哒
 */
public interface  DeadlineService extends IService<Deadline> {

	Deadline selectByMainboard(String mainboard);
}
