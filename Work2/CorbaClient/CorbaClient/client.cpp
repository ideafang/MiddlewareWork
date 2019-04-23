#include "DataService.h"
#include <stdio.h>
int main(int argc, char* argv[]) {
	try {

		CORBA::ORB_var orb = CORBA::ORB_init(argc, argv);

		char text[] = "IOR:000000000000001449444c3a44617461536572766963653a312e3000000000010000000000000086000102000000000e3139322e3136382e322e32313700062000000031afabcb000000002019d2ee6700000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002";
		char* IORStr = text;

		CORBA::Object_var obj = orb->string_to_object(IORStr);
		if (CORBA::is_nil(obj)) {
			printf("Nil Score Reference");
			throw 0;
		}
		DataService_var tm = DataService::_narrow(obj);
		if (CORBA::is_nil(tm)) {
			printf("Nil Score Reference");
			throw 0;
		}
		printf("Corba test begin\n");
		printf("stuNo -> 2016012915  score-> %f\n ", tm->search("2012012915"));
		printf("Corba test success!");
	}
	catch (const CORBA::Exception&) {
		printf("IOR的值错误！请将Java服务器端的IOR值拷贝到client.cpp的相应位置后再编译运行！！！\n");
		return 1;
	}
	return 0;
}