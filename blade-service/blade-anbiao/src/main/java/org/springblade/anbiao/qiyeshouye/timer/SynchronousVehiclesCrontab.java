package org.springblade.anbiao.qiyeshouye.timer;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.hbis.infmgr.common.sign.SignUtil;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springblade.anbiao.qiyeshouye.springTemplate.basicString.StringProducer;
import org.springblade.common.tool.SslUtils;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author hyp
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/417:09
 */
@Component
@Slf4j
@AllArgsConstructor
public class SynchronousVehiclesCrontab {

	private static final Object KEY = new Object();
	private static boolean taskFlag = false;
	@Autowired
	private StringProducer producer;

	/**
	 * 获取https连接（不验证证书）
	 *
	 * @return
	 */
	private static CloseableHttpClient getHttpsClient() {
		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
		ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
		registryBuilder.register("http", plainSF);
		// 指定信任密钥存储对象和连接套接字工厂
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			// 信任任何链接
			TrustStrategy anyTrustStrategy = new TrustStrategy() {

				@Override
				public boolean isTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
					// TODO Auto-generated method stub
					return true;
				}
			};
			SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
			LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			registryBuilder.register("https", sslSF);
		} catch (KeyStoreException e) {
			throw new RuntimeException(e);
		} catch (KeyManagementException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		Registry<ConnectionSocketFactory> registry = registryBuilder.build();
		// 设置连接管理器
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
		// 构建客户端
		return HttpClientBuilder.create().setConnectionManager(connManager).build();
	}
	//	测试环境
//	private static final int account=326;
//	private static final String key="a2ad54a95e334a9fa86b4939416bd31e";
//	private static final String url_domain = "https://testinterfacem.hbisscm.com/inf/datac/yamei/getCarInfo";
	//正式环境
	private static final int account=267;
	private static final String key="42e1586bcf5b404688817bf57c06816d";
	private static final String url_domain = "https://webinf.hbisscm.com/inf/datac/yamei/getCarInfo";

	private void fillMethod(HttpRequestBase requestBase){
		//设置account值
		requestBase.addHeader("haccid",String.valueOf(account));
		//设置key值
		requestBase.addHeader("hacckey",key);
		System.out.println(requestBase.getAllHeaders());
	}

	public R getQYVehicleList(@ApiParam(value = "企业ID", required = true) @RequestParam String biz_ln,
							  @ApiParam(value = "在线状态（1:全部;2:上线;3:未上线;）") @RequestParam String corp_name) throws Exception{
		long timestamp = System.currentTimeMillis();
		CloseableHttpClient client = HttpClientBuilder.create().build();
//		CloseableHttpClient client = getHttpsClient();
		HttpPost post = new HttpPost(url_domain);
		JSONObject object = new JSONObject();
		object.put("biz_ln",biz_ln);
		object.put("corp_name",corp_name);
		String data = object.toJSONString();
		fillMethod(post);

		HttpEntity entity = EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON).setText(data).build();
		post.setEntity(entity);
		HttpResponse response = null;
		String carInfo = null;
		try {
			SslUtils.ignoreSsl();
			response = getHttpsClient().execute(post);
			carInfo = EntityUtils.toString(response.getEntity());
			System.out.println(carInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			post.releaseConnection();
		}
		JSONObject jsonObject = JSONObject.parseObject(carInfo);
		R r = new R();
		producer.batchsend("时间："+DateUtil.now()+"根据企业名称查询车辆中："+carInfo);
		List<Map<String,Object>> mapListJson = (List)jsonObject.getJSONArray("data");
		for(int i = 0;i<mapListJson.size();i++){
			getQYVehicleAddress(String.valueOf(mapListJson.get(i).get("vehicle_no")));
			producer.batchsend("调用轨迹开始时间："+DateUtil.now()+"++++++++++++++++++次数："+String.valueOf(mapListJson.get(i).get("vehicle_no"))+"++++++++++++++++++次数："+i);
		}
		return r;
	}

	//	测试环境
