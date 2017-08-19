package jdbc;

public class Blinov {

	public static void main(String[] args) {
		
	}
}
/**
 * Какие пакеты содержат интерфейсы и классы JDBC (1)?
	java.db и javax.xdb
2)	java.sql и javax.sql
	java.jdbc.sql и javax.jdbc.sql
	org.sql и org.jdbc
	java.jdbc и javax.jdbc

Классы и интерфейсы JDBC находятся в пакетах
java.sql и javax.sql. 
Ответ: 2.


Даны операторы языка Java:
a)	Connection cn =
DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "pass");
b)	ResultSet rs = st.executcQucry( "SELECT * FROM users WHERE id=l");
c)	Class.forName("org.gjt.mm.mysql.Driver");
d)	Statement st = cn.createStatement();
e)	System.out.println(rs.next());
Расставьте их в правильной последовательности так, 
чтобы с помощью получившегося кода можно бьшо извлечь данные из БД (1):
1)	abdcc:
2)	cadbe;
3)	cabdc;
4)	ebdac;
5)	abced.

2) cadbe
Последовательность действий для подключения к БД с помощью JDBC следующая: 
загрузка драйвера, установление соединения, создание объекта 
для выполнения запросов, выполнение 
запроса, обработка результатов, 
закрытие открытых соединений. 
Ответ: 2.




Какие типы statement-объектов существуют в JDBC (3)?
1)	Statement
2)	ResultStatement
3)	PreparedStatement
4)	DrivcrStatcmcnt
5)	MetaDataStatement
6)	CallableStatement

1,3,6
В API JDBC существует три интерфейса, 
реализации которых могут предоставлять statement-объекты: 
Statement, PreparedStatement, CallableStatement.
Ответ: 1, 3, 6.


Дана база данных test с таблицей users:
id	name
1	Ivanov
Какая информация добавится в таблицу users после выполнения
 следующего кода (2)?
Connection сn = /* корректное получение соединения */;
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


Метод rollback(), выполненный на объекте типа Connection, 
откатит состояние БД до выполнения последней операции commit; 
в таблицу добавится информация (2, Petrov) и (5, Blinov).
Ответ: 1, 4.

Укажите, каким способом можно выполнить хранимую процедуру 
с помощью JDBC (3):
1)	вызвать метод execute() на объекте CallableStatement
2)	вызвать метод executeQuery() на объекте CallableStatement
3)	вызвать метод executeUpdate() на объекте CallableStatement
	вызвать метод executeProcedure() на объекте CallableStatement
	вызвать метод execute() на объекте StoredStatement
	вызвать метод exccuteQuery() на объекте StoredStatement
	вызвать метод exccuteUpdatc() на объекте StoredStatement
	вызвать метод exccuteProcedure() на объекте StoredStatement


Хранимую процедуру можно выполнить на объекте CallableStatement. 
после установки входных и выходных параметров используются
методы ехесute(), ехеcuteQuery() или executeUpdate().
Ответ: 1, 2, 3.
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
