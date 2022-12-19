package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class LoadProductServlet
 */
@WebServlet("/loadProduct")
public class LoadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		List<Category> listC = productDAO.getAllCategory();

		request.setAttribute("detail", p);
		request.setAttribute("listC", listC);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
