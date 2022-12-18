package edu.db;

import edu.beans.Product;

import java.sql.*;
import java.util.List;

public class ConnectionDB {
	static Connection con = null;
	static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ltw;"
			+ "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
	static String username = "sa";
	static String password = "1234";

//	public static Connection connection() throws SQLException {
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con = DriverManager.getConnection(connectionUrl, username, password);
//		}catch (ClassNotFoundException e){
//			System.out.println("-------------");
//			e.printStackTrace();
//		}
//		return null;
//	}

//	public static Statement connect() throws SQLException {
//		if (con == null || con.isClosed()) {
//			try {
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				con = DriverManager.getConnection(connectionUrl, username, password);
//				System.out.println("Connected statment");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return con.createStatement();
//		} else {
//			return con.createStatement();
//		}
//
//	}
//
	public static PreparedStatement connect(String sql) throws SQLException {
		if (con == null || con.isClosed()) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionUrl, username, password);
				System.out.println("Connected statment");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con.prepareStatement(sql);
		} else {
			return con.prepareStatement(sql);
		}

	}
//
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl, username, password);
			System.out.println("connected");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error to connect " + e.getMessage());
		}

		return con;
	}

	public void excuteSql(String sql) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(sql);
	}

	public ResultSet selectData(String sql) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getConnection());
	}

//	public static void main(String[] args) throws Exception {
//		ProductEntity pe = new ProductEntity();
//		pe.insertAll(Data.data.values());
//
//        Statement s = ConnectionDB.connect();
//        ResultSet rs = s.executeQuery("select * from user");
//        rs.last();
//        System.out.println(rs.getRow());
//        rs.beforeFirst();
//        while(rs.next()) {
//            System.out.println(rs.getString(2));
//        }
//	}
}
