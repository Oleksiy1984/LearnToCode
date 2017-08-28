package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Letuchka {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/leransql?useSSL=false", "newuser",
				"123456");
				Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery("SELECT * FROM test");
				PreparedStatement preparedStatement = conn.prepareStatement("update test set salary = ? where name=?");) {

			preparedStatement.setInt(1, 100);
			preparedStatement.setString(2, "Bob");
			preparedStatement.executeUpdate();
			preparedStatement.setString(2, "Zein");
			preparedStatement.executeUpdate();
			rs.absolute(6);
			rs.first();
			System.out.println(rs.getString(2));
			
		}
	}
}
