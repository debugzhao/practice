package com.geek.algorithm.others;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Author zhaojingchao
 * @Date 2024/05/28 19:12
 * @Email zhaojingchao@joysuch.com
 * @Desc 日期之间隔几天
 * https://leetcode.cn/problems/number-of-days-between-two-dates/description/
 */
public class DaysBetweenDates {

    public static int daysBetweenDates(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse1 = LocalDate.parse(date1, formatter);
        LocalDate parse2 = LocalDate.parse(date2, formatter);
        return Math.abs(parse2.until(parse1).getDays());
    }

    public static void main(String[] args) {
        String date1 = "2019-06-29";
        String date2 = "2019-06-30";
        System.out.println(daysBetweenDates(date1, date2));
    }
}
