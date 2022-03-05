package com.mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestSQL {
    public static void main(String[] args) {
        //查询
//        String sqlquery = "select * from person";
//        String[] params = {"Pno","Pname","Psex","Page","Pheight","Pweight"};
//        System.out.println("编号" +"\t"+ "姓名" +"\t"+ "性别"+"\t"+ "年龄"+"\t"+ "身高"+"\t"+ "体重");
//        List<Map<String,String>> listmap = new ArrayList<>();
//        listmap = MysqlUtil.show(sqlquery, params);
//        for (Map<String, String> stringStringMap : listmap) {
//
//            for (int j = 0; j < stringStringMap.size(); j++) {
//                System.out.print(stringStringMap.get(params[j]) + "\t");
//            }
//            System.out.println();
//        }
        //删除
//        String sql = "delete from person where p_name='张三'";
//        int count = MysqlUtil.del(sql);
//        System.out.println(count);

        //更新
        String sql = "update person set p_name='刘一', p_sex='女' where p_no='2001'";
        int count = MysqlUtil.update(sql);
        System.out.println("影响行数为："+count);
    }
}
