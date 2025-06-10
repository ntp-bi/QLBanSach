package ntp.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ntp.model.LoginModel;
import ntp.model.UserModel;
import ntp.payload.Response;
import ntp.service.AuthService;

public class AuthenHangding {
	private static final String SESSION_EMAIL = "email";

	// Get user info from session
	public Response getUserInfo(HttpServletRequest req) {
		Response response = new Response();
		HttpSession session = req.getSession(false); // false để không tạo session mới nếu không tồn tại

		if (session != null) {
			String email = (String) session.getAttribute(SESSION_EMAIL);

			if (email != null) {
				AuthService authService = new AuthService();
				UserModel khachHang = authService.getKhachHangByEmail(email);

				if (khachHang != null) {
					response.setStatus(200);
					response.setMessage("Lấy thông tin khách hàng thành công!");
					response.setData(khachHang);

					return response;
				} else {
					response.setMessage("Lấy thông tin khách hàng thất bại!");
				}
			} else {
				response.setMessage("Email không tồn tại trong session");
			}
		} else {
			response.setMessage("Session không tồn tại");
		}

		response.setStatus(404);
		response.setData(null);
		return response;
	}

	// Log out user by invalidating session
	public Response logOut(HttpServletRequest req, HttpServletResponse resp) {
		Response response = new Response();
		HttpSession session = req.getSession(false);

		if (session != null) {
			session.invalidate(); // Invalidate the session to log out
			response.setStatus(200);
			response.setMessage("Đăng xuất thành công");
			response.setData(true);
		} else {
			response.setStatus(400);
			response.setMessage("Không tìm thấy session, đăng xuất thất bại");
			response.setData(false);
		}
		return response;
	}

	// Verify login and store email in session
	public Response verifyLoginAccount(HttpServletRequest req, HttpServletResponse resp, String email,
			String password) {
		Response response = new Response();
		AuthService authService = new AuthService();

		if (authService.checkLogin(email, password)) {
			HttpSession session = req.getSession(true); // Lấy session mới hoặc hiện tại
			UserModel khachHang = authService.getKhachHangByEmail(email);
			session.setAttribute(SESSION_EMAIL, khachHang); // Lưu email vào session
			System.out.println("Đăng nhập thành công: " + khachHang);
			
			response.setStatus(200);
			response.setMessage("Đăng nhập thành công");
			response.setData(true);
		} else {
			response.setStatus(200);
			response.setMessage("Đăng nhập thất bại");
			response.setData(false);
		}
		return response;
	}

	// Check if user is logged in by checking session
	public boolean isLoggedIn(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		return session != null && session.getAttribute(SESSION_EMAIL) != null;
	}

	// Get role of user from session
	public int getRoleOfUser(HttpServletRequest req) {
		HttpSession session = req.getSession(false);

		if (session != null) {
			LoginModel dangNhapModel = (LoginModel) session.getAttribute(SESSION_EMAIL);

			if (dangNhapModel != null) {
				return dangNhapModel.isQuyen() ? 1 : 2;
			}
		}
		return -1;
	}
}
