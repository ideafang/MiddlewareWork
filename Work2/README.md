## 运行环境
- JDK配置正确
- mysql连接端口为3306，用户名：root， 密码：**131500**
- 存在数据库learncorba
- learncorba中存在表studentInfo，表中有三项stuName(varchar 20), stuNo(varchar 20), score(float)
## 使用方法
运行环境符合后，双击work.bat即可自动调用tnameserv命名服务器、Java服务器端和Java客户端。

由于Java的服务器每次开启时的**IOR**都有一点不同，而C++的客户端需要对应Java服务器的IOR，因此无法实时启动，需要在开启Java服务器后，**将IOR的值复制到client.cpp**后实时编译启动。
## 注意
每次重新启动Java服务器端，IOR的值都会变，如果不及时修改client.cpp中的IOR值，C++的客户端就不能运行，会抛出异常。