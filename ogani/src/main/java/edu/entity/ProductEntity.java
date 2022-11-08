package edu.entity;

import edu.beans.Account;
import edu.beans.Category;
import edu.beans.Product;
import edu.db.ConnectionDB;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProductEntity {
    public List<Product> getAll() {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            List<Product> re= new LinkedList<>();
            ResultSet rs = s.executeQuery("select * from products");
            while(rs.next()) {
                re.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getLong(6)
                ));
            }
            rs.close();
            s.close();
            return re;

        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }

    }

    public int insertAll(Collection<Product> data) {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            String sql = "insert into products (id,name,img,price,pricesale,priceLong) values ";
            int i = 0;
            for (Product d : data) {
                if( ++i < data.size())
                    sql += "(" +d.getId()+ ",\"" +d.getName()+ "\",\"" +d.getImg()+ "\",\"" +d.getPrice()+ "\",\"" +d.getPriceSale()+ "\",\""+d.getPriceLong()+ "\"),";
                else
                    sql += "(" +d.getId()+ ",\"" +d.getName()+ "\",\"" +d.getImg()+ "\",\"" +d.getPrice()+ "\",\"" +d.getPriceSale()+ "\",\""+d.getPriceLong()+ "\")";
            }
//            System.out.println(sql);
            s.executeUpdate(sql);
            s.close();
            return 0;

        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int count(String txtSearch) throws SQLException, ClassNotFoundException {
        Statement s = null;
        s = ConnectionDB.connect();

        String query = "select count(*) from products where name like "+"'%"+txtSearch+"%'";

        ResultSet rs = s.executeQuery(query);
        while(rs.next()) {
            return rs.getInt(1);
        }

        rs.close();
        s.close();
        return 0;

    }
    public List<Product> getResult(String txtSearch) throws SQLException, ClassNotFoundException {
        Statement s = null;
        s = ConnectionDB.connect();
        List<Product> re= new LinkedList<>();
        ResultSet rs = s.executeQuery("select * from products where name like "+"'%"+txtSearch+"%'");
        while(rs.next()) {
            re.add(new Product(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getLong(6)
                ));
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
            s.setString(1,id);

            ResultSet rs = s.executeQuery();
            Product p = null;
            while(rs.next()) {
                p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getLong(6)
                );
            }
            rs.close();
            s.close();
            return p;

        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + "where `user`=?\n"
                + "and pass=?";
        PreparedStatement s = null;
        try {
            s = ConnectionDB.connect(query);
            s.setString(1,user);
            s.setString(2,pass);

            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
            rs.close();
            s.close();
        } catch (Exception e){
        }
        return null;
    }
    public Account checkExist(String user) {
        String query = "select * from account\n"
                + "where `user`=?";

        PreparedStatement s = null;
        try {
            s = ConnectionDB.connect(query);
            s.setString(1,user);

            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
            rs.close();
            s.close();
        } catch (Exception e){
        }
        return null;
    }

    public void signUp(String user, String pass) {
        String sql = "INSERT INTO account(`user`,pass,isSell,isAdmin) " +
                "VALUES (?,?,0,0)";
        PreparedStatement s = null;
        try {
            s = ConnectionDB.connect(sql);
            s.setString(1,user);
            s.setString(2,pass);

            s.executeUpdate();

            s.close();
        } catch (Exception e){
        }
    }
    public void deleteProduct(String pid){
        String query = "delete from products where id = ?";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(query);
            s.setString(1,pid);
            s.executeUpdate();

        } catch (Exception e){
        }
    }

    public List<Category> getAllCategory(){
        List<Category> list = new LinkedList<>();
        String sql = "select * from category";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
            rs.close();
            s.close();
        } catch (Exception e){
        }
        return list;
    }

    public List<Product> getProductByCid(String cid){
        List<Product> list = new LinkedList<>();
        String sql = "select * from products WHERE cateId=?";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(sql);
            s.setString(1,cid);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getLong(6)
                ));
            }
            rs.close();
            s.close();
        } catch (Exception e){
        }
        return list;
    }
    public void insertProduct(String name, String img, String price,
                              String priceLong, String category) {
        String query = "INSERT INTO products (`name`, img, price, priceLong, cateId)\n" +
                "       VALUES (?, ?, ?, ?, ?)";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(query);
            s.setString(1,name);
            s.setString(2,img);
            s.setString(3,price);
            s.setString(4,priceLong);
            s.setString(5,category);

            s.executeUpdate();

        } catch (Exception e){
        }
    }
    public void insertOrder(int userID, String orderName, int total, String address,
                              String phone, String pathFile) {
        String query = "INSERT INTO `order` (userID, `name`, totalMoney, address, phone, pathFileOrder)\n" +
                "       VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(query);
            s.setInt(1, userID);
            s.setString(2, orderName);
            s.setInt(3, total);
            s.setString(4, address);
            s.setString(5, phone);
            s.setString(6, pathFile);

            s.executeUpdate();
            s.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void saveSignature(String orderName, String signature) {
        String query = "UPDATE `order` SET signatureValue=? WHERE `name`=?";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(query);
            s.setString(1, signature);
            s.setString(2, orderName);
            s.executeUpdate();
            s.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void savePublicKey(String user, String publicKey) {
        String query = "UPDATE account SET publicKey=? WHERE `user`=?";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(query);
            s.setString(1, publicKey);
            s.setString(2, user);
            s.executeUpdate();

            s.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editProduct(String name, String img, String price,
                              String priceLong, String category, String id) {
        String query = "UPDATE products\n" +
                "SET `name`=?, img=?, price=?, priceLong=?, cateId=?\n" +
                "WHERE id=?";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(query);
            s.setString(1,name);
            s.setString(2,img);
            s.setString(3,price);
            s.setString(4,priceLong);
            s.setString(5,category);
            s.setString(6,id);
            s.executeUpdate();

        } catch (Exception e){
        }
    }

    public List<Product> get5Each(int index, int size) {
        List<Product> list = new LinkedList<>();
        String sql = "with x as(select *,ROW_NUMBER() over (ORDER by id DESC) as r\n" +
                "                from products)\n" +
                "                select * from x where r between (?*?-(?-1)) and (?*?)";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(sql);
            s.setInt(1, index);
            s.setInt(2, size);
            s.setInt(3, size);
            s.setInt(4, index);
            s.setInt(5, size);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                list.add(new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("price"),
                        rs.getString("priceSale"),
                        rs.getLong("priceLong")
                ));
            }
        } catch (Exception e){
        }
        return list;
    }
    public List<Product> getSearchList(String txtSearch, int index, int size) {
        List<Product> list = new LinkedList<>();
        String sql = "with x as(select *,ROW_NUMBER() over (ORDER by id DESC) as r\n" +
                "                from products where name like ?)\n" +
                "                select * from x where r between (?*?-(?-1)) and (?*?)";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(sql);
            s.setString(1,"%"+txtSearch+"%");
            s.setInt(2, index);
            s.setInt(3, size);
            s.setInt(4, size);
            s.setInt(5, index);
            s.setInt(6, size);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                list.add(new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("price"),
                        rs.getString("priceSale"),
                        rs.getLong("priceLong")
                ));
            }
        } catch (Exception e){
        }
        return list;
    }
    public List<Product> getListByCate(int cid, int index, int size) {
        List<Product> list = new LinkedList<>();
        String sql = "with x as(select *,ROW_NUMBER() over (ORDER by id) as r\n" +
                "                from products where cateId=?)\n" +
                "                select * from x where r between (?*?-(?-1)) and (?*?)";
        PreparedStatement s = null;
        try{
            s = ConnectionDB.connect(sql);
            s.setInt(1,cid);
            s.setInt(2, index);
            s.setInt(3, size);
            s.setInt(4, size);
            s.setInt(5, index);
            s.setInt(6, size);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                list.add(new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("price"),
                        rs.getString("priceSale"),
                        rs.getLong("priceLong")
                ));
            }
        } catch (Exception e){
        }
        return list;
    }

    public static void main(String[] args) {
        ProductEntity pe = new ProductEntity();
        List<Product> listPage = pe.get5Each(1,5);
        System.out.println(listPage);
    }

    public String getPublicKeyOfUser(int userId) {
        String publicKey = "";
        String query = "select * from account\n"
                + "where `uID`=?";

        PreparedStatement s = null;
        try {
            s = ConnectionDB.connect(query);
            s.setInt(1, userId);

            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                publicKey = rs.getString(6);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return publicKey;
    }
}
