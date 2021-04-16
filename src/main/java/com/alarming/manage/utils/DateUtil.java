package com.alarming.manage.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GUO
 * @Classname DateTo
 * @Description TODO
 * @Date 2021/4/11 14:36
 */
public class DateUtil {
    public static String ToString(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(new Date());
        return format;
    }
}
