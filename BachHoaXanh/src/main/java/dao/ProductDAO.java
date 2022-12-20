package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import connectDB.ConnectDB;
import model.Category;
import model.Product;

public class ProductDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public List<Product> getAll() throws ClassNotFoundException {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM Product;";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Product> getResult(String txtSearch) throws SQLException, ClassNotFoundException {
		con = ConnectDB.getConnect();
		List<Product> re = new LinkedList<>();
		ResultSet rs = ps.executeQuery("select * from Product where pName like " + "'%" + txtSearch + "%'");
		while (rs.next()) {
			re.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
					rs.getInt(6), rs.getString(7)));
		}
		return re;
	}

	public Product getById(String id) throws ClassNotFoundException {
		try {
			String sql = "select * from Product where pId=?";
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			Product p = null;
			while (rs.next()) {

				p = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7));
			}
			rs.close();
			ps.close();
			return p;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteProduct(String pid) {
		String sql = "delete from products where id = ?";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			ps.setString(1, pid);
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

	public List<Category> getAllCategory() {
		List<Category> list = new LinkedList<>();
		String sql = "select * from category";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getString(1), rs.getString(2)));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getProductByCid(String cid) {
		List<Product> list = new LinkedList<>();
		String sql = "select * from Product WHERE cateId=?";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			ps.setString(1, cid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
		}
		return list;
	}

	public void insertProduct(String id, String name, String img, String price, String priceLong, String quantity,
			String cate) {
		String query = "INSERT INTO Product (pId, pName, pImg, pPrice, pPriceLong, quantity, cateId  ) VALUES (?,?,?,?,?,?,?)";

		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, img);
			ps.setString(4, price);
			ps.setString(5, priceLong);
			ps.setString(6, quantity);
			ps.setString(7, cate);

			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

	public void insertOrder(String userName, String orderName, int total, String address, String phone) {
		String query = "INSERT INTO Order (userName, orderName, totalMoney, address, phone) VALUES (?,?,?,?,?)";

		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, orderName);
			ps.setInt(3, total);
			ps.setString(4, address);
			ps.setString(5, phone);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editProduct(String id, String name, String img, String price, String priceLong, String cate) {
		String query = "UPDATE Product SET pName=?, pImg=?, pPrice=?, pPriceLong=?, cateId=? WHERE pId=?;";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, img);
			ps.setString(3, price);
			ps.setString(4, priceLong);
			ps.setString(6, cate);
			ps.setString(7, id);

			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

	public List<Product> searchByName(String txtSearch) {
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM Product WHERE pName LIKE ?;";
		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}

	public List<Product> get5Each(int index, int size) {
		List<Product> list = new LinkedList<>();
		String sql = "with x as(select *,ROW_NUMBER() over (ORDER by pId ASC) as r\n"
				+ "                from Product)\n"
				+ "                select * from x where r between (?*?-(?-1)) and (?*?)";

		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, size);
			ps.setInt(3, size);
			ps.setInt(4, index);
			ps.setInt(5, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getListByCate(int cid, int index, int size) {
		List<Product> list = new LinkedList<>();
		String sql = "with x as(select *,ROW_NUMBER() over (ORDER by pId) as r\n"
				+ "                from Product where cateId=?)\n"
				+ "                select * from x where r between (?*?-(?-1)) and (?*?)";

		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, index);
			ps.setInt(3, size);
			ps.setInt(4, size);
			ps.setInt(5, index);
			ps.setInt(6, size);
			ps.setInt(7, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getSearchList(String txtSearch, int index, int size) {
		List<Product> list = new LinkedList<>();
		String sql = "with x as(select *,ROW_NUMBER() over (ORDER by pId DESC) as r\n"
				+ "                from Product where name like ?)\n"
				+ "                select * from x where r between (?*?-(?-1)) and (?*?)";

		try {
			con = ConnectDB.getConnect();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + txtSearch + "%");
			ps.setInt(2, index);
			ps.setInt(3, size);
			ps.setInt(4, size);
			ps.setInt(5, index);
			ps.setInt(6, size);
			ps.setInt(7, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public int count(String txtSearch) throws SQLException, ClassNotFoundException {

		String query = "select count(*) from Product where pName like " + "'%" + txtSearch + "%'";
		con = ConnectDB.getConnect();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			return rs.getInt(1);
		}

		rs.close();
		ps.close();
		return 0;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ProductDAO productDAO = new ProductDAO();
		System.out.println(productDAO.getAll());

	}
}
