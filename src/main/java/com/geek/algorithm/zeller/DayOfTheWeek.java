package com.geek.algorithm.zeller;


/**
 * @Author zhaojingchao
 * @Date 2024/05/28 21:09
 * @Email zhaojingchao@joysuch.com
 * @Desc 一周中的第几天
 * https://leetcode.cn/problems/day-of-the-week/
 */
public class DayOfTheWeek {
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month <= 2) {
            month += 12;
            year --;
        }
        int d = year + year / 4 - year / 100 + year / 400 + 2 * month + 3 * (month  + 1) / 5  + day + 1;
        return weeks[d % 7];
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
    }
}
