package ntp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ntp.service.CartService;

@WebServlet(name = "checkoutController", urlPatterns = { "/checkout" })
public class CheckoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(true);
		String masach = req.getParameter("id");
		String tensach = req.getParameter("name");
		String soluongmua = req.getParameter("quantity");
		String gia = req.getParameter("price");
		String anh = req.getParameter("image");

		// Lấy CartService từ session hoặc tạo mới nếu chưa có
		CartService cart = (CartService) session.getAttribute("cart");

		if (cart == null) {
			cart = new CartService();
			session.setAttribute("cart", cart);
		}

		// Thêm sản phẩm vào giỏ nếu có đầy đủ thông tin
		if (masach != null && tensach != null && soluongmua != null && gia != null) {
			cart.addToCart(masach, tensach, Long.parseLong(soluongmua), Long.parseLong(gia), anh);
		}

		req.getRequestDispatcher("./checkout.jsp").forward(req, resp);
	}
}
