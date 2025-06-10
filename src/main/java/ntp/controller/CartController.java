package ntp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ntp.service.CartService;

@WebServlet(name = "cartController", urlPatterns = { "/cart" })
public class CartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(true); // Sử dụng true để tạo session nếu chưa có

		String masach = req.getParameter("id");
		String tensach = req.getParameter("name");
		String soluongmua = req.getParameter("quantity");
		String gia = req.getParameter("price");
		String anh = req.getParameter("image");

		// Lấy CartService từ session hoặc tạo mới nếu chưa có
		// Thao tác delete, update trong cart nên đặt làm session luôn
		CartService cart = (CartService) session.getAttribute("cart");

		if (cart == null) {
			cart = new CartService();
			session.setAttribute("cart", cart);
		}

		// Thêm sản phẩm vào giỏ nếu có đầy đủ thông tin
		if (masach != null && tensach != null && soluongmua != null && gia != null) {
			cart.addToCart(masach, tensach, Long.parseLong(soluongmua), Long.parseLong(gia), anh);
		}

		// Xóa hoặc cập nhật sản phẩm trong giỏ hàng
		if (masach != null) {
			if (soluongmua == null) {
				cart.deleteCartItem(masach);
			} else {
				cart.updateCartItem(masach, Long.parseLong(soluongmua));
			}
		}

		// Chuyển hướng tới trang giỏ hàng
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
