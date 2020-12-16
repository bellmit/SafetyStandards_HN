package org.springblade.anbiao.muban.feign;

import org.springblade.anbiao.muban.service.IMubanService;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 呵呵哒
 * @description: TODO
 * @projectName SafetyStandards
 */
public class MubanClient implements IMubanClient {

    private IMubanService mubanService;

    @Override
    @GetMapping(API_PREFIX + "/initConf")
    public R initConf(Integer deptId, String[] tables) {
        return mubanService.initConf(deptId,tables);
    }
}
