package com.geek.algorithm.zeller;


/**
 * @Author zhaojingchao
 * @Date 2024/05/28 19:12
 * @Email zhaojingchao@joysuch.com
 * @Desc 日期之间隔几天
 * https://leetcode.cn/problems/number-of-days-between-two-dates/description/
 */
public class DaysBetweenDates {

    public static int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDay(date1) - toDay(date2));
    }

    public static int toDay(String yearString) {
        String[] split = yearString.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        // 把日期提前两个月
        if (month <= 2) {
            year--;
            month += 10;
        } else {
            month -= 2;
        }

        // zeller公式
        return 365 * year + year / 4 - year / 100 + year / 400 + 30 * month + (3 * month - 1) / 5 + day;
    }

    public static void main(String[] args) {
        String date1 = "2020-01-15";
        String date2 = "2019-12-31";
        System.out.println(daysBetweenDates(date1, date2));
    }
}
