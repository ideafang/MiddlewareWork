package com.rmiDB;

import java.io.Serializable;
import java.sql.*;

public class DBmanager {
    private static final String userName = "root";
    private static final String password = "";
    private static final String dburl="jdbc:mysql://127.0.0.1:3306/rmidb?useUnicode=true&characterEncoding=utf8";
    private static final String driver="com.mysql.jdbc.Driver";
    private static Connection conn = null;
    private static ResultSet rs = null;
private static Statement stmt = null;

    public static Connection getConn(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl,userName,password);
        }catch(ClassNotFoundException e){
            System.out.println("没有找到数据库驱动程序");
        }catch(SQLException e){
            System.out.println("数据库连接时出现异常，可能由于数据库服务未启动造成，请先启动数据库服务");
        }
        return conn;
}

    public static void createTable(){
        String sql = "create table stu(stuNo varchar(10),stuName varchar(10),grade float);";
        conn = getConn();
        try{
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
}

    public static void insert(Student stu){
        String sql = "insert into stu values('"+stu.getStuNo()+"','"+stu.getStuName()+"',"+stu.getGrade()+")";
        conn = getConn();
        try{
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
}

    public static Student getStu(String stuNo){
        String sql = "select * from stu where stuNo = "+stuNo;
        conn = getConn();
        Student stu = new Student();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                stu.setStuNo(rs.getString(1));
                stu.setStuName(rs.getString(2));
                stu.setGrade(rs.getFloat(3));
            }
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return stu;
}

    public static class Student implements Serializable{
        private String stuNo="";
        private String stuName="";
        private float grade=0.0f;
        public Student(){}
        public String getStuNo() {
            return stuNo;
        }
        public void setStuNo(String stuNo) {
            this.stuNo = stuNo;
        }
        public String getStuName() {
            return stuName;
        }
        public void setStuName(String stuName) {
            this.stuName = stuName;
        }
        public float getGrade() {
            return grade;
        }
        public void setGrade(float grade) {
            this.grade = grade;
        }
    }
}
