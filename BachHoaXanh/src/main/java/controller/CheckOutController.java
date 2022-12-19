package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class CheckOutController
 */
@WebServlet("/checkout")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Cart c = Cart.getCart(session);
		long total = c.total();

		String emptyAlert = "Không có sản phẩm trong giỏ hàng";
		if (total == 0.0) {
			request.setAttribute("emptyAlert", emptyAlert);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		} else {
			c.commit(session);
			response.sendRedirect("checkout.jsp");
		}
	}

}
