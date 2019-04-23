package client;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            String SetInfo, ReturnInfo, ref;
            float score = 0;
            org.omg.CORBA.Object objRef;
            DataService dataserviceRef;
            ORB orb = ORB.init(args, null);
            /*
             * if (args.length >= 1) { ref = args[0]; //System.out.println(ref);
             * } else { System.out.println("aaaaaaaaaaaaaaaaaa"); return ; }
             */
            // 下面一条语句得到的是一个NamingContext对象，并非SysProp对象
            // objRef = orb.string_to_object(ref);
            // dataserviceRef = DataServiceHelper.narrow(objRef);
            objRef = orb.resolve_initial_references("NameService");
            System.out.println(orb.object_to_string(objRef));
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("DataService", "");
            NameComponent path[] = { nc };
            dataserviceRef = DataServiceHelper.narrow(ncRef.resolve(path));
            if (args.length > 1) {
                SetInfo = args[1];
            } else {
                SetInfo = "0";
            }
            System.out.println("Corba Demo is Running");
            System.out.println("test insert information");
            dataserviceRef.insert("fanghonglin", "2016012915", 100);
            System.out.println("insert successfully \n");
            System.out.println("test search information");
            String searchStuNo = "2016012915";
            float getScore =  dataserviceRef.search(searchStuNo);
            System.out.println("stuNo->"+searchStuNo+"  score->"+getScore);
            System.out.println("search successfully \n");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
