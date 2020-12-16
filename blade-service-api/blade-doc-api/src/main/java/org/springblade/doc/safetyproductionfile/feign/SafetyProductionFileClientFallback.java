package org.springblade.doc.safetyproductionfile.feign;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SpringBlade
 * @description: BlogClientFallback
 **/
@Component
public class SafetyProductionFileClientFallback implements ISafetyProductionFileClient {


	@Override
	public List<String> getImgList(Integer id) {
		return null;
	}
}
