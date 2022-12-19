package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
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
		AccountDAO accDAO = new AccountDAO();
		if (action == null) {
			System.out.println("khong thuc hien duoc gi");
		} else if (action.equals("Login")) {
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			Account acc = accDAO.checkLogin(userName, passWord);
			if (acc == null) {
				request.setAttribute("mess", "Sai thong tin dang nhap");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("acc", acc);

				Cookie cookieUser = new Cookie("UserCookie", userName);
				Cookie cookiePassword = new Cookie("PasswordCookie", passWord);

				cookieUser.setMaxAge(60 * 60 * 24);
				cookiePassword.setMaxAge(60 * 60 * 24);

				response.addCookie(cookieUser);
				response.addCookie(cookiePassword);

				// request.getRequestDispatcher("HomeServlet").forward(request, response);
				response.sendRedirect("index.jsp");
				;
			}
		} else if (action.equals("Register")) {

			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			String name = request.getParameter("name");
			if (!password.equals(repassword)) {
				request.setAttribute("mess", "Mật khẩu không khớp");
				response.sendRedirect("signup.jsp");
			} else {
				try {
					Account usercheck = accDAO.checkAccountExist(userName);
					request.setAttribute("exit", "Tài khoản đã tồn tại");

					if (usercheck == null) {
						accDAO.register(userName, password, name);
						response.sendRedirect("login.jsp");
					} else {
						response.sendRedirect("signup.jsp");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (action.equals("Logout")) {
			HttpSession httpSession = request.getSession();
			httpSession.invalidate();
			response.sendRedirect("home");

		}

	}

}
