package server;
/**
* DataServiceOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��DataService.idl
* 2019��4��8�� ����һ ����08ʱ41��09�� CST
*/

public interface DataServiceOperations 
{
  void insert (String stuName, String StuNo, float score);
  float search (String stuNo);
} // interface DataServiceOperations
