package ntp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ntp.filter.SessionHanding;

@WebServlet(name = "logoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
//		session.removeAttribute("email"); // thu hoi lai session login
		SessionHanding sessionHanding = new SessionHanding();
		sessionHanding.deleteSession(req);
		resp.sendRedirect(req.getContextPath() + "/home");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
