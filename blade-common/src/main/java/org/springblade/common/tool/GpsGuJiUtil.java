package org.springblade.common.tool;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/11/2611:38
 */
public class GpsGuJiUtil {
	private static final double EARTH_RADIUS = 6378137;
	private static double rad(double d)
	{
		return d * Math.PI / 180.0;
	}

	/**
	 * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
	 * @param lng1
	 * @param lat1
	 * @param lng2
	 * @param lat2
	 * @return
	 */
	public static double GetDistance(double lng1, double lat1, double lng2, double lat2)
	{
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
			Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}


	/**
	 * 获取当前用户一定距离以内的经纬度值
	 * 单位米 return minLat
	 * 最小经度 minLng
	 * 最小纬度 maxLat
	 * 最大经度 maxLng
	 * 最大纬度 minLat
	 */
	public static Map getAround(String latStr, String lngStr, String raidus) {
		Map map = new HashMap();

		Double latitude = Double.parseDouble(latStr);// 传值给经度
		Double longitude = Double.parseDouble(lngStr);// 传值给纬度

		Double degree = (24901 * 1609) / 360.0; // 获取每度
		double raidusMile = Double.parseDouble(raidus);

		Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180))+"").replace("-", ""));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		//获取最小经度
		Double minLat = longitude - radiusLng;
		// 获取最大经度
		Double maxLat = longitude + radiusLng;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		// 获取最小纬度
		Double minLng = latitude - radiusLat;
		// 获取最大纬度
		Double maxLng = latitude + radiusLat;

		map.put("minLat", minLat+"");
		map.put("maxLat", maxLat+"");
		map.put("minLng", minLng+"");
		map.put("maxLng", maxLng+"");

		return map;
	}
	/**
	 * LocalDateTIme 转为 long值
	 */
	public  static  Long DateForLong(LocalDateTime localDateTime){
		ZoneId zone = ZoneId.systemDefault();

		Instant instant = localDateTime.atZone(zone).toInstant();

		return  instant.toEpochMilli();
	}

	public  static boolean isloglat(Double a1,Double a2,Double b1,Double b2, LocalDateTime c1 ,LocalDateTime c2){
		//车辆行驶距离 km
		double speed = GetDistance(a1, a2, b1, b2)/1000;
		//车辆行驶时间
		Long aLong = DateForLong(c1);
		Long aLong1 = DateForLong(c2);
		double time=(double) (aLong1-aLong)/(3600*1000);
		Double quer=160.0;
		boolean falg=true;
		if((speed/time)>160){
			falg=false;
		}
			return  falg;
	}



}
