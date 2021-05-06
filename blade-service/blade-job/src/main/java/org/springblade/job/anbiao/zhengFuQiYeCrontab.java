package org.springblade.job.anbiao;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.anbiao.guanlijigouherenyuan.feign.IOrganizationsClient;
import org.springblade.anbiao.guanlijigouherenyuan.vo.OrganizationsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hyp
 * @description: 政府企业同步更新
 * @projectName SafetyStandards
 */
@Component
@Slf4j
@Configuration
@AllArgsConstructor
public class zhengFuQiYeCrontab {

	private static final Object KEY = new Object();

	private static boolean taskFlag = false;

	@Autowired
//	private IOrganizationsClient iOrganizationsClient;

	/**
	 * 格式: [秒] [分] [小时] [日] [月] [周] [年]
	 * 0 0 12 * * ?    每天12点触发
	 * 0 15 10 ? * *    每天10点15分触发
	 * 0 15 10 * * ?    每天10点15分触发
	 * 0 15 10 * * ? *    每天10点15分触发
	 * 0 15 10 * * ? 2005    2005年每天10点15分触发
	 * 0 * 14 * * ?    每天下午的 2点到2点59分每分触发
	 * 0 0/5 14 * * ?    每天下午的 2点到2点59分(整点开始，每隔5分触发)
	 * 0 0/5 14,18 * * ?    每天下午的 2点到2点59分、18点到18点59分(整点开始，每隔5分触发)
	 * 0 0-5 14 * * ?    每天下午的 2点到2点05分每分触发
	 * 0 10,44 14 ? 3 WED    3月分每周三下午的 2点10分和2点44分触发
	 * 0 15 10 ? * MON-FRI    从周一到周五每天上午的10点15分触发
	 * 0 15 10 15 * ?    每月15号上午10点15分触发
	 * 0 15 10 L * ?    每月最后一天的10点15分触发
	 * 0 15 10 ? * 6L    每月最后一周的星期五的10点15分触发
	 * 0 15 10 ? * 6L 2002-2005    从2002年到2005年每月最后一周的星期五的10点15分触发
	 * 0 15 10 ? * 6#3    每月的第三周的星期五开始触发
	 * 0 0 12 1/5 * ?    每月的第一个中午开始每隔5天触发一次
	 * 0 11 11 11 11 ?    每年的11月11号 11点11分触发(光棍节)
	 */

	/**
	 *  通过遍历两个List中按组织编号关联匹配
//	 * @param oneList
//	 * @param twoList
	 */
//	public static List<OrganizationsVO> compareListHitData(List<OrganizationsVO> oneList, List<OrganizationsVO> twoList) {
//		List<OrganizationsVO> list=oneList.stream().map(person -> twoList.stream()
//			.filter(identity -> Objects.equals(person.getQiyeid(),identity.getQiyeid()))
//			.findFirst().map(i -> {
//				person.setQiyemingcheng(i.getQiyemingcheng());
//				person.setQiyeid(i.getQiyeid());
//				person.setJigouleixing(i.getJigouleixing());
//				person.setProvince(i.getProvince());
//				person.setCity(i.getCity());
//				person.setCountry(i.getCountry());
//				person.setYunguanid(i.getYunguanid());
//				person.setYunguanmingcheng(i.getYunguanmingcheng());
//				person.setAreaname(i.getAreaname());
//				return person;
//			}).orElse(null))
//			.filter(Objects::nonNull).collect(Collectors.toList());
//		return list;
//	}

	@Scheduled(cron = "0/10 * * * * ?")
	private void configureTasks() {
		synchronized (KEY) {
			if (zhengFuQiYeCrontab.taskFlag) {
				System.out.println("定时任务-政府企业同步更新已经启动"+DateUtil.now());
				log.info("定时任务-政府企业同步更新已经启动", DateUtil.now());
				return;
			}
			zhengFuQiYeCrontab.taskFlag = true;
		}
		log.warn("定时任务-政府企业同步更新开始", DateUtil.now());

		try {
//			System.out.println("执行政府企业同步更新");
//			List<OrganizationsVO> organization_new = iOrganizationsClient.getZFQY();
//			List<OrganizationsVO> organization_old = iOrganizationsClient.getZFQYOrderById();
//			if(organization_new.size() < 0 || organization_new == null){
//				return;
//			}else{
//				log.info("数据对比开始");
//				System.out.println(organization_new);
//				System.out.println(organization_old);
//				List<OrganizationsVO> newList = compareListHitData(organization_old,organization_new);
//				log.info("数据对比结束");
//				if(newList != null && newList.size() >0){
//					log.info("有新数据需要新增");
//					for(int i = 0; i <= newList.size();i++){
//						boolean ss = iOrganizationsClient.insertSelective(newList.get(i));
//					}
//				}else{
//					return;
//				}
//				System.out.println("执行政府企业同步更新完成");
//			}

		} catch (Exception e) {
			log.error("定时任务-政府企业同步更新-执行出错", e.getMessage());
		}
		zhengFuQiYeCrontab.taskFlag = false;
		System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	}


}
