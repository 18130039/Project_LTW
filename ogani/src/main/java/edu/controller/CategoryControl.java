package edu.controller;

import edu.beans.Category;
import edu.beans.Product;
import edu.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "CategoryControl", urlPatterns = "/category")
public class CategoryControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cateId = request.getParameter("cid");
        int cid = Integer.parseInt(cateId);
        ProductEntity pe = new ProductEntity();
        List<Product> list = pe.getProductByCid(cateId);

        String indexS = request.getParameter("index");
        int index = Integer.parseInt(indexS);

        int countPage = list.size();
        int pageSize = 16;
        int endPage = 0;
        endPage = countPage / pageSize;
        if(countPage % pageSize != 0){
            endPage++;
        }
        List<Product> listPage = pe.getListByCate(cid,index,pageSize);

        request.setAttribute("endPage",endPage);
        request.setAttribute("listPage",listPage);
        request.setAttribute("index",index);
        request.setAttribute("cid",cid);

        request.setAttribute("listP",list);
        request.getRequestDispatcher("meat.jsp").forward(request,response);
    }
}
