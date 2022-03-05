package com.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlUtil {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		Person person = new Person("2011","张彤","男",22,190,80);
//		String sqlInsert = "INSERT  INTO Person (Pno,Pname,Psex,Page,Pheight,Pweight) VALUES('";
//		sqlInsert += person.getPno()+"','";
//		sqlInsert += person.getName()+"','";
//		sqlInsert += person.getSex()+"',";
//		sqlInsert += person.getAge()+",";
//		sqlInsert += person.getHeight()+",";
//		sqlInsert += person.getWeight()+")";
//
//		System.out.println(add(sqlInsert));

        String sqlquery = "select * from person";
        String[] params = {"p_no","p_name","p_sex","p_age","p_height","p_weight"};
        System.out.println("编号" +"\t"+ "姓名" +"\t"+ "性别"+"\t"+ "年龄"+"\t"+ "身高"+"\t"+ "体重");
        List<Map<String,String>> listmap = new ArrayList<>();
        listmap = MysqlUtil.show(sqlquery, params);
        for (Map<String, String> stringStringMap : listmap) {

            for (int j = 0; j < stringStringMap.size(); j++) {
                System.out.print(stringStringMap.get(params[j]) + "\t");
            }
            System.out.println();
        }


    }


    public static int add(String sql) {
        int message = 0;

        DBConnection db = new DBConnection();
        try {
            PreparedStatement preStmt = db.conn.prepareStatement(sql);
            preStmt.executeUpdate();
            //Statement statement = (Statement) db.conn.createStatement();
            //statement.executeUpdate(sql);

            preStmt.close();
            db.close();//关闭连接
            message = 1;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return message;//返回影响的行数，1为执行成功
    }

    //查找操作
    public static List< Map<String,String> > show(String sql, String[] params){
        // String sql ="select * from employee";

        List< Map<String,String> > listmap = new ArrayList<>();

        DBConnection db = new DBConnection();
        ResultSet rs = null;

        try {
            Statement stmt = db.conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){

                Map<String,String> map = new HashMap<>();
                for(int i = 0; i < params.length; i++) {

                    map.put(params[i], rs.getString(params[i]));
                }
                listmap.add(map);
            }
            rs.close();
            db.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listmap;


    }

    public static int del(String sql) {
        int i=0;
        //  String sql="delete from employee where name=?";
        DBConnection db = new DBConnection();
        try {
            PreparedStatement preStmt = db.conn.prepareStatement(sql);

            preStmt.executeUpdate();

            preStmt.close();
            db.close();//关闭连接

            i = 1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }

    public static int update( String sql ) {
        int i =0;
        // String sql="update employee set email=?,pwd=? where name=?";
        DBConnection db = new DBConnection();

        try {
            PreparedStatement preStmt = db.conn.prepareStatement(sql);
//            preStmt.setString(1, uemail);
//            preStmt.setString(2, upwd);
//            preStmt.setString(3, uname);
            preStmt.executeUpdate();

            preStmt.close();
            db.close();//关闭连接
            i = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }

}
