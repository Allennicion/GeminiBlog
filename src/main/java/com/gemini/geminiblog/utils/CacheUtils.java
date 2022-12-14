package com.gemini.geminiblog.utils;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * 本项目使用的是springboot默认的ConcurrentMapCacheManager
 * @Author zhangWj
 * @Date 2022/9/26 13:50
 **/
public class CacheUtils {

    private static final String PARAM_CACHE = "paramCache";
    private static final String DEFAULT_CACHE = "defaultCache";

    private static Cache getCache(String name) {
        return GeminiUtils.getBean(CacheManager.class).getCache(name);
    }

    /**
     * 获取参数缓存对象
     *
     * @return
     */
    public static Cache getParamCache() {
        return getCache(CacheUtils.PARAM_CACHE);
    }

    public static Cache getDefaultCache() {
        return getCache(CacheUtils.DEFAULT_CACHE);
    }

    public static void putIntoParamCache(Object key, Object value) {
        getParamCache().put(key, value);
    }

    public static void putIntoDefaultCache(Object key, Object value) {
        getDefaultCache().put(key, value);
    }

    public static <T> T fetchFromParamCache(Object key, Class<T> clazz) {
        return getParamCache().get(key, clazz);
    }

    public static <T> T fetchFromDefaultCache(Object key, Class<T> clazz) {
        return getDefaultCache().get(key, clazz);
    }

    public static void removeParamCache(Object key) {
        getParamCache().evict(key);
    }

    public static void removeDefaultCache(Object key) {
        getDefaultCache().evict(key);
    }

    public static void clearAllParamCache() {
        getParamCache().clear();
    }

    public static void clearAllDefaultCache() {
        getDefaultCache().clear();
    }


}