//	private static final int account_address=326;
//	private static final String key_address="a2ad54a95e334a9fa86b4939416bd31e";
//	private static final String url_domain_address="https://testinterfacem.hbisscm.com/inf/external/prod-api/lbs/gpsLatest/getLatePointToOut";
//	public static final String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIwuDX/GI5Q0lwDp1HKf0om4uRkb bPuGkm3TiOwNMzBOxdHOWp9hr7zN5GfzDDhO60zJN9U7g/v7OuTDxQRz/gGp8JErxoXkbuNdHbxa ri9LDVZ8iGvwbaQ+J2WlmdsP5X+cbm+rXuStc5knj5YiGV5jGL/jKI1T/QrLWHHLcRhRAgMBAAEC gYBYPFS67NlQXJoANS9Ix1ka32+DYkQDPv3Eq7Yv/08NRUg3fBCG6lJYIbF3zQEQIHzz5GSEj+XQ Ip87iA7ncqubKazthFyOH5dXeZmFsEaCn7asNcRF6gYB2Yx6VbYHqzx6lBMxidszGk6D6GK0tfie 45iTGTUrXggkwYjsAzfrUQJBAMfoSyzO8uwBxoikFg3tdS4CoYNEeEVZJQTObEr/sQXf8mMi2ZVt SWe9WioNJNW19tBBu42pgae6nIL3Zfiwi4MCQQCzg2zvcJiHpWRp7bOkuXXvgiGMBCiaAJb1JOu8 wA94e7kOz+IQAak9A4gAbCUJrjdEQOUx36Djni8sEgZcfuCbAkAqJiZDilbZv/4WLVKhGSIN02wu ey9In+UYQFXA8mxmqrM2h9CMmwBRKTFrkF3l2XnyqwlacxTtQoFhc7xCVSb1AkA/zhDkMkMkw5aj SAe4HutaTAicecXspxUA4TShDCrzihZGu4EAa3a55w1qCQZJIJEoQ2Czj2biQJFHushkC/zNAkAk zEJ/ANPiZBT5ZNU4Y3bMXSr63BsRnWxwNZxgb+TOb4W0ON6oHYif5E132H6tQE3Xa0jB1TAx2FVi lJ1MuzQN";
	//正式环境
	private static final int account_address=267;
	private static final String key_address="42e1586bcf5b404688817bf57c06816d";
	private static final String url_domain_address="https://webinf.hbisscm.com/inf/external/prod-api/lbs/gpsLatest/getLatePointToOut";
	public static final String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI+n9IFUowGvJDEq6Y/4BuU6ri3m+fsuawjvs9doXSB4QGgHKscbp5oKEy0KCTkuRRyPiwrujwbdXC9ZAq4pxQB2G/Mo/dxJUgVituJF4Cl+KQD41lw8UqzQbNDB6uAkzssJVXpUGl75IfTm3z5Cv9gt0XsdBrCRb5n0NtnKnXPDAgMBAAECgYA0LrBUYmgr7nDZI1tgHppynhQzPFnF8iCTSG8tag2aA9RxdVkGpncFL2+zxpd/G92i+ElrmSh/N92KnWyp0yZp7PPSOJeDkqOCvRFifspbsu4CdSNvgxQT/c6W5v1uT9VQGCmEkGfF/v0ITTmjpFDtF5wp5vfCQI4ZW/Gfu9/S4QJBAOUnsynKoT6udsxT9Z9nMqJ8C346+LxCgEWtCcYiorORP5bAlN8v/CH/qNWHmK00s9RhTz9laxshHK7ciU6FQqkCQQCgfCmrAJnX9NFcbFlpBG7gN35GFmydH7DP+XkyUiFMH3/9aidbBG1OYVeixkq9AMrqryZOAjZs3HWMo3a623KLAkBztIb3bBPctXTQmPglo5LijiWzeA1N6XohNE0CGUzzxDxKXzUMOItjk1Zpcsz5b+n5K6U7Cnd5PE/iTwKZfhn5AkBG+uOLCHcCtvsqP5nEAvvvG1w0L5LWY7/WHGboRL8JZh07vgmuDeUyd4dFLSK9OW6GIfV1JzFfMJqlG19WAd1FAkEAhXfpYJS7zrov+qIrA3bOlJGvpV+o90GU9BVr6ojQcD5SZoD9D8QnRwtWeyd6RQCoDn2j7G/Gn9mFPbDkUPWcXw==";

	public static final String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCMz/+3WqbeU50pJLY9io0nu9Uz+1hVCyKoJKEpa+P6CnoOzValXKYJfSOfAiQL8vUJCwv+uSgh9DcCYmBYENZNzJfu2Jyilhb7z8A66hHRo7ujsllQZ5yVLt8J9Eqx4HPD6y3q+BfkGO5KXW7kq3NJHbbs/uJydpUz/Qchyu8NkwIDAQAB";

	private void fillMethod_address(HttpRequestBase requestBase, long timestamp, String sign){
		//设置account值
		requestBase.addHeader("haccid",String.valueOf(account_address));
		//设置key值
		requestBase.addHeader("hacckey",key_address);
		//设置时间戳,nginx,underscores_in_headers on;放到http配置里，否则nginx会忽略包含"_"的头信息
		requestBase.addHeader("hacctimestamp",String.valueOf(timestamp));
		requestBase.addHeader("haccsign",sign);
		System.out.println(requestBase.getAllHeaders());
	}

	public R getQYVehicleAddress(@ApiParam(value = "车牌号") @RequestParam String viclN) throws Exception {
		R r = new R();
		long timestamp = System.currentTimeMillis();
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url_domain_address);

		JSONObject object = new JSONObject();
		object.put("vclN",viclN);
		String data = object.toJSONString();
		/**
		 * 根据私钥，生成签名，并将签名放到header头
		 */
		String sign = SignUtil.sign(data,private_key,timestamp);
		fillMethod_address(post,timestamp,sign);

		/**
		 * 发送带签名的数据。
		 */
		HttpEntity entity = EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON).setText(data).build();
		post.setEntity(entity);
		HttpResponse response = null;
		String carInfoAddress = null;
		try {
			response = getHttpsClient().execute(post);
			carInfoAddress = EntityUtils.toString(response.getEntity());
			System.out.println("response is "+carInfoAddress);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			post.releaseConnection();
		}
		JSONObject jsonObject = JSONObject.parseObject(carInfoAddress);
		String result = jsonObject.getString("result");
		if(result != null){
			JSONObject jsonObject1 = JSONObject.parseObject(result);
			jsonObject1.put("vclN",viclN);
			String status = jsonObject.getString("status");
			if(status.equals("1001")){
				producer.send(jsonObject1.toJSONString());
				r.setData(jsonObject1);
				r.setCode(200);
				r.setMsg("获取成功，已传输kafka");
			}else{
				r.setCode(200);
				producer.errorsend("response is "+carInfoAddress);
				r.setMsg("获取成功，暂无数据");
			}
		}
		return r;
	}

	@Scheduled(cron = "0 */3 * * * ?")
