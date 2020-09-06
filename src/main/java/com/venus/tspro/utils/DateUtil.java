package com.venus.tspro.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

    /**
     * 将字符串转换为日期
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date convertStr2Date(String dateStr) throws ParseException {
        SimpleDateFormat sdf = null;
        if (dateStr.length() == 6) {
            sdf = new SimpleDateFormat("yyyyMM");
        }
        if (dateStr.length() == 8) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        }
        return sdf.parse(dateStr);
    }

    /**
     * 根据格式获取当前日期
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDateByPattern(String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(calendar.getTime());

    }

    /**
     * 获取上一天的时间
     *
     * @param pattern
     * @return
     */
    public static String getLastCurrentDateByPattern(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return sdf.format(calendar.getTime());

    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 格式化当前日期
     *
     * @param format
     * @return
     */
    public static String getFormatDate(String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
}
