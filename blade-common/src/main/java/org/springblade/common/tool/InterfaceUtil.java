package org.springblade.common.tool;

import java.io.*;
import java.net.*;

/**
 * 接口调用工具类
 *
 * @author hyp
 */
public class InterfaceUtil {

    /**
     * 转换字符串形式
     * @param rd
     * @return
     */
    private static String readToJson(BufferedReader rd) {
        StringBuilder sb = new StringBuilder();
        try {
            int len;

            while ((len = rd.read()) != -1) {
                sb.append((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getUrlData(String url) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        HttpURLConnection connect = (HttpURLConnection) (new URL(url).openConnection());
        connect.setRequestMethod("GET");
        connect.setDoOutput(true);
        connect.setConnectTimeout(1000 * 10);
        connect.setReadTimeout(1000 * 80);
        //采用通用的URL百分号编码的数据MIME类型来传参和设置请求头
        connect.setRequestProperty("ContentType",  "application/x-www-form-urlencoded");
        connect.setDoInput(true);
        // 连接
        connect.connect();
        // 接收数据
        int responseCode = connect.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream in = connect.getInputStream();
            byte[] data = new byte[1024];
            int len;
            while ((len = in.read(data, 0, data.length)) != -1) {
                outStream.write(data, 0, len);
            }
            in.close();
        }
        // 关闭连接
        connect.disconnect();
        return outStream.toString("UTF-8");
    }


}
