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
            stu.setStuName("������");
            stu.setGrade(100.0f);
            ds.insert(stu);
            Student stu2 = ds.getStu("2016012915");
            System.out.println("ѧ�ţ� "+stu2.getStuNo());
            System.out.println("������ "+stu2.getStuName());
            System.out.println("�ɼ��� "+stu2.getGrade());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
