package com.cxh.wiki.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtil {
    public static <T> T copy(Object source,Class<T> clazz){
        if(source == null){
            return null;
        }
        T obj = null;
        try{
            obj = clazz.newInstance();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source,obj);
        return obj;
    }

    public static <T> List<T> copyList(List source, Class<T> clazz){
        List<T> target = new ArrayList<>();
        //source==null或空集合
        if(!CollectionUtils.isEmpty(source)){
            for (Object o : source) {
                T copy = copy(o, clazz);
                target.add(copy);
            }
        }
        return target;
    }
}
