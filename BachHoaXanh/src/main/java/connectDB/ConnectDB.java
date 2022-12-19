package connectDB;

import model.Product;
import java.sql.*;
import java.util.List;

public class ConnectDB {
	static Connection con = null;
	static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=cklaptrinhweb;";
	static String username = "sa";
	static String password = "1234";

	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(connectionUrl, username, password);

	}

	public static void main(String[] args) {
		try {
			System.out.println(getConnect());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
