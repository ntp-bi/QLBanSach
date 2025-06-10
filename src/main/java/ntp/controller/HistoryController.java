package ntp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ntp.model.HistoryModel;
import ntp.model.UserModel;
import ntp.service.HistoryService;

@WebServlet(name = "historyController", urlPatterns = { "/history" })
public class HistoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			HttpSession session = req.getSession();
			UserModel user = (UserModel) session.getAttribute("email");

			HistoryService historyService = new HistoryService();

			List<HistoryModel> listHistory = historyService.getHistoryByCustomerId(user.getMakh());
			req.setAttribute("listHistory", listHistory);
			
			req.getRequestDispatcher("./historyPurchase.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
