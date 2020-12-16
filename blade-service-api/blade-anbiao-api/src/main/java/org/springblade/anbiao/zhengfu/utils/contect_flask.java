/**
 * Copyright (C), 2015-2020,
 * FileName: contect_flask
 * Author:   呵呵哒
 * Date:     2020/5/15 15:51
 * Description:
 */
package org.springblade.anbiao.zhengfu.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.configurationprocessor.json.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * @创建人 hyp
 * @创建时间 2020/6/15
 * @描述
 */
/**
 *
 */
public class contect_flask {

    /**
     * @param args
     */
    public static void main(String[] args) throws JSONException {
        // TODO Auto-generated method stub
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();

        jsonObject2.put("channel", "channel");
        jsonObject1.put("item", jsonObject2);
        jsonObject1.put("requestCommand", "control");
		jsonObject1.put("dept","5243,5217");
		jsonObject1.put("zaixian",1);
		jsonObject1.put("zhuangtai",1);
        String result = contect_flask.post(jsonObject1, "http://47.114.159.85:40002/GetList");

        System.out.println(result.toString());

    }

    public static String post(JSONObject json, String url){
        String result = "";
        HttpPost post = new HttpPost(url);
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();

            post.setHeader("Content-Type","application/json;charset=utf-8");
            post.addHeader("Authorization", "Basic YWRtaW46");
            StringEntity postingString = new StringEntity(json.toString(),"utf-8");
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);

            InputStream in = response.getEntity().getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber= new StringBuilder();
            String line = null;
            while((line = br.readLine())!=null){
                strber.append(line+'\n');
            }
            br.close();
            in.close();
            result = strber.toString();
            if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK){
                result = "服务器异常";
            }
        } catch (Exception e){
            System.out.println("请求异常");
            throw new RuntimeException(e);
        } finally{
            post.abort();
        }
        return result;
    }
}

