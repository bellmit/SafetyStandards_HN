package org.springblade.common.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/12/1013:49
 */
public class NumberForDateUtil {


	/**
	 * 将秒数转换为日时分秒，
	 * @param second
	 * @return
	 */
	public static String secondToTime(long second){
		long days = second / 86400;            //转换天数
		second = second % 86400;            //剩余秒数
		long hours = second / 3600;            //转换小时
		second = second % 3600;                //剩余秒数
		long minutes = second /60;            //转换分钟
		second = second % 60;                //剩余秒数
		if(days>0){
			return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
		}else{
			return hours + "小时" + minutes + "分" + second + "秒";
		}
	}

	/**
	 * 将日期转换为日时分秒
	 * @param date
	 * @return
	 */
	public static String dateToTime(String date, String dateStyle){
		SimpleDateFormat format = new SimpleDateFormat(dateStyle);
		try {
			Date oldDate = format.parse(date);
			long time = oldDate.getTime();                    //输入日期转换为毫秒数
			long nowTime = System.currentTimeMillis();        //当前时间毫秒数
			long second = nowTime - time;                    //二者相差多少毫秒
			second = second / 1000;                            //毫秒转换为妙
			long days = second / 86400;
			second = second % 86400;
			long hours = second / 3600;
			second = second % 3600;
			long minutes = second /60;
			second = second % 60;
			if(days>0){
				return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
			}else{
				return hours + "小时" + minutes + "分" + second + "秒";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


}
