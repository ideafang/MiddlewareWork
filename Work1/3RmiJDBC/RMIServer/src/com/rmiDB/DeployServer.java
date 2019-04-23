package com.rmiDB;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class DeployServer {
	public DeployServer(){
	}
	// Edit by : 2016012915
	public static void main(String[] args) {
	    try{
	        DataService ds = new DataServiceImpl();
	        LocateRegistry.createRegistry(1315);
	        Naming.rebind("//127.0.0.1:1315/ds",ds);
	        System.out.println("RMI��������������...");
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
