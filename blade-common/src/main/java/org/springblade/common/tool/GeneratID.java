/**
 * Copyright (C), 2015-2021
 * FileName: GeneratID
 * Author:   呵呵哒
 * Date:     2021/4/29 15:01
 * Description:
 */
package org.springblade.common.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 * @创建人 hyp
 * @创建时间 2021/4/29
 * @描述 生成id
 */
public class GeneratID {
	/**
	 * 根据传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 *
	 * @param sformat
	 *            yyyyMMddhhmmss
	 * @return
	 */
	public static String getDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getRandomNum(int num){
		String numStr = "";
		for(int i = 0; i < num; i++){
			numStr += (int)(10*(Math.random()));
		}
		return numStr;
	}
	/**
	 * 生成id
	 * @return
	 */
	public static Long getGeneratID(){
		String sformat = "MMddhhmmssSSS";
		int num = 3;
		String idStr = getDate(sformat) + getRandomNum(num);
		Long id = Long.valueOf(idStr);
		return id;
	}


	public static void main(String[] args){
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
//		System.out.println("UTC时间---》"+calendar.getTime().getTime());
//		System.out.println(calendar.get(Calendar.YEAR)+
//			"年"+calendar.get(Calendar.MONTH)+
//			"月"+calendar.get(Calendar.DATE)+
//			"日"+calendar.get(Calendar.HOUR_OF_DAY)+
//			"时"+calendar.get(Calendar.MINUTE)+
//			"分"+calendar.get(Calendar.SECOND)+"秒");
//		calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//		System.out.println("北京时间---》"+calendar.getTime().getTime());
//		System.out.println(calendar.get(Calendar.YEAR)+
//			"年"+calendar.get(Calendar.MONTH)+
//			"月"+calendar.get(Calendar.DATE)+
//			"日"+calendar.get(Calendar.HOUR_OF_DAY)+
//			"时"+calendar.get(Calendar.MINUTE)+
//			"分"+calendar.get(Calendar.SECOND)+"秒");
//		calendar.setTimeZone(TimeZone.getTimeZone("GMT+6"));
//		System.out.println("东六区---》"+calendar.getTime().getTime());
//		System.out.println(calendar.get(Calendar.YEAR)+
//			"年"+calendar.get(Calendar.MONTH)+
//			"月"+calendar.get(Calendar.DATE)+
//			"日"+calendar.get(Calendar.HOUR_OF_DAY)+
//			"时"+calendar.get(Calendar.MINUTE)+
//			"分"+calendar.get(Calendar.SECOND)+"秒");


		for(int i = 0; i < 1; i++){
			System.out.println(getGeneratID());
			System.out.println("++++++++++++++++++");
		}
		String zongduannum = null;
		zongduannum = getGeneratID()+"1";
//		System.out.println(zongduannum);
//		System.out.println(zongduannum.substring(4, 15));

//		Random r = new Random();
//		int n = r.nextInt();
//		System.out.println(n);
//		int num = r.nextInt(4);
//		System.out.println(num);

		zongduannum = zongduannum.substring(4, 15);
		Random p = new Random();
		int n = p.nextInt();
		int num = p.nextInt(4);
		zongduannum = num+zongduannum;
		System.out.println(zongduannum);
	}
}
