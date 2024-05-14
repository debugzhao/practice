package com.geek.tmp;

/**
 * @Author zhaojingchao
 * @Date 2024/04/28 16:19
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Temp {
    public static void main(String[] args) {
        String sql = "select * from ningxia_zhongwei_upload_patrol_task where tenant_id = {0} and org_code = {1} and data_check_result = '校验成功' and ( (data_upload_status = '未上报' and src_deleted = '0') or ( data_upload_status = '上报成功' and src_deleted != '0' )) ";

        String s = StringUtils.sqlArgsFill(sql, "666666", "000");
        System.out.println(s);
    }
}
