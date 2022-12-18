package edu.controller;

import edu.beans.Account;
import edu.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

@WebServlet(name = "SignUpControl", urlPatterns = "/signup")
public class SignUpControl extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("repass");
		if (!pass.equals(re_pass)) {
			request.setAttribute("mess", "Mật khẩu nhập lại không khớp");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else {
			ProductEntity pe = new ProductEntity();
			Account a = pe.checkExist(user);
			if (a == null) {
				pe.signUp(user, pass);
				a = pe.login(user, pass);

				HttpSession session = request.getSession();
				session.setAttribute("acc", a);

			} else {
				request.setAttribute("mess", "Email đã được sử dụng");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
	}
}
