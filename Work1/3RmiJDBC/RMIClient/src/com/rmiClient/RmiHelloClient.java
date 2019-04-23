package com.rmiClient;

import java.rmi.*;
import com.rmiDB.*;
import com.rmiDB.DBmanager.Student;

// Edit by : 2016012915
public class RmiHelloClient {
	public static void main(String[] args) {
        try{
            DataService ds = (DataService)Naming.lookup("//localhost:1315/ds");
            ds.createTable();
            Student stu = new Student();
            stu.setStuNo("2016012915");
            stu.setStuName("方宏林");
            stu.setGrade(100.0f);
            ds.insert(stu);
            Student stu2 = ds.getStu("2016012915");
            System.out.println("学号： "+stu2.getStuNo());
            System.out.println("姓名： "+stu2.getStuName());
            System.out.println("成绩： "+stu2.getGrade());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
