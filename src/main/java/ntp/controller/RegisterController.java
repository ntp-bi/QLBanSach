package ntp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ntp.service.AuthService;
import ntp.service.RegisterAccountService;
import ntp.utils.EcryptPass;

@WebServlet(name = "registerController", urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String username = req.getParameter("username");

			if (email == null || password == null || username == null) {
				req.getRequestDispatcher("register.jsp").forward(req, resp);
				return;
			}

			AuthService authService = new AuthService();
			RegisterAccountService registerAccountService = new RegisterAccountService();

			password = EcryptPass.ecrypt(password);

			if (authService.checkExistingOfKhachHangByEmail(email)) {
				req.getRequestDispatcher("register.jsp?war=Tài khoản đã tồn tại!").forward(req, resp);
			} else {
				registerAccountService.Dangky(username, null, null, email, username, password);
				req.getRequestDispatcher("register.jsp?war=Đăng ký thành công!").forward(req, resp);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp); // Delegate POST to GET
	}
}