//	@Scheduled(cron = " 0 0/3 1-24 * * ? ")
	private void configureTasks() {
		synchronized (KEY) {
			if (SynchronousVehiclesCrontab.taskFlag) {
				System.out.println("定时任务-执行向kafka同步亚美车辆数据已经启动"+DateUtil.now());
				log.info("定时任务-执行向kafka同步亚美车辆数据已经启动", DateUtil.now());
				return;
			}
			SynchronousVehiclesCrontab.taskFlag = true;
		}
		log.warn("定时任务-执行向kafka同步亚美车辆数据更新开始", DateUtil.now());

		try {
			System.out.println("执行向kafka同步亚美车辆数据");
			producer.batchsend("再次调用轨迹开始时间："+DateUtil.now());
//			String viclN = "陕YH0009";
//			getQYVehicleAddress(viclN);
			String biz_ln = "91130803398870216B,911304007589167410";
			String corp_name = "承德鼎诚物流有限公司,邯郸市邯钢集团汇达汽车运输有限公司 ";
			List<String> biz_lnList = Arrays.asList(biz_ln.split(","));
			List<String> corp_nameList = Arrays.asList(corp_name.split(","));
			for (int i=0;i<biz_lnList.size();i++){
				biz_ln = biz_lnList.get(i);
				corp_name = corp_nameList.get(i);
				producer.batchsend("根据企业名称查询车辆开始："+DateUtil.now());
				getQYVehicleList(biz_ln,corp_name);
			}
			System.out.println("执行完成");
			producer.batchsend("再次调用轨迹结束时间："+DateUtil.now());
		} catch (Exception e) {
			log.error("定时任务-执行向kafka同步亚美车辆数据-执行出错", e.getMessage());
		}
		SynchronousVehiclesCrontab.taskFlag = false;
		System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	}


}
