package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ResourceBundle;






public class Tanya {
	private static final ResourceBundle db = ResourceBundle.getBundle("jdbc.db");
	private static final String url = db.getString("url");
	private static final String user = db.getString("username");
	private static final String password = db.getString("password");
	static String update = "update fortest set name='AAA' where id=1;";
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void main(String[] args) throws SQLException {
		try (Connection connection = getConnection();
				Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select id as NNN, name, ints from fortest;");
				PreparedStatement preparedStatement = connection.prepareStatement(update);) {
			ResultSet rs2 = preparedStatement.executeQuery();//run time error 
			//Can not issue data manipulation statements with executeQuery().
			if (rs2.next()) {
				System.out.println(rs2.getString(1));
			}
			ResultSetMetaData metaData = rs.getMetaData();
			System.out.println(metaData.getColumnCount());//3 columns
			System.out.println(metaData.getColumnDisplaySize(2));//45 varchar(45)
			System.out.println(metaData.getColumnTypeName(2));//VARCHAR
			System.out.println(metaData.getPrecision(2));//45
			System.out.println(metaData.getScale(3));//0
			System.out.println(metaData.getColumnClassName(2));//java.lang.Integer
			System.out.println(metaData.getColumnName(1));//id
			System.out.println(metaData.getColumnLabel(1));//NNN
			System.out.println(metaData.getColumnDisplaySize(1));//1
//			Savepoint sp1 = connection.setSavepoint(); 
//			connection.rollback(sp1);
			
//			while (rs.next()) {
//				System.out.println(rs.getInt(2) + "-" + rs.getString(3));
//			}
			/*
			// insert
			rs.moveToInsertRow();//OBLIGOTORY
			rs.updateString(2, "2");
			//rs.updateString(3, "4.4");//4
			rs.updateString(3, "6.5");//7
			rs.insertRow();
			

			//update
			rs.absolute(1);
			rs.updateString(2, "2220");
			rs.updateString(3, "30.9");
			rs.updateRow();
			//rs.refreshRow(); get the newaet value only
			
			rs.absolute(1);
			System.err.println(rs.getRow());//1
			*/
		}

	}

}
/**
 *   Statement stmt = connection.createStatement();         
 *   ResultSet rs = stmt.executeQuery("select EMAILID, NAME,  PHONE from CUSTOMER order by EMAILID"); //LINE 10         
 *   while(rs.next()){             
 *   System.out.println(rs.getString(0)+"|"+rs.getString(1)+"|"+rs.getString(3));         }         
 *   connection.close();  Identify the correct statement about this code. 
 *   
 *   It will throw an exception when run if there is at least 1 record in the table.
 *   The numbering of columns in a ResultSet starts with 1. Therefore, rs.getString(0) 
 *   will cause an SQLException.
 */
/**
 * JDBC 2.0 allows you to use ResultSet object to update an existing row 
 * and even insert new row in the database. For both the cases, 
 * the ResultSet must be updatable, which can be achieved by passing 
 * ResultSet.CONCUR_UPDATABLE while creating a Statement object: 
 * stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_UPDATABLE); 
 * or stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);  
 * The general usage pattern for this functionality is as follows -  To update an existing row:  
 * 1. First, go to the row you want to update. You can either iterate through a ResultSet to reach 
 * a particular row or just call rs.absolute(int rowNumber). 2. Now update the columns of the ResultSet 
 * with required values using rs.updateXXX(columnNumber, value) or rs.updateXXX(columnName, value) methods. 
 * 3. Call rs.updateRow(); If you call rs.refreshRow() without calling updateRow(), 
 * the updates will be lost.  
 * To insert a new Row: 1. Call rs.moveToInsertRow(); first. 
 * You can't insert a row without calling this method first. 
 * 2. Use rs.updateXXX methods to update all column values. 
 * You must set values for all the columns. 
 * 3. Call rs.insertRow();  
 * 4. Call rs.moveToCurrentRow(); to go back to the row where you were before calling 
 * moveToInsertRow.  IMPORTANT: The exam will test you on implications of calling various 
 * methods out of sequence. For example, what happens when you call insertRow without 
 * first calling moveToInsertRow? (An SQLException will be thrown.) 
 * or what happens when you call refreshRow without first calling updateRow? 
 * (No exception but updates will be lost.). 
 * You should go through the JavaDoc API description for all the methods involved in update/inserting 
 * rows in the database using a ResultSet.
 */

