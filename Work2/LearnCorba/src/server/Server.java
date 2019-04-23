package server;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class DataServiceImpl extends DataServicePOA // ����ķ���ʵ��
{
    private ORB orb;
 
    public void setOrb(ORB orb_val) {
        this.orb = orb_val;
    }
 
    @Override
    public void insert(String stuName, String StuNo, float score) {
        // TODO Auto-generated method stub
        DBmanager.insert(stuName, StuNo, score);
    }
 
    @Override
    public float search(String stuNo) {
        // TODO Auto-generated method stub
        return DBmanager.search(stuNo);
    }
}

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            System.out.println("�����ͳ�ʼ�� ORB ");
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb
                    .resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            System.out.println("����������󲢽����� ORB ע�� ");
            DataServiceImpl dataServiceImpl = new DataServiceImpl();
            dataServiceImpl.setOrb(orb);
            // System.out.println(orb.object_to_string(sysProImpl));
            org.omg.CORBA.Object objRef = orb
                    .resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent[] path = { new NameComponent("DataService", "") };
            org.omg.CORBA.Object ref = rootpoa
                    .servant_to_reference(dataServiceImpl);
            DataService href = DataServiceHelper.narrow(ref);
            System.out.println(orb.object_to_string(href));
            System.out.println(ncRef.getClass().toString());
            ncRef.rebind(path, href);
            System.out.println("DataServiceServer ready and waiting ...");
            orb.run();
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        }
	}

}
