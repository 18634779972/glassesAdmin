package com.xjt.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON工具类
 *
 * @author guoliang.li
 * @date 2018-11-23 16:35:09
 */
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * get Instance of ObjectMapper
     *
     * @return ObjectMapper
     */
    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    /**
     * JavaBean convert to Json
     *
     * @param bean Java对象
     * @return 将Java对象转换为JSON字符串
     */
    public static String bean2Json(Object bean) {
        try {
            return objectMapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            logger.error("错误信息：{}", e.getMessage());
            return null;
        }
    }

    /**
     * Json convert to JavaBean
     *
     * @param json  json字符串
     * @param clazz Java对象
     * @return 将json字符串转换为Java对象
     */
    public static <T> T json2Bean(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("错误信息：{}", e.getMessage());
            return null;
        }
    }

    /**
     * Json convert to Map
     *
     * @param json json字符串
     * @return 将json字符串转换为Map对象
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, Object> json2Map(String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (IOException e) {
            logger.error("错误信息：{}", e.getMessage());
            return null;
        }
    }

    /**
     * Json convert to Map with javaBean
     *
     * @param json  json字符串
     * @param clazz Java对象
     * @return 将json字符串转换为Map形式的Java对象
     */
    public static <T> Map<String, T> json2Map(String json, Class<T> clazz) {
        Map<String, Map<String, Object>> map;
        try {
            map = objectMapper.readValue(json, new TypeReference<Map<String, T>>() {
            });
            Map<String, T> result = new HashMap<>(map.size());
            for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
                String key = entry.getKey();
                Map<String, Object> value = entry.getValue();
                result.put(key, map2Bean(value, clazz));
            }
            return result;
        } catch (IOException e) {
            logger.error("错误信息：{}", e.getMessage());
            return null;
        }
    }

    /**
     * Json convert to List with JavaBean
     *
     * @param json  json字符串
     * @param clazz Java对象
     * @return 将json字符串转换为Java对象集合
     */
    public static <T> List<T> json2List(String json, Class<T> clazz) {
        List<Map<String, Object>> list;
        try {
            list = objectMapper.readValue(json, new TypeReference<List<T>>() {
            });
            List<T> result = new ArrayList<>();
            for (Map<String, Object> map : list) {
                result.add(map2Bean(map, clazz));
            }
            return result;
        } catch (IOException e) {
            logger.error("错误信息：{}", e.getMessage());
            return null;
        }
    }

    /**
     * Map convert to JavaBean
     *
     * @param map   Map
     * @param clazz Java对象
     * @return 将Map对象转换为Java对象
     */
    private static <T> T map2Bean(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
}