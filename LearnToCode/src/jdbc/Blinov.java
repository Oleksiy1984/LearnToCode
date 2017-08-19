package jdbc;

public class Blinov {

	public static void main(String[] args) {
		
	}
}
/**
 * ����� ������ �������� ���������� � ������ JDBC (1)?
	java.db � javax.xdb
2)	java.sql � javax.sql
	java.jdbc.sql � javax.jdbc.sql
	org.sql � org.jdbc
	java.jdbc � javax.jdbc

������ � ���������� JDBC ��������� � �������
java.sql � javax.sql. 
�����: 2.


���� ��������� ����� Java:
a)	Connection cn =
DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "pass");
b)	ResultSet rs = st.executcQucry( "SELECT * FROM users WHERE id=l");
c)	Class.forName("org.gjt.mm.mysql.Driver");
d)	Statement st = cn.createStatement();
e)	System.out.println(rs.next());
���������� �� � ���������� ������������������ ���, 
����� � ������� ������������� ���� ����� ���� ������� ������ �� �� (1):
1)	abdcc:
2)	cadbe;
3)	cabdc;
4)	ebdac;
5)	abced.

2) cadbe
������������������ �������� ��� ����������� � �� � ������� JDBC ���������: 
�������� ��������, ������������ ����������, �������� ������� 
��� ���������� ��������, ���������� 
�������, ��������� �����������, 
�������� �������� ����������. 
�����: 2.




����� ���� statement-�������� ���������� � JDBC (3)?
1)	Statement
2)	ResultStatement
3)	PreparedStatement
4)	DrivcrStatcmcnt
5)	MetaDataStatement
6)	CallableStatement

1,3,6
� API JDBC ���������� ��� ����������, 
���������� ������� ����� ������������� statement-�������: 
Statement, PreparedStatement, CallableStatement.
�����: 1, 3, 6.


���� ���� ������ test � �������� users:
id	name
1	Ivanov
����� ���������� ��������� � ������� users ����� ����������
 ���������� ���� (2)?
Connection �n = /* ���������� ��������� ���������� */;
/*
Statement st = cn.createStatement();
st.executeUpdate("INSERT INTO users VALUES (2, 'Petrov')"); 
cn.setAutoCommit(false);
st.executeUpdate("INSERT INTO users VALUES (3, 'Sidorov')");
cn.setSavepoint("point1");
st.exccuteUpdate("INSERT INTO users VALUES (4, 'Vasechkin')"); 
cn.rollback();
st.executeUpdate("INSERT INTO users VALUES (5, 'Blinov')"); 
cn.commit();

1)	id=2, name-Petrov
2)	id=3, name=Sidorov
3)	id=4, name=Vasechkin
4)	id=5. name=Blinov


����� rollback(), ����������� �� ������� ���� Connection, 
������� ��������� �� �� ���������� ��������� �������� commit; 
� ������� ��������� ���������� (2, Petrov) � (5, Blinov).
�����: 1, 4.

�������, ����� �������� ����� ��������� �������� ��������� 
� ������� JDBC (3):
1)	������� ����� execute() �� ������� CallableStatement
2)	������� ����� executeQuery() �� ������� CallableStatement
3)	������� ����� executeUpdate() �� ������� CallableStatement
	������� ����� executeProcedure() �� ������� CallableStatement
	������� ����� execute() �� ������� StoredStatement
	������� ����� exccuteQuery() �� ������� StoredStatement
	������� ����� exccuteUpdatc() �� ������� StoredStatement
	������� ����� exccuteProcedure() �� ������� StoredStatement


�������� ��������� ����� ��������� �� ������� CallableStatement. 
����� ��������� ������� � �������� ���������� ������������
������ ����ute(), ���cuteQuery() ��� executeUpdate().
�����: 1, 2, 3.
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
