package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {
	
	
	private static final String insert ="insert into test (name) values (?)"; 
	private static final String update ="UPDATE test SET name=? WHERE id=?"; 

	public static void main(String[] args) throws SQLException {
		
		//1.Загрузка класса драйвера
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try (
				//2. Установка соединения с БД, автоматическая
				//регистрация драйвера
				Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/leransql?useSSL=false", "newuser",
				"123456");
				//3. Создание объекта для передачи запросов - Statement.
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//4. Выполнение запроса.
				ResultSet rs = stmt.executeQuery("SELECT * FROM test");
				PreparedStatement preparedStatement = conn.prepareStatement("select * from test where id=?");
				PreparedStatement preparedStatement2 = conn.prepareStatement(update)
						
				)
		{

			//5. Обработка результатов выполненя запроса
			//6. Закрытие ресурсов в обратном порядке.
			//rs.beforeFirst(); runtime error
			//rs.afterLast();
			//rs.first();
			
			/*
			//update ROW with ResultSet
			rs.next();//always
			rs.absolute(2);//2
			rs.relative(-1);//1
			rs.updateString(2, "Oleks");
			rs.updateRow();
			
			//insert ROW with ResultSet
			rs.moveToInsertRow();
			rs.updateString(2, "f");
			rs.insertRow();
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			*/
			
			//PrepearedStatement retrieve data
			preparedStatement.setInt(1, 3);
			ResultSet rs2 = preparedStatement.executeQuery();
			rs2.next();
			System.out.println(rs2.getInt(1)+" "+rs2.getString(2));
			/*
			//PrepearedStatement insert the record
			preparedStatement2.setString(1, "Andy");
			int result = preparedStatement2.executeUpdate();
						if(result==1)
			System.out.println("Insert succesfull "+result+" row added");
			else
				System.err.println("error "+result);
				*/
			//PrepearedStatement update the record
			preparedStatement2.setString(1, "Wahid");
			preparedStatement2.setInt(2, 1);
			int result = preparedStatement2.executeUpdate();
						if(result==1)
			System.out.println("Update succesfull "+result+" row updated");
			else
				System.err.println("error "+result);
		}

	}

}
