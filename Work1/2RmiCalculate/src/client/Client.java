package client;

import java.rmi.Naming;
import java.util.Scanner;

import server.DataService;

public class Client {
	// Edit by : 2016012915
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// TODO 自动生成的方法存根
		try {
			DataService ds = (DataService)Naming.lookup("//localhost:3758/fhl");
			System.out.println("1. Usage:>add/min/mul/div integer integer");
			System.out.println("   e.g:  >add 10 20");
			System.out.println("2. Usage:>shutdown");
			String operate = input.next();
			while (!operate.equals("shutdown")) {
				double n1 = input.nextDouble();
				double n2 = input.nextDouble();
				double result = ds.calculate(operate, n1, n2);
				if (result == 1e-8) {
					System.out.println("illegal input format!");
					System.out.println("1. Usage:>add/min/mul/div integer integer");
					System.out.println("   e.g:  >add 10 20");
					System.out.println("2. Usage:>shutdown");
				} else {
					System.out.println("result :" + result);
				}
				operate = input.next();
			}
		}catch(Exception e){
            e.printStackTrace();
        } 
	}

}
