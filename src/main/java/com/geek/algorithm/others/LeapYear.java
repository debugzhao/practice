package com.geek.algorithm.others;

/**
 * @Author zhaojingchao
 * @Date 2024/05/28 20:17
 * @Email zhaojingchao@joysuch.com
 * @Desc 判断是否是闰年
 */
public class LeapYear {

    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return year % 100 != 0 || year % 400 == 0;
        } else {
            return false;
        }
    }

    public boolean isLeapYear1(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
