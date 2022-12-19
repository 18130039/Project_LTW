package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String img = request.getParameter("image");
		String price = request.getParameter("price");
		String priceLong = request.getParameter("title");
		String quantity = request.getParameter("quantity");
		String cateId = request.getParameter("category");

		ProductDAO productDAO = new ProductDAO();
		productDAO.insertProduct(id, name, img, price, priceLong, quantity, cateId);
		response.sendRedirect("manage?index=1");
	}

}
