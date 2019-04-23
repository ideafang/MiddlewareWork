package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			DataServiceImpl ds = new DataServiceImpl();
			LocateRegistry.createRegistry(3758);
			Naming.rebind("//localhost:3758/fhl", ds);
			System.out.println("RMI Server is running...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
