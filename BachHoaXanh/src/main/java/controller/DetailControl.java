package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import dao.ProductDAO;
import model.Product;

import java.io.IOException;

@WebServlet(name = "DetailControl", urlPatterns = "/detail")
public class DetailControl extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("pid");
		ProductDAO productDAO = new ProductDAO();
		Product p = null;
		try {
			p = productDAO.getById(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("detail", p);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
