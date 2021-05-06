/**
 * Copyright (C), 2015-2021
 * FileName: YaMeiController
 * Author:   呵呵哒
 * Date:     2021/4/23 20:58
 * Description:
 */
package org.springblade.anbiao.qiyeshouye.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.hbis.infmgr.common.sign.SignUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
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
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.cheliangguanli.service.IVehicleService;
import org.springblade.anbiao.qiyeshouye.springTemplate.basicJsonBean.JsonBean;
import org.springblade.anbiao.qiyeshouye.springTemplate.basicJsonBean.JsonProducer;
import org.springblade.anbiao.qiyeshouye.springTemplate.basicString.StringProducer;
import org.springblade.common.tool.GeneratID;
import org.springblade.common.tool.SslUtils;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springblade.system.entity.Dept;
import org.springblade.system.feign.ISysClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @创建人 hyp
 * @创建时间 2021/4/23
 * @描述
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/yaMeiApi")
@Api(value = "亚美接口调用", tags = "亚美接口调用")
public class YaMeiController {

	private IVehicleService vehicleService;

	private ISysClient iSysClient;

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

	@GetMapping(value = "/getQYVehicleList")
	@ApiLog("企业-获取统计车辆数据")
	@ApiOperation(value = "企业-获取统计车辆数据", notes = "传入相关参数",position = 1)
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
		List<Map<String,Object>> mapListJson = (List)jsonObject.getJSONArray("data");
		for(int i = 0;i<mapListJson.size();i++){
			Vehicle vehicle=new Vehicle();
			Dept dept;
			String id= IdUtil.simpleUUID();
			vehicle.setId(id);
			String deptName = mapListJson.get(i).get("corp_name").toString();
			dept = iSysClient.getDeptByName(deptName);
			vehicle.setDeptId(Integer.valueOf(dept.getId()));
			vehicle.setCheliangpaizhao(String.valueOf(mapListJson.get(i).get("vehicle_no")));
			vehicle.setCheliangzhuangtai("0");
			vehicle.setIsdel(0);
			LocalDateTime localDateTime = LocalDateTime.now();
			vehicle.setCaozuoshijian(localDateTime);
			vehicle.setCreatetime(localDateTime);
			vehicle.setCaozuorenid(1);
			String zongduannum = null;
			zongduannum = GeneratID.getGeneratID()+"1";
			zongduannum = zongduannum.substring(4, 15);
			Random p = new Random();
			int n = p.nextInt();
			int num = p.nextInt(4);
			zongduannum = num+zongduannum;
			vehicle.setZongduanid(zongduannum);
			vehicle.setCaozuoren("XF");
			String plate_type = String.valueOf(mapListJson.get(i).get("plate_type"));
			if(plate_type.equals("黄牌")){
				plate_type = "黄色";
			}
			if(plate_type.equals("蓝牌")){
				plate_type = "蓝色";
			}
			if(plate_type.equals("绿牌")){
				plate_type = "绿色";
			}
			vehicle.setChepaiyanse(plate_type);
			vehicle.setXinghao(mapListJson.get(i).get("vehicle_type").toString());
			boolean isDataValidity = vehicleService.insertSelective(vehicle);
			if(isDataValidity==true){
				r.setMsg("新增成功");
				r.setCode(200);
			}else{
				r.setMsg("新增失败");
				r.setCode(500);
			}
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

	private void fillMethod_address(HttpRequestBase requestBase,long timestamp,String sign){
		//设置account值
		requestBase.addHeader("haccid",String.valueOf(account_address));
		//设置key值
		requestBase.addHeader("hacckey",key_address);
		//设置时间戳,nginx,underscores_in_headers on;放到http配置里，否则nginx会忽略包含"_"的头信息
		requestBase.addHeader("hacctimestamp",String.valueOf(timestamp));
		requestBase.addHeader("haccsign",sign);
		System.out.println(requestBase.getAllHeaders());
	}

	@GetMapping(value = "/getQYVehicleAddress")
	@ApiLog("企业-获取统计车辆轨迹点数据")
	@ApiOperation(value = "企业-获取统计车辆轨迹点数据", notes = "传入相关参数",position = 1)
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
		String status = jsonObject.getString("status");
		if(status.equals("1001")){
			producer.send(carInfoAddress);
			r.setData(jsonObject);
			r.setCode(200);
			r.setMsg("获取成功，已传输kafka");
		}else{
			producer.errorsend("response is "+carInfoAddress);
			r.setCode(200);
			r.setMsg("获取成功，暂无数据");
		}
		return r;
	}


	@Autowired
	private StringProducer producer;

	@Autowired
	private JsonProducer jsonProducer;

	@GetMapping("/string")
	public String string() {
		for (int i = 0; i < 5; i++) {
			producer.send("Message【" + i + "】：Hello,My name is CJWDDSG ZL");
		}
		return "success";
	}

	@GetMapping("/json")
	public String json() {
		JsonBean json = new JsonBean();
		json.setMessageId("1");
		json.setMessageContent("this is message");
		jsonProducer.send(json);

		return "success";
	}
}
