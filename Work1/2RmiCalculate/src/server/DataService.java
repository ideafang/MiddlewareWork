package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataService extends Remote {
	// Edit by : 2016012915
	public double calculate(String op, double n1, double n2) throws RemoteException;
}
