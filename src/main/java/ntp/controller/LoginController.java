package ntp.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ntp.filter.AuthenHangding;
import ntp.service.AuthService;
import ntp.utils.EcryptPass;

@WebServlet(name = "loginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			if (email == null || password == null) {
				req.getRequestDispatcher("./login.jsp").forward(req, resp);
			} else {
				AuthService authService = new AuthService();
				password = EcryptPass.ecrypt(password);			

				if (authService.checkLogin(email, password)) {
					AuthenHangding authenHangding = new AuthenHangding();
					authenHangding.verifyLoginAccount(req, resp, email, password);					
					resp.sendRedirect(req.getContextPath() + "/home");
				} else {
					req.getRequestDispatcher("login.jsp?war=Email hoặc mật khẩu sai!").forward(req, resp);
				}
			}

		} catch (ServletException | IOException | NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp); // Delegate POST to GET
	}
}
