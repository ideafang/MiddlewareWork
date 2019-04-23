#include <stdlib.h>
#include <stdio.h>
// #include <cstring>
// #include <iostream>
#include "mathservice.h"     

// using namespace std;

int main(int argc, char * argv[])
{
     unsigned char * pszStringBinding = NULL;
     if ( argc != 4 )
     {
         printf("1. Usage:>client add/min/mul/div integer integer\n");
         printf("   e.g:  >client add 10 20\n");
         printf("2. Usage:>client shutdown 0 0\n");
         return 1;
     }    

     RpcStringBindingCompose( NULL, (unsigned char*)"ncacn_np",  NULL, (unsigned char*)"\\pipe\\{8dd50205-3108-498f-96e8-dbc4ec074cf9}", NULL, &pszStringBinding );

    
     RpcBindingFromStringBinding(pszStringBinding, & MathService_Binding );    

     RpcTryExcept
     {
         // Edit by : 2016012915
         if ( _stricmp(argv[1], "SHUTDOWN") == 0 )
         {
              ShutDown();
         }
         else
         {
             char data[30];
             char op;

             if ( _stricmp(argv[1], "ADD" ) == 0 ){
                op = '+';
             } else if ( _stricmp(argv[1], "MIN") == 0 ){
                op = '-';
             } else if ( _stricmp(argv[1], "MUL") == 0 ){
                op = '*';
             } else if ( _stricmp(argv[1], "DIV") == 0 ){
                op = '/';
             }
             sprintf(data, "%c?%s?%s", op, argv[2], argv[3]);
             math((unsigned char*)data);
         }
     }
     RpcExcept(1)
     {
         printf( "RPC Exception %d\n", RpcExceptionCode() );
     }
     RpcEndExcept

 
     RpcStringFree(&pszStringBinding);
     RpcBindingFree(&MathService_Binding);
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
