package com.go.jinglesample.utils;

import java.util.Date;

public class TimeUtil {
    public static boolean isOlderThanFiveMins(final Date savedDate) {
        Date currentDate = new Date();
        long diff = currentDate.getTime() - savedDate.getTime();
        long seconds = diff / 1000;
        long minutes = seconds / 60;

        return minutes > 5;
    }
}
