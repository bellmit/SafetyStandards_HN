package org.springblade.common.tool;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * Created by LiaoYinhua.
 */
public class RegexUtils {

    //手机号码以1开头的11位数字
    public static boolean checkMobile(String content) {
        if (content == null){
            return false;
        }
        String regex = "^1[3|4|5|6|7|8|9][0-9]{9}$";
        return Pattern.matches(regex, content);
    }

    //密码强度正则，最少6位
    public static boolean checkPassword(String content){
        if (content == null){
            return false;
        }
        //String regex= "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$"; 包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
        String regex= "^[0-9A-Za-z]{6,12}$";
        return Pattern.matches(regex, content);
    }
}
