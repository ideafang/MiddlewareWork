package com.rmiDB;

import java.rmi.server.*;
import java.rmi.*;
import com.rmiDB.DBmanager.Student;

public class DataServiceImpl extends UnicastRemoteObject implements DataService{
	private static final long serialVersionUID = -7777277221L;
    public DataServiceImpl() throws RemoteException{
        super();
    }
    @Override
    // Edit by : 2016012915
    public void createTable() throws RemoteException{
        DBmanager.createTable();
    }
    @Override
    public Student getStu(String stuNo) throws RemoteException{
        return DBmanager.getStu(stuNo);
    }
    @Override
    public void insert(Student stu) throws RemoteException{
        DBmanager.insert(stu);
    }
}
