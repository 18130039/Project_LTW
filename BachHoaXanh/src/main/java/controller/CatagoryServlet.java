package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class CatagoryServlet
 */
@WebServlet("/category")
public class CatagoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String cateId = request.getParameter("cid");
		int cid = Integer.parseInt(cateId);
		ProductDAO productDAO = new ProductDAO();
		List<Product> list = productDAO.getProductByCid(cateId);

		String indexS = request.getParameter("index");
		int index = Integer.parseInt(indexS);

		int countPage = list.size();
		int pageSize = 16;
		int endPage = 0;
		endPage = countPage / pageSize;
		if (countPage % pageSize != 0) {
			endPage++;
		}
		List<Product> listPage = productDAO.getListByCate(cid, index, pageSize);

		request.setAttribute("endPage", endPage);
		request.setAttribute("listPage", listPage);
		request.setAttribute("index", index);
		request.setAttribute("cid", cid);

		request.setAttribute("listP", list);
		request.getRequestDispatcher("meat.jsp").forward(request, response);
	}
}
