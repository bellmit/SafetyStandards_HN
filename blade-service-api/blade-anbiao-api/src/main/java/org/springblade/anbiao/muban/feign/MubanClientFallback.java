package org.springblade.anbiao.muban.feign;

import org.springblade.anbiao.muban.entity.Muban;
import org.springblade.core.tool.api.R;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: SpringBlade
 * @author: 呵呵哒
 **/
@Component
public class MubanClientFallback implements IMubanClient {


	@Override
	public R initConf(Integer deptId,String [] tables) {
		return R.fail("同步失败");
	}
}
