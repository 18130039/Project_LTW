package controller;

import java.io.IOException;
import java.util.Collection;
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
 * Servlet implementation class ShopGridServlet
 */
@WebServlet("/shopGrid")
public class ShopGridServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		Collection<Product> list = null;
		try {
			list = productDAO.getAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Category> listC = productDAO.getAllCategory();

		String indexS = request.getParameter("index");
		int index = Integer.parseInt(indexS);

		int count = list.size();
		int pageSize = 16;
		int endPage = 0;
		endPage = count / pageSize;
		if (count % pageSize != 0) {
			endPage++;
		}

		List<Product> listPage = productDAO.get5Each(index, pageSize);

		request.setAttribute("endPage", endPage);
		request.setAttribute("listPage", listPage);
		request.setAttribute("index", index);
		request.setAttribute("listC", listC);
		request.setAttribute("list", list);
		request.getRequestDispatcher("shopgrid.jsp").forward(request, response);
	}

}
