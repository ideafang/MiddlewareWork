package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DataServiceImpl extends UnicastRemoteObject implements DataService{

	protected DataServiceImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public double calculate(String op, double n1, double n2) throws RemoteException {
		// Edit by : 2016012915
		double result = 0.0;
		if (op.equals("add")) {
			result = n1 + n2;
		} else if (op.equals("min")) {
			result = n1 - n2;
		} else if (op.equals("mul")) {
			result = n1 * n2;
		} else if (op.equals("div")) {
			result = n1 / n2;
		} else {
			result = 1e-8;
		}
		return result;
	}
	
}
