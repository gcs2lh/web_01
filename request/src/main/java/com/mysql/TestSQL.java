package com.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestSQL {
    public static void main(String[] args) {

        String sql = "update person set p_name='刘一', p_sex='女' where p_no='2001'";
        int count = MysqlUtil.update(sql);
        System.out.println("影响行数为："+count);
    }
}
