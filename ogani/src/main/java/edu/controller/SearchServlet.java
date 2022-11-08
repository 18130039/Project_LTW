package edu.controller;

import edu.beans.Product;
import edu.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String txtSearch = request.getParameter("txtSearch");
            ProductEntity pe = new ProductEntity();
            Collection<Product> list = pe.getResult(txtSearch);
            int count = pe.count(txtSearch);

            String indexS = request.getParameter("index");
            int index = Integer.parseInt(indexS);

            int countPage = list.size();
            int pageSize = 16;
            int endPage = 0;
            endPage = countPage / pageSize;
            if(countPage % pageSize != 0){
                endPage++;
            }

            List<Product> listPage = pe.getSearchList(txtSearch,index,pageSize);

            request.setAttribute("endPage",endPage);
            request.setAttribute("listPage",listPage);
            request.setAttribute("index",index);

            request.setAttribute("txtSearch",txtSearch);
            request.setAttribute("count",count);
            request.setAttribute("list",list);
            request.getRequestDispatcher("search.jsp").forward(request,response);

        } catch (Exception e){}

    }

}
