#include <stdlib.h>
#include <stdio.h>
// #include <string>
// #include <cstring>
// #include <iostream>
#include "mathservice.h"

// using namespace std;

// string changeCharToString(unsigned char p){
//      string str = "";
//      str += p;
//      return str;
// }

double calculate(char op, double n1, double n2){
     double result;
     // double n1 = atof(str1.c_str());
     // double n2 = atof(str2.c_str());
     switch(op){
        	case '+' :
            	result = n1 + n2;
            	break;
          	case '-' :
            	result = n1 - n2;
				break;;
			case '*' :
				result = n1 * n2;
				break;
			case '/' :
				result = n1 / n2;
				break;
	 }
	 return result;

}

// void math(const unsigned char * data){
//      int i = 1;
//      while(data[i] != '?'){
//           i++;
//      }
//      string str1 = "";
//      string str2 = "";
//      string data1 = "";
//      int len = strlen((char*)data);
//      for (int j = 0; j < len; j++){
//           data1 = data1 + changeCharToString(data[j]);
//      }
//      str1.append(data1, 1, i-1);
//      str2.append(data1, i+1, len-i-1);
//      double result = calculate(data[0], str1, str2);
// 	 cout << str1 << data[0] << str2 << "=" << result << endl;
// }

// Edit by 2016012915
void math (const unsigned char * data){
     double n1, n2;
     char op;
     sscanf((char*)data, "%c?%lf?%lf", &op, &n1, &n2);
     double result = calculate(op, n1, n2);
     printf("%f %c %f = %f\n", n1, op, n2, result);
}

void ShutDown(void)
{

     RpcMgmtStopServerListening(NULL);
     RpcServerUnregisterIf(NULL, NULL, FALSE);
}

int main(int argc,char * argv[])
{
     
     RpcServerUseProtseqEp((unsigned char *)"ncacn_np", 20, (unsigned char *)"\\pipe\\{8dd50205-3108-498f-96e8-dbc4ec074cf9}", NULL);    

     RpcServerRegisterIf(MathService_v1_0_s_ifspec, NULL, NULL);

     RpcServerListen(1,20,FALSE); 
     return 0;
}

void __RPC_FAR* __RPC_USER midl_user_allocate(size_t len)
{
     return(malloc(len));
}

void __RPC_USER midl_user_free(void __RPC_FAR *ptr)
{
     free(ptr);
}
