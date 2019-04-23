start cmd /k "echo start tnameserv Edit by : 2016012915 && tnameserv \t"
ping 127.0.0.1 -n 5>null
start cmd /k "echo CorbaJavaService Edit by : 2016012915 && java -jar JavaServer.jar \t"
ping 127.0.0.1 -n 5>null
start cmd /k "echo CorbaJavaClient Edit by : 2016012915 && java -jar JavaClient.jar \t"