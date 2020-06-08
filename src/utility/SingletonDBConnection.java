package utility;
import java.sql.*;


public class SingletonDBConnection {

	private static Connection connection;
	private SingletonDBConnection() {
	}
	
	private static Connection getConnectionInstance() throws ClassNotFoundException {
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzasakantodb","root", "");
			} catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
			return connection;
	}
	
	public static Connection getConnection() throws ClassNotFoundException {
		return (connection == null)
				? getConnectionInstance()
				: connection;
	}
}
