package jdbc;

public class Blinov {

	public static void main(String[] args) {
		
	}
}
/**
 * ����� ������ �������� ���������� � ������ JDBC (1)?
1)	java.db � javax.xdb
2)	java.sql � javax.sql
3)	java.jdbc.sql � javax.jdbc.sql
4)	org.sql � org.jdbc
5)	java.jdbc � javax.jdbc
 */


/*
 * ������ 20.1.

������� ����� ������� ��������� ��������� � ���������������� 
����������� JDBC-������� � �������� ���������� 
� ����� ������ ��� �������� ������ � �� ����� ������������ ����?

1) java.sql.DriverManager;

2) javax.sql.DataSource;

 java.sql.Statement;

 java.sql.ResultSet;

 java.sql.Connection.

������ DriverManager ��� ��������� ���������� 
� �� ���������� ������� �� � �� URL. ������ DataSource 
���������� ��� ��� ������ �������.

�����: 1, 2.

������ 20.2.

����� ��������� �� ������ java.sql ������ �������������
������ ������� JDBC?

1) Driver;

DriverManager;

Connection;

DriverPropertyInfo;

ResultSet.

������������� ���� ������ ������� � ������������ ������� ��� ����������
� ��. ��� �������� ������ ������������� ��������� java.sql.Driver.

�����: 1.

������ 20.3.

� ������� ������ ������ ���������� Connection 
����� �������� �������� � ���� ������, � ������� ����������� ����������?

1) getMetaData();

getDatabaseInfo();

getInfo();

getMetaInfo();

getDatabaseMetaData().

����� getMetaData() ��������� �� �������������� ���������� ������
DatabaseMetaData, � ������� ��������� ����� ��� �������, 
����������� �������� ���������� � ��������� �� � �� ������.

�����: 1.

������ 20.4.

����� ��������� ������ java.sql ������������, ����� ������ 
� ��������� ������ �������� ���������� � �������� ���������?

Statement;

PreparedStatement;

StoredStatement;

4) CallableStatement;

StoredProcedure.

������ 20.5.

����� ����� ���������� Statement ���������� ������������ 
��� ���������� SQL-��������� SELECT, ������� ���������� ������ ResulSet?

execute();

2) executeQuery();

executeUpdate();

executeBatch();

executeSelect();

executeSQL().

����� executeUpdate() ������������ ��� ���������� SQL-����������,
������������ ��������� � ��. 
����� execute() �����������, ���� ���������� ��� ������, 
������������ ���������� SQL. 
����� executeBatch() ����������� ��� ���������� ������ ������ SQL. 
����� executeQuery() ���������� ��������� ���������� ��������� SELECT, 
����������� � ������ ResultSet.

�����: 2.
 */
