package com.atzz.mine.utils;

import java.sql.Timestamp;

/**
 * @author shkstart
 * @create 2022-03-18 9:52
 */
public class TimeUtils {

    public static Timestamp currentTime(java.util.Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }


}
