package edu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import edu.beans.*;
import edu.db.ConnectionDB;

public class ProductsDao implements ObjectDAO {
	public static Map<String, Product> mapProduct = loadData();

	public ProductsDao() {

	}

	private static Map<String, Product> loadData() {
		// TODO Auto-generated method stub
		Map<String, Product> mapTemp = new HashMap<>();

		try {
			ResultSet rs = new ConnectionDB().selectData("select * from products");
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String img = rs.getString(3);
				String price = rs.getString(4);
				Long priceLong = rs.getLong(5);
				int quantity = rs.getInt(6);
				Product product = new Product(id, name, img, price, priceLong, quantity);
				mapTemp.put(product.getId(), product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
	}

	public static void main(String[] args) {
		ProductsDao dao = new ProductsDao();
		System.out.println(dao.mapProduct);
	}

	@Override
	public boolean add(Object obj) {
		Product product = (Product) obj;
		mapProduct.put(product.getId(), product);
		String sql = "insert into products values(?,?,?,?,?,?)";
		Connection connection = ConnectionDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getImg());
			preparedStatement.setString(4, product.getPrice());
			preparedStatement.setLong(5, product.getPriceLong());
			preparedStatement.setInt(6, product.getQuantity());
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
		Product product = (Product) obj;
		mapProduct.put(product.getId(), product);
		String sql = "update products set name=?,img=?,price=?,pricelong=?,quantity=? where id='" + id + "'";
		Connection connection = ConnectionDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getImg());
			preparedStatement.setString(3, product.getPrice());
			preparedStatement.setLong(4, product.getPriceLong());
			preparedStatement.setInt(5, product.getQuantity());
			preparedStatement.setString(6, id);
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
		mapProduct.remove(id);
		try {
			new ConnectionDB().excuteSql("delete from products where products='" + id + "'");
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
