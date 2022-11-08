package edu.db;

import edu.Data;
import edu.beans.Product;
import edu.entity.ProductEntity;

import java.sql.*;
import java.util.List;

public class ConnectionDB {
    static Connection con;

    public static Statement connect() throws ClassNotFoundException, SQLException  {
        if(con==null || con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://45.252.250.6:3306/elhnhxqj_CuoiKyAnToanBaoMat?useUnicode=true&characterEncoding=utf-8", "elhnhxqj_ThuongMaiDienTu2021","^Q$J^sVgnS+Z");
            return con.createStatement();
        } else {
            return con.createStatement();
        }

    }
    public static PreparedStatement connect(String sql) throws ClassNotFoundException, SQLException  {
        if(con==null ||con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://45.252.250.6:3306/elhnhxqj_CuoiKyAnToanBaoMat?useUnicode=true&characterEncoding=utf-8", "elhnhxqj_ThuongMaiDienTu2021","^Q$J^sVgnS+Z");
            return con.prepareStatement(sql);
        } else {
            return con.prepareStatement(sql);
        }

    }


    public static void main(String[] args) throws Exception{
        ProductEntity pe= new ProductEntity();
//        pe.insertAll(Data.data.values());



//        Statement s = ConnectionDB.connect();
//        ResultSet rs = s.executeQuery("select * from user");
//        rs.last();
//        System.out.println(rs.getRow());
//        rs.beforeFirst();
//        while(rs.next()) {
//            System.out.println(rs.getString(2));
//        }
    }
}
