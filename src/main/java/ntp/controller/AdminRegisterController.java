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

@WebServlet(name = "adminRegisterController", urlPatterns = {"/adminRegister"})
public class AdminRegisterController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String email = req.getParameter("email");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			if (email == null || password == null || username == null) {
				req.getRequestDispatcher("./AdminRegister.jsp").forward(req, resp);
				return;
			}
			
			AuthService authService = new AuthService();
			RegisterAccountService registerAccountService = new RegisterAccountService();
			
			password = EcryptPass.ecrypt(password);
			
			if(authService.checkExistingOfKhachHangByEmail(email)) {
				req.getRequestDispatcher("./AdminRegister.jsp?war=Tài khoản đã tồn tại !").forward(req, resp);
			}else {
				registerAccountService.Dangky(username, null, null, email, username, password);
				req.getRequestDispatcher("./AdminRegister.jsp?war=Đăng ký thành công!").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
