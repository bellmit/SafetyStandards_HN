package org.springblade.alarm.tool;


import com.alibaba.fastjson.JSONObject;
import org.springblade.common.tool.InterfaceUtil;

import java.io.IOException;

public class Json {

         public  static  String getjson(String x,String y){


	String url="https://restapi.amap.com/v3/geocode/regeo?output=JSON&location="+x+","+y+"&key=d3e99164851fccb3052b501e1d53af67&radius=1000&extensions=all";
			 String str=null;
				try {
			String data=InterfaceUtil.getUrlData(url);
					JSONObject json=JSONObject.parseObject(data);;

					 str = json.getJSONObject("regeocode").getString("formatted_address");

		} catch (IOException e) {
			e.printStackTrace();
		}


	 return  str;
    }
}
