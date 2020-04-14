package com.ws.parkinterface.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public  static String dateFormat(Date date){
        String str = "yyy-MM-dd HH:mm:ss";

        SimpleDateFormat sdf = new SimpleDateFormat(str);
        return sdf.format(date);
    }
}
