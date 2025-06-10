package ntp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ntp.model.OrderModel;
import ntp.model.UserModel;
import ntp.service.OrderService;
import ntp.utils.EmailUtil;

@WebServlet(name = "adminHomeControler", urlPatterns = { "/admin" })
public class AdminHomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			String id = req.getParameter("id");
			String action = req.getParameter("action");

			OrderService orderService = new OrderService();

			if (id != null && action != null) {
				if ("delete".equals(action)) {
					long maHoaDon = Long.parseLong(id);
					orderService.deleteOrder(maHoaDon);
				} else if ("accept".equals(action)) {
					long maChiTietHD = Long.parseLong(id);
					orderService.acceptOrder(maChiTietHD);

				}
			}

			// Sau khi thực hiện xong, bạn có thể load lại danh sách đơn hàng
			List<OrderModel> listOrder = new ArrayList<OrderModel>();
			listOrder = orderService.getAllOrder();
			req.setAttribute("listOrder", listOrder);

		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("./AdminXacNhan.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
