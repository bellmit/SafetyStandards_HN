package org.springblade.doc.biaozhunhuamuban.feign;

import org.springblade.core.tool.api.R;
import org.springblade.doc.biaozhunhuamuban.entity.Biaozhunhuamuban;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: SpringBlade
 * @description: BlogClientFallback
 **/
@Component
public class BiaozhunhuamubanClientFallback implements IBiaozhunhuamubanClient {


	@Override
	public List<String> getImgList(Integer id) {
		return null;
	}
}
