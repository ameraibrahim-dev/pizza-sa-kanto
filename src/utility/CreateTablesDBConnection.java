package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTablesDBConnection {

	private static Connection connection;

	private CreateTablesDBConnection() {
	}

	private static Connection getConnectionInstance() throws ClassNotFoundException {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return connection;
	}

	public static Connection getConnection() throws ClassNotFoundException {
		return (connection == null) ? getConnectionInstance() : connection;
	}
}
