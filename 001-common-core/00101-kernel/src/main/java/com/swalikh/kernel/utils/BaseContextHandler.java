package com.swalikh.kernel.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * Copyright @2018 nlelpct.
 *
 * @author: 黄磊
 * date:  2019/4/9  14:22
 * use to： threadLocal工具类，用于线程传输缓存数据
 * modify：
 */
public class BaseContextHandler {


    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
}
