package com.alarming.manage.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GUO
 * @Classname ConvertUitls
 * @Description TODO
 * @Date 2021/4/19 20:31
 */
public class ConvertUtil {
    public static Map<String,Object> object2Map(Object object){
        Map<String,Object> result=new HashMap<>();
        //获得类的的属性名 数组
        Field[]fields=object.getClass().getDeclaredFields();
        try {


            for (Field field : fields) {
                field.setAccessible(true);
                String name = new String(field.getName());
                result.put(name, field.get(object));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
