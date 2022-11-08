package edu.controller;

import edu.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckoutControl", urlPatterns = "/checkout")
public class CheckoutControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Cart c = Cart.getCart(session);
        long total = c.total();

        String emptyAlert = "Không có sản phẩm trong giỏ hàng";
        if(true) {
        	response.sendRedirect("checkout.jsp");
        } else {
            c.commit(session);
            
        }
    }
}
