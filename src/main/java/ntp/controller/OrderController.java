package ntp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ntp.model.CartModel;
import ntp.model.UserModel;
import ntp.service.CartService;
import ntp.service.InvoiceService;

@WebServlet(name = "orderController", urlPatterns = { "/order" })
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		InvoiceService invoiceService = new InvoiceService();
		UserModel user = (UserModel) session.getAttribute("email");

		try {
			// Tạo 1 hoá đơn
			invoiceService.addInvoice(user.getMakh());
			long maHD = invoiceService.getMaInvoice();

			// Thêm vào chi tiết hoá đơn
			CartService cart = (CartService) session.getAttribute("cart");
			if (cart == null) {
				resp.sendRedirect("./cart");
			} else {
				for (CartModel gh : cart.listCart) {
					invoiceService.addInvoiceDetail(gh.getMasach(), gh.getSoluongmua(), maHD);
				}

				session.removeAttribute("cart");
				resp.sendRedirect("./history");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
