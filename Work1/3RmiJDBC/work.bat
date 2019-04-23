start cmd /k "echo RMIService Edit by : 2016012915 && java -jar rmiservice.jar \t"
ping 127.0.0.1 -n 5>null
start cmd /k "echo RMIClient Edit by : 2016012915 && java -jar rmiclient.jar \t"