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
import model.Product;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String txtSearch = request.getParameter("txtSearch");
			ProductDAO productDAO = new ProductDAO();
			Collection<Product> list = productDAO.getResult(txtSearch);
			int count = productDAO.count(txtSearch);

			String indexS = request.getParameter("index");
			int index = Integer.parseInt(indexS);

			int countPage = list.size();
			int pageSize = 16;
			int endPage = 0;
			endPage = countPage / pageSize;
			if (countPage % pageSize != 0) {
				endPage++;
			}

			List<Product> listPage = productDAO.getSearchList(txtSearch, index, pageSize);

			request.setAttribute("endPage", endPage);
			request.setAttribute("listPage", listPage);
			request.setAttribute("index", index);

			request.setAttribute("txtSearch", txtSearch);
			request.setAttribute("count", count);
			request.setAttribute("list", list);
			request.getRequestDispatcher("search.jsp").forward(request, response);

		} catch (Exception e) {
		}

	}
}
