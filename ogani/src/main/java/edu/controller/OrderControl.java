package edu.controller;

import edu.beans.Account;
import edu.beans.Product;
import edu.entity.ProductEntity;
import edu.model.Cart;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Collection;

@WebServlet(name = "OrderControl", urlPatterns = "/order")
public class OrderControl extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("ten");
        String address = request.getParameter("add1");
        String phone = request.getParameter("phone");
        String sanpham = "";

        HttpSession session = request.getSession();
        Cart c = Cart.getCart(session);
        Collection<Product> data = c.getData();
        long total = c.total();
        int tongTien = (int) total;
        String tong = (total/1000 + 40.0) + "00Ä‘";

        Account account = (Account) session.getAttribute("acc");
        int userId = account.getId();
        String folderName = String.valueOf(userId);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String createTime = dtf.format(now);

        String fileName = folderName + "_" + createTime;
        session.setAttribute("orderName", fileName);

        for(Product item: data){
            sanpham += item.toString() + "\n";
        }

        request.setAttribute("ten", name);
        request.setAttribute("diachi", address);
        request.setAttribute("dienthoai", phone);
        request.setAttribute("sanpham", sanpham);

        String billDetail = "KhÃ¡ch hÃ ng: " + name + "\n"
                + "Ä�á»‹a chá»‰ giao hÃ ng: " + address + "\n"
                + "Ä�iá»‡n thoáº¡i: " + phone + "\n" + "\n"
                + "Sáº£n pháº©m: " + sanpham + "\n"
                + "PhÃ­ giao hÃ ng: 40.000Ä‘" + "\n"
                + "Tá»•ng cá»™ng: " + tong;

        // create bill
        File file = new File(getServletContext().getRealPath("hoadon/"+ folderName + "/" + fileName + ".txt"));
        FileUtils.writeStringToFile(file, billDetail, "UTF-8");
        ProductEntity pe = new ProductEntity();
        pe.insertOrder(userId, fileName, tongTien, address, phone, "hoadon/"+folderName+"/"+fileName);


        request.getRequestDispatcher("order.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
