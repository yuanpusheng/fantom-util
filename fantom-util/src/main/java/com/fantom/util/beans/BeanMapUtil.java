package com.fantom.util.beans;

import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/22 9:08.
 */
public class BeanMapUtil {
    public static <T> T map2Bean(Map<String, ?> map, T target){
        BeanMap.create(target).putAll(map);
        return target;
    }

    public static Map<String, ?> bean2Map(Object object){
        return BeanMap.create(object);
    }
}
