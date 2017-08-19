package jdbc;

public class Blinov {

	public static void main(String[] args) {
		
	}
}
/**
 * Какие пакеты содержат интерфейсы и классы JDBC (1)?
1)	java.db и javax.xdb
2)	java.sql и javax.sql
3)	java.jdbc.sql и javax.jdbc.sql
4)	org.sql и org.jdbc
5)	java.jdbc и javax.jdbc
 */


/*
 * Вопрос 20.1.

Объекты каких классов позволяют загрузить и зарегистрировать 
необходимый JDBC-драйвер и получить соединение 
с базой данных или получить доступ к БД через пространство имен?

1) java.sql.DriverManager;

2) javax.sql.DataSource;

 java.sql.Statement;

 java.sql.ResultSet;

 java.sql.Connection.

Объект DriverManager для установки соединения 
с БД использует драйвер БД и ее URL. Объект DataSource 
использует имя для поиска объекта.

Ответ: 1, 2.

Вопрос 20.2.

Какой интерфейс из пакета java.sql должен реализовывать
каждый драйвер JDBC?

1) Driver;

DriverManager;

Connection;

DriverPropertyInfo;

ResultSet.

Производитель СУБД должен создать и предоставить драйвер для соединения
с БД. Все драйвера должны реализовывать интерфейс java.sql.Driver.

Ответ: 1.

Вопрос 20.3.

С помощью какого метода интерфейса Connection 
можно получить сведения о базе данных, с которой установлено соединение?

1) getMetaData();

getDatabaseInfo();

getInfo();

getMetaInfo();

getDatabaseMetaData().

Метод getMetaData() извлекает из установленного соединения объект
DatabaseMetaData, в котором определен целый ряд методов, 
позволяющих получить информацию о состоянии БД и ее таблиц.

Ответ: 1.

Вопрос 20.4.

Какой интерфейс пакета java.sql используется, когда запрос 
к источнику данных является обращением к хранимой процедуре?

Statement;

PreparedStatement;

StoredStatement;

4) CallableStatement;

StoredProcedure.

Вопрос 20.5.

Какой метод интерфейса Statement необходимо использовать 
при выполнении SQL-оператора SELECT, который возвращает объект ResulSet?

execute();

2) executeQuery();

executeUpdate();

executeBatch();

executeSelect();

executeSQL().

Метод executeUpdate() используется для выполнения SQL-операторов,
производящих изменения в БД. 
Метод execute() применяется, если неизвестен тип данных, 
возвращаемых оператором SQL. 
Метод executeBatch() применяется для выполнения группы команд SQL. 
Метод executeQuery() возвращает результат выполнения оператора SELECT, 
упакованный в объект ResultSet.

Ответ: 2.
 */
