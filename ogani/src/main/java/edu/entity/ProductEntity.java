package edu.entity;

import edu.beans.Account;
import edu.beans.Category;
import edu.beans.Product;
import edu.db.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProductEntity {

	public int count(String txtSearch) throws SQLException, ClassNotFoundException {
		Statement s = null;
//		s = ConnectionDB.connect();

		String query = "select count(*) from products where name like " + "'%" + txtSearch + "%'";

		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			return rs.getInt(1);
		}

		rs.close();
		s.close();
		return 0;

	}

	public List<Product> getResult(String txtSearch) throws SQLException, ClassNotFoundException {
		Statement s = null;
//		s = ConnectionDB.connect();
		List<Product> re = new LinkedList<>();
		ResultSet rs = s.executeQuery("select * from products where name like " + "'%" + txtSearch + "%'");
		while (rs.next()) {
			re.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
					rs.getInt(6)));
		}
		rs.close();
		s.close();
		return re;
	}

	public Product getById(String id) {
		PreparedStatement s = null;
		try {
			String sql = "select * from products where id=?";
			s = ConnectionDB.connect(sql);
			s.setString(1, id);

			ResultSet rs = s.executeQuery();
			Product p = null;
			while (rs.next()) {
				p = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getInt(6));
			}
			rs.close();
			s.close();
			return p;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void signUp(String user, String pass) {
		String sql = "INSERT INTO account(`user`,pass,isSell,isAdmin) " + "VALUES (?,?,0,0)";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(sql);
			s.setString(1, user);
			s.setString(2, pass);

			s.executeUpdate();

			s.close();
		} catch (Exception e) {
		}
	}

	public void deleteProduct(String pid) {
		String query = "delete from products where id = ?";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(query);
			s.setString(1, pid);
			s.executeUpdate();

		} catch (Exception e) {
		}
	}

	public List<Category> getAllCategory() {
		List<Category> list = new LinkedList<>();
		String sql = "select * from category";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(sql);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
			s.close();
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getProductByCid(String cid) {
		List<Product> list = new LinkedList<>();
		String sql = "select * from products WHERE cateId=?";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(sql);
			s.setString(1, cid);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getInt(6)));
			}
			rs.close();
			s.close();
		} catch (Exception e) {
		}
		return list;
	}

	public void insertProduct(String name, String img, String price, String priceSale, String category) {
		String query = "INSERT INTO products (`name`, img, price, priceSale, cateId)\n"
				+ "       VALUES (?, ?, ?, ?, ?)";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(query);
			s.setString(1, name);
			s.setString(2, img);
			s.setString(3, price);
			s.setString(4, priceSale);
			s.setString(5, category);

			s.executeUpdate();

		} catch (Exception e) {
		}
	}

	public void insertOrder(int userID, String orderName, int total, String address, String phone, String pathFile) {
		String query = "INSERT INTO `order` (userID, `name`, totalMoney, address, phone, pathFileOrder)\n"
				+ "       VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(query);
			s.setInt(1, userID);
			s.setString(2, orderName);
			s.setInt(3, total);
			s.setString(4, address);
			s.setString(5, phone);
			s.setString(6, pathFile);

			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editProduct(String name, String img, String price, String priceSale, String category, String id) {
		String query = "UPDATE products\n" + "SET `name`=?, img=?, price=?, priceSale=?, cateId=?\n" + "WHERE id=?";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(query);
			s.setString(1, name);
			s.setString(2, img);
			s.setString(3, price);
			s.setString(4, priceSale);
			s.setString(5, category);
			s.setString(6, id);
			s.executeUpdate();

		} catch (Exception e) {
		}
	}

	public List<Product> get5Each(int index, int size) {
		List<Product> list = new LinkedList<>();
		String sql = "with x as(select *,ROW_NUMBER() over (ORDER by id DESC) as r\n"
				+ "                from products)\n"
				+ "                select * from x where r between (?*?-(?-1)) and (?*?)";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(sql);
			s.setInt(1, index);
			s.setInt(2, size);
			s.setInt(3, size);
			s.setInt(4, index);
			s.setInt(5, size);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString("id"), rs.getString("name"), rs.getString("img"),
						rs.getString("price"), rs.getLong("priceLong"), rs.getInt("quantity")));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getSearchList(String txtSearch, int index, int size) {
		List<Product> list = new LinkedList<>();
		String sql = "with x as(select *,ROW_NUMBER() over (ORDER by id DESC) as r\n"
				+ "                from products where name like ?)\n"
				+ "                select * from x where r between (?*?-(?-1)) and (?*?)";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(sql);
			s.setString(1, "%" + txtSearch + "%");
			s.setInt(2, index);
			s.setInt(3, size);
			s.setInt(4, size);
			s.setInt(5, index);
			s.setInt(6, size);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString("id"), rs.getString("name"), rs.getString("img"),
						rs.getString("price"), rs.getLong("priceLong"), rs.getInt("quantity")));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getListByCate(int cid, int index, int size) {
		List<Product> list = new LinkedList<>();
		String sql = "with x as(select *,ROW_NUMBER() over (ORDER by id) as r\n"
				+ "                from products where cateId=?)\n"
				+ "                select * from x where r between (?*?-(?-1)) and (?*?)";
		PreparedStatement s = null;
		try {
//			s = ConnectionDB.connect(sql);
			s.setInt(1, cid);
			s.setInt(2, index);
			s.setInt(3, size);
			s.setInt(4, size);
			s.setInt(5, index);
			s.setInt(6, size);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString("id"), rs.getString("name"), rs.getString("img"),
						rs.getString("price"), rs.getLong("priceLong"), rs.getInt("quantity")));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ProductEntity pe = new ProductEntity();
		System.out.println(pe.getAllCategory());
	}

}
