package edu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import edu.beans.Account;
import edu.beans.Product;
import edu.db.ConnectionDB;

public class AccountDao implements ObjectDAO {
	public static Map<String, Account> mapAccount = loadData();

	public AccountDao() {

	}

	private static Map<String, Account> loadData() {
		// TODO Auto-generated method stub
		Map<String, Account> mapTemp = new HashMap<>();

		try {
			ResultSet rs = new ConnectionDB().selectData("select * from account");
			while (rs.next()) {
				String userName = rs.getString(1);
				String passWord = rs.getString(2);
				String nameOfCustomer = rs.getString(3);
				String sex = rs.getString(4);
				String phoneNumber = rs.getString(5);
				String email = rs.getString(6);
				String dayOfBirth = rs.getString(7);
				String address = rs.getString(8);
				String role = rs.getString(9);
				Account account = new Account(userName, passWord, nameOfCustomer, sex, phoneNumber, email, dayOfBirth,
						address, role);
				mapTemp.put(account.getUserName(), account);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
	}

	public boolean checkLogin(String userName, String passWord) {
		Account acc = mapAccount.get(userName);
		if (acc != null) {
			if (acc.getPassWord().equals(passWord)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		AccountDao accDao = new AccountDao();
		System.out.println(accDao.mapAccount);
		System.out.println(accDao.checkLogin("anhdinh", "anhdinh11"));
		System.out.println(accDao.checkLogin("anhdinh1", "anhdinh11"));
		System.out.println(accDao.checkLogin("anhdinh", "anhdinh11313"));
	}

	@Override
	public boolean add(Object obj) {
		Account acc = (Account) obj;
		mapAccount.put(acc.getUserName(), acc);
		String sql = "insert into account values(?,?,?,?,?,?,?,?,?)";
		Connection connection = ConnectionDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, acc.getUserName());
			preparedStatement.setString(2, acc.getPassWord());
			preparedStatement.setString(3, acc.getNameOfCustomer());
			preparedStatement.setString(4, acc.getSex());
			preparedStatement.setString(5, acc.getPhoneNumber());
			preparedStatement.setString(6, acc.getEmail());
			preparedStatement.setString(7, acc.getDayOfBirth());
			preparedStatement.setString(8, acc.getAddress());
			preparedStatement.setString(9, acc.getRole());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean edit(String id, Object obj) {
		Account acc = (Account) obj;
		mapAccount.put(acc.getUserName(), acc);
		String sql = "update account set Matkhau=?,Tenkhachhang=?,Gioitinh=?,Sodienthoai=?,Email=?,Ngaysinh=?,Diachi=?,Role=? where Tentaikhoan='"
				+ id + "'";
		Connection connection = ConnectionDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, acc.getPassWord());
			preparedStatement.setString(2, acc.getNameOfCustomer());
			preparedStatement.setString(3, acc.getSex());
			preparedStatement.setString(4, acc.getPhoneNumber());
			preparedStatement.setString(5, acc.getEmail());
			preparedStatement.setString(6, acc.getDayOfBirth());
			preparedStatement.setString(7, acc.getAddress());
			preparedStatement.setString(8, acc.getRole());
			preparedStatement.setString(9, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		mapAccount.remove(id);
		try {
			new ConnectionDB().excuteSql("delete from account where account='" + id + "'");
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean changePass(String userName, String newPass) {
		Account acc = mapAccount.get(userName);
		if (acc != null) {
			acc.setPassWord(newPass);
			mapAccount.replace(acc.getUserName(), acc);
			edit(acc.getUserName(), acc);
			return true;
		}
		return false;
	}

	public boolean checkUser(String userName) {
		Account acc = mapAccount.get(userName);
		if (acc != null) {
			if (acc.getUserName().equals(userName)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
