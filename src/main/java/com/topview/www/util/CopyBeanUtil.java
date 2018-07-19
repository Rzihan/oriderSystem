package com.topview.www.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CopyBeanUtil {

    /**
     * @Description:  将srcObj对象字段的值拷贝到destObj字段（前提是：两个对象中的字段名相同时）
     *                其实就是通过反射将值先存在map中，在遍历set进目标对象
     */
    public static  void  copyFieldToBean(Object srcObj,Object destObj){
        Map<String, Object> srcMap = new HashMap<>();
        Field[] srcFields = srcObj.getClass().getDeclaredFields();
        for (Field srcField : srcFields) {
            try {
                srcMap.put(srcField.getName(), srcField.get(srcObj)); //获取属性值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Field[] destFields = destObj.getClass().getDeclaredFields();
        for (Field destField : destFields) {
            if (srcMap.get(destField.getName()) == null) {
                continue;
            }
            try {
                destField.set(destObj, srcMap.get(destField.getName())); //给属性赋值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
