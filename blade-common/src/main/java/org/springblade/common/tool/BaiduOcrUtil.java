package org.springblade.common.tool;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Base64Util;
import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BaiduOcrUtil {

    public static String APP_ID = "20502782";
    public static String API_KEY = "1BrHzwUIGX9Au9vIgkZo9YgK";
    public static String SECRET_KEY = "fZZ4plC0URbEqdCEWwVCtOGTXsPZ8zik";

    public static String FACE_APP_ID = "17694413";
    public static String FACE_API_KEY = "Xl2Xtg25Z7Bn1xavIFYOwxRM";
    public static String FACE_SECRET_KEY = "FvdpqxOlnsBdQ9my4kDt3NOokijlzj8s";

    private static final AipOcr aipOcr;
    private static final AipFace aipFace;

    static {
        aipOcr = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        aipOcr.setConnectionTimeoutInMillis(2000);
        aipOcr.setSocketTimeoutInMillis(60000);

        aipFace = new AipFace(FACE_APP_ID, FACE_API_KEY, FACE_SECRET_KEY);

        // 可选：设置网络连接参数
        aipFace.setConnectionTimeoutInMillis(2000);
        aipFace.setSocketTimeoutInMillis(60000);
    }

    public static IdCard idCard(byte[] file) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("detect_direction", "false");
        options.put("detect_risk", "false");
        String idCardSide = "front";

        // 参数为本地图片二进制数组
        JSONObject idcard = aipOcr.idcard(file, idCardSide, options);

        JSONObject words_result = idcard.getJSONObject("words_result");

        JSONObject zhuzhi = words_result.getJSONObject("住址");
        JSONObject card = words_result.getJSONObject("公民身份号码");
        JSONObject chusheng = words_result.getJSONObject("出生");
        JSONObject xingming = words_result.getJSONObject("姓名");
        JSONObject xingbie = words_result.getJSONObject("性别");
        JSONObject mingzhu = words_result.getJSONObject("民族");

        return IdCard.builder()
                .code(200)
                .errorMsg(msgConverter(idcard.getString("image_status")))
                .address(zhuzhi.getString("words"))
                .cardNo(card.getString("words"))
                .birthday(chusheng.getString("words"))
                .name(xingming.getString("words"))
                .gender(xingbie.getString("words"))
                .national(mingzhu.getString("words"))
                .build();
    }

    public static DriverLicence driverLicence(byte[] file) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");

        // 参数为本地图片二进制数组
        JSONObject driverLicence = aipOcr.drivingLicense(file, options);

        JSONObject words_result = driverLicence.getJSONObject("words_result");

        JSONObject zh = words_result.getJSONObject("证号");
        JSONObject xm = words_result.getJSONObject("姓名");
        JSONObject xb = words_result.getJSONObject("性别");
        JSONObject gj = words_result.getJSONObject("国籍");
        JSONObject zz = words_result.getJSONObject("住址");
        JSONObject csrq = words_result.getJSONObject("出生日期");
        JSONObject cclzrq = words_result.getJSONObject("初次领证日期");
        JSONObject zjcx = words_result.getJSONObject("准驾车型");
        JSONObject yxqx = words_result.getJSONObject("有效期限");

        JSONObject zhi = words_result.getJSONObject("至");


        DriverLicence build = DriverLicence.builder()
                .code(200)
                .errorMsg("成功")
                .cardNo(zh.getString("words"))
                .validTerm(zhi.getString("words"))
                .quasiDrivingType(zjcx.getString("words"))
                .startDate(yxqx.getString("words"))
                .address(zz.getString("words"))
                .birthday(csrq.getString("words"))
                .name(xm.getString("words"))
                .gender(xb.getString("words"))
                .nationality(gj.getString("words"))
                .firstDate(cclzrq.getString("words"))
                .build();


        return build;
    }

    public static void custom(byte[] file) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("templateSign", "");

        // 参数为本地图片二进制数组
        JSONObject custom = aipOcr.custom(file, options);
    }

    public static Double face(byte[] bytes, String url) {
        String encode = Base64Util.encode(bytes);
        MatchRequest req1 = new MatchRequest(encode, "BASE64");
        MatchRequest req2 = new MatchRequest(url, "URL");
        ArrayList<MatchRequest> requests = new ArrayList<>();
        requests.add(req1);
        requests.add(req2);
        JSONObject res = aipFace.match(requests);
        return res.getJSONObject("result").getDouble("score");
    }

    @Data
    @Builder
    public static class IdCard {

        private Integer code;

        private String errorMsg;

        private String address;

        private String cardNo;

        private String birthday;

        private String name;

        private String gender;

        private String national;
    }

    @Data
    @Builder
    public static class DriverLicence{
        private Integer code;
        private String errorMsg;
        private String cardNo;
        private String validTerm;
        private String quasiDrivingType;
        // 有效起始时间
        private String startDate;
        private String address;
        private String name;
        private String nationality;
        private String birthday;
        private String gender;
        // 初次领证时间
        private String firstDate;
    }

    public static String msgConverter(String msg){
        switch (msg) {
            case "normal": return "识别正常";
            case "reversed_side": return "未摆正身份证";
            case "non_idcard": return "上传的图片中不包含身份证";
            case "blurred": return "身份证模糊";
            case "over_exposure": return "身份证关键字段反光或过曝";
            default: return "未知状态";
        }
    }



}
