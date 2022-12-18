package edu.controller;

import edu.Dao.AccountDao;
import edu.beans.Account;
import edu.entity.ProductEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginControl", urlPatterns = "/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1;

	public LoginControl() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("action");
		if (action == null) {
			System.out.println("khong thuc hien duoc gi");
		} else if (action.equals("Login")) {
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			if (new AccountDao().checkLogin(userName, passWord)) {
				HttpSession session = request.getSession();
				Account acc = AccountDao.mapAccount.get(userName);
				session.setAttribute("userlogin", acc);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		} else if (action.equals("Register")) {
			String userName = request.getParameter("username");
			String email = request.getParameter("email");
			String passWord = request.getParameter("password");
			String re_passWord = request.getParameter("repassword");
			String nameOfUser = request.getParameter("nameofuser");

			if (new AccountDao().checkUser(userName)) {
				request.setAttribute("mess", "Tai khoan da ton tai");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			} else {
				Account newAccount = new Account(userName, re_passWord, nameOfUser, "", "", email, "", "", "");
				newAccount.setUserName(userName);
				newAccount.setPassWord(passWord);
				newAccount.setNameOfCustomer(nameOfUser);
				newAccount.setEmail(email);
				new AccountDao().add(newAccount);

			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("Logout")) {
			HttpSession httpSession = request.getSession();
			httpSession.invalidate();
			response.sendRedirect("home");

		}

	}
}
