package org.springblade.gps.util;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import org.springblade.gps.configurationBean.RedisPoolUtil;
import redis.clients.jedis.Jedis;

/**
 * @author th
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/10/911:25
 */
public class RedisOps {
    /**
     * kv字符串存
     * @param key
     * @param value
     * @author corleone
     * @date 2018年11月15日
     */
    public static void set(String key,String value){
        Jedis jedis = RedisPoolUtil.getInstance();
        jedis.set(key, value);
        RedisPoolUtil.closeConn();
    }

    /**
     * kv字符串取
     * @param key
     * @return 字符串
     * @author corleone
     * @date 2018年11月15日
     */
    public static String get(String key){
        Jedis jedis = RedisPoolUtil.getInstance();
        String value = jedis.get(key);
        RedisPoolUtil.closeConn();
        return value;
    }


    /**
     * 删除key
     * @param key
     * @author corleone
     * @date 2018年11月15日
     */
    public static void del(String key){
        Jedis jedis = RedisPoolUtil.getInstance();
        if(jedis==null){
            return;
        }
        jedis.del(key.getBytes());
        RedisPoolUtil.closeConn();
    }


    /**
     * kv对象存(json方式)
     * @param key
     * @param object
     * @author corleone
     * @date 2018年11月15日
     */
    public static void setObjectJson(String key,Object object){
        Jedis jedis = RedisPoolUtil.getInstance();
        if(jedis==null){
            return;
        }
        jedis.set(key, JSON.toJSONString(object));
        RedisPoolUtil.closeConn();
    }
    /**
     * kv对象取(json方式)
     * @param key
     * @param clazz 反序列化对象类型
     * @return 对象
     * @author corleone
     * @date 2018年11月15日
     */
    @SuppressWarnings({ "unchecked" })
    public static <T> Object getObjectJson(String key,Class<?> clazz){
        Jedis jedis = RedisPoolUtil.getInstance();
        if(jedis==null){
            return null;
        }
        String result= jedis.get(key);
        RedisPoolUtil.closeConn();
        if(result==null){
            return null;
        }
        T obj=(T)JSON.parseObject(result,clazz);
        return obj;
    }

}
