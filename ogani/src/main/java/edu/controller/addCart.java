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

@WebServlet(name = "addCart", urlPatterns = "/addCart")
public class addCart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null)
			response.sendRedirect("home");
		ProductEntity pe = new ProductEntity();
		Product p = pe.getById(id);
		if (p == null) {
			response.sendRedirect("home");
			return;
		}
	}
}
