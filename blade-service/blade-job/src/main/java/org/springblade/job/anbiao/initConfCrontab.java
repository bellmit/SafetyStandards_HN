package org.springblade.job.anbiao;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.anbiao.muban.feign.IMubanClient;
import org.springblade.core.log.logger.BladeLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author th
 * @description: 安标基础资料初始化配置,定时同步(使用哈密众合为配置模板)
 * @projectName SafetyStandards
 * @date 2019/6/2117:59
 */
@Component
@Slf4j
public class initConfCrontab {

	private static final Object KEY = new Object();

	private static boolean taskFlag = false;

	private final static Integer MUBAN_DEPTD_ID=1;

	private final static String MAP_TABLE__STRS=
		" anbiao_anquanhuiyi_map,\n" +
		" anbiao_baoxianxinxi_map,\n" +
		" anbiao_baoxiuxiangmumingxi_map,\n" +
		" anbiao_chelianganquanshebei_map,\n" +
		" anbiao_cheliangbaofei_map,\n" +
		" anbiao_cheliangbaoxian_map,\n" +
		" anbiao_cheliangdengjipingding_map,\n" +
		" anbiao_cheliangguanchejiancha_map,\n" +
		" anbiao_cheliangjingying_map,\n" +
		" anbiao_cheliangrenyuanbangding_map,\n" +
		" anbiao_cheliangweihu_map,\n" +
		" anbiao_cheliangyuejian_map,\n" +
		" anbiao_departmentpost_map,\n" +
		" anbiao_fagui_map,\n" +
		" anbiao_fangzhenmubiao_map,\n" +
		" anbiao_gangweianquanshengchancaozuoliucheng_map,\n" +
		" anbiao_guacheziliao_map,\n" +
		" anbiao_guanchejianchaxinxi_map,\n" +
		" anbiao_guanlizhidu_map,\n" +
		" anbiao_huiyirenyuan_map,\n" +
		" anbiao_jiaoyupeixun_map,\n" +
		" anbiao_jiashiyuan_map,\n" +
		" anbiao_jiashiyuanheimingdan_map,\n" +
		" anbiao_niandujihua_map,\n" +
		" anbiao_organization_map,\n" +
		" anbiao_personnel_map,\n" +
		" anbiao_shigubaogao_map,\n" +
		" anbiao_shiguchuli_map,\n" +
		" anbiao_vehicle_map,\n" +
		" anbiao_weixiucailiaomingxi_map,\n" +
		" anbiao_xincheyanshou_map,\n" +
		" anbiao_xincheyanshoumingxi_map,\n" +
		" anbiao_yayunyuan_map,\n" +
		" anbiao_yingjiduiwu_map,\n" +
		" anbiao_yingjiyanlian_map,\n" +
		" anbiao_yingjiyanlianjihua_map,\n" +
		" anbiao_yingjiyuan_map,\n" +
		" anbiao_yingjizhuangbei_map,\n" +
		" anbiao_zhengjianshenyan_map";

	@Autowired
	private IMubanClient iMubanClient;

//	@Scheduled(cron = "0 13 12 * * ?")
	@Scheduled(cron = "0 13 14 * * ?")
	private void configureTasks() {
		synchronized (KEY) {
			if (initConfCrontab.taskFlag) {
				log.warn("定时任务-初始化模板配置同步已经启动", DateUtil.now());
				return;
			}
			initConfCrontab.taskFlag = true;
		}
		log.warn("定时任务-文初始化模板配置同步开始", DateUtil.now());

		try {
			String[] tables = MAP_TABLE__STRS.split(",");
			iMubanClient.initConf(MUBAN_DEPTD_ID,tables);
		} catch (Exception e) {
			log.error("定时任务-初始化模板配置同步处理-执行出错", e);
		}
		initConfCrontab.taskFlag = false;
		System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	}

}