/*
 * connection.setAutoCommit(false); 
 * stmt.executeUpdate("update student set status=1"); \\1 
 * SavePoint savePoint1 = connection.setSavePoint("step1done"); 
 * stmt.executeUpdate("update student set gpa=4.0"); \\2 
 * if(special condition){   
 * connection.rollback(savePoint1); } 
 * connection.commit(); //query 1 will be committed but query 2 will not be committed.
 */
/*
 * When a connection is created, it is in auto-commit mode. i.e. auto-commit is enabled. 
 * This means that each individual SQL statement is treated as a transaction and is automatically 
 * committed right after it is completed. (A statement is completed when all of its result sets and 
 * update counts have been retrieved. In almost all cases, however, a statement is completed, and 
 * therefore committed, right after it is executed.)  The way to allow two or more statements to be 
 * grouped into a transaction is to disable the auto-commit mode. Since it is enabled by default, you 
 * have to explicitly disable it after creating a connection by calling con.setAutoCommit(false);
 */
/*
 * ResultSetMetaData gives you the information about the result of executing a query. 
 * You can retrieve this object by calling getMetaData() on ResultSet.
ResultSetMetaData contains several methods that tell you about the ResultSet. 
Some important methods are:
getColumnCount(), getColumnName(int col), getColumnLabel(int col), and getColumnType(int col). 
Remember that the column index starts from 1.
 * */

/*
 * Prior to JDBC 4.0, the application code would have to load the Driver class explicitly 
 * using Class.forName method, for example - 
 * Class.forName("com.xyz.jdbc.Driver"). 
 * However, with JDBC 4.0, applications no longer need to do this.  
 * The DriverManager methods getConnection and getDrivers have been enhanced to support 
 * the Java Standard Edition Service Provider mechanism. 
 * JDBC 4.0 Drivers must include the file META-INF/services/java.sql.Driver. 
 * This file contains the name of the JDBC drivers implementation of java.sql.Driver. 
 * For example, to load the my.sql.Driver class, the META-INF/services/java.sql.Driver 
 * file would contain the entry:  my.sql.Driver  
 * When the method getConnection is called, the DriverManager will attempt to 
 * locate a suitable driver from amongst those loaded at initialization 
 * and those loaded explicitly using the same classloader as the current applet or application.
 */

/*
 *  try (Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");) 
 *  {c.setAutoCommit(false);             
 *  Statement stmt = c.createStatement();             
 *  int a1 = stmt.executeUpdate("insert into STUDENT2 values (1, 'aaa', 1.1)");             
 *  Savepoint sp1 = c.setSavepoint();             
 *  int a2 = stmt.executeUpdate("insert into STUDENT2 values (2, 'bbb', 2.1)");             
 *  c.rollback();             
 *  int a3 = stmt.executeUpdate("insert into STUDENT2 values (3, 'ccc', 3.1)");             
 *  c.setAutoCommit(true);             
 *  int a4 = stmt.executeUpdate("insert into STUDENT2 values (4, 'ddd', 4.1)");         
 *  } catch (SQLException e) {             
 *  e
 *  First, the connection's auto commit mode is set to false and then two rows are inserted. 
 *  However, since autocommit is false, they are not committed yet. Now, c.rollback() is called. 
 *  This will cause the whole transaction to rollback. 
 *  Although we created a SavePoint, we did not pass it to rollback and so the save point 
 *  will have not be respected and both the rows will be lost. 
 *  This transaction ends here.  
 *  Next, row 3 is inserted in a new transaction and since autocommit is still false at this point, 
 *  it is not commited yet. The transaction is still running. 
 *  Now, when c.setAutoCommit(true) is called, the auto-commit status changes 
 *  from false to true and this causes the existing transaction to commit 
 *  thereby committing row 3.  
 *  Finally, row 4 is inserted and committed immediately because autocommit is true.  
 *  Therefore, the table will end up with 2 rows.
 * */
/*
 * A JDBC API implementation must support Entry Level SQL92 plus the SQL command Drop Table.

Entry Level SQL92 represents a "floor" for the level of SQL that a JDBC API implementation must support. 
Access to features based on SQL99 or SQL:2003 should be provided in a way that is 
compatible with the relevant part of the SQL99 or SQL:2003 specification.
 */

/*
 * 
 */


