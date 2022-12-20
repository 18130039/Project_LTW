package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import model.Account;

public class AccountDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public AccountDAO() {

	}

	public Account checkLogin(String userName, String password) {
		String query = "select * from account where userName=? and password=?";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account checkAccountExist(String AccountName) {
		String query = ("select * from Account where userName=?");
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, AccountName);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void register(String userName, String password, String name) throws ClassNotFoundException {
		String query = "INSERT INTO Account (userName, password, name, isSeller, isAdmin)" + "values(?,?,?,0,0);";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editAccount(String userName, String password, String name) throws ClassNotFoundException {
		String query = "UPDATE Account SET userName=?, password=?, name=? WHERE userName=?;";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, userName);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		AccountDAO accountDAO = new AccountDAO();
		System.out.println(accountDAO.checkLogin("admin", "admin"));
	}
}
