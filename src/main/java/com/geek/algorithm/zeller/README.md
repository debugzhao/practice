### Zeller蔡勒公式
#### [概念](https://www.cnblogs.com/igaoshang/articles/Zeller.html#:~:text=%E7%AE%97%E5%87%BA%E6%9D%A5%E7%9A%84%E9%99%A4%E4%BB%A5,%E6%98%AF0%EF%BC%8C%E5%88%99%E4%B8%BA%E6%98%9F%E6%9C%9F%E6%97%A5%E3%80%82&text=%E5%85%B6%E5%85%AC%E5%BC%8F%E4%B8%BA-,W%3DY%2B%5BY%2F4%5D%2B%5BC%2F4%5D%2D,)
#### 公式
#### 应用场景
1. 计算过去或者未来某一天是星期几？

   

2. [计算两个日期的时间差](https://leetcode.cn/problems/number-of-days-between-two-dates/solutions/110877/cyu-yan-0ms-14xing-jian-ji-dai-ma-jie-zhu-zellergo/)

   ```java
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
   ```

   
