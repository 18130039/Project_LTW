package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class DesCartServlet
 */
@WebServlet("/desCart")
public class DesCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null)
			response.sendRedirect("home");
		ProductDAO productDAO = new ProductDAO();
		Product p = null;
		try {
			p = productDAO.getById(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (p == null) {
			response.sendRedirect("home");
			return;
		}

		HttpSession session = request.getSession();

		Cart c = Cart.getCart(session);
		String quantityS = request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityS);
		if (quantity > 1) {
			c.sub(p);
		} else {
			c.remove(id);
		}

		c.commit(session);
		response.sendRedirect("cart.jsp");
	}
}
