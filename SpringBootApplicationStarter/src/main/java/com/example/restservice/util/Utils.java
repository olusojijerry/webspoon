package com.example.restservice.util;

import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static Date addSecondsToJavaUtilDate(Date date, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}
