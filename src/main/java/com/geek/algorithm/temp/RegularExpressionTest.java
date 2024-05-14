package com.geek.algorithm.temp;

import java.time.LocalDate;

/**
 * @Author zhaojingchao
 * @Date 2024/03/21 09:30
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class RegularExpressionTest {

    public static void main(String[] args) {
        batchQuery();
    }

    private static void testCompare() {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2025, 3, 21);
        System.out.println(localDate.isEqual(now));
    }

    private static void batchQuery() {
        int count = 0;
        int BATCH_SIZE = 100;
        int loop = count / BATCH_SIZE + 1;
        for (int i = 1; i <= loop; i++) {
            System.out.printf("第%d次查询, current:%d, size:%d \n", (i), i, BATCH_SIZE);
        }
    }
}
