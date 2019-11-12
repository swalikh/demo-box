package com.swalikh.kernel.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String forMatTime(Date date,String pattern) {
        if(date != null && !StringUtils.isEmpty(pattern)){
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(date);
        } else {
            return null;
        }
    }
}
