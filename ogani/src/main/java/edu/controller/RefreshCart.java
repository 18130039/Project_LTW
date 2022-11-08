package edu.controller;

import edu.beans.Product;
import edu.entity.ProductEntity;
import edu.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "RefreshCart", urlPatterns = "/refresh")
public class RefreshCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cart c = Cart.getCart(session);
        long total = c.total();
        request.setAttribute("total", total);
        c.commit(session);

        response.sendRedirect("cart.jsp");
    }
}
