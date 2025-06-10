package ntp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ntp.model.BookModel;
import ntp.service.BookService;

@WebServlet(name = "productDetailController", urlPatterns = { "/product-detail" })
public class ProductDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String id = req.getParameter("id");
			BookService bookService = new BookService();

			if (id != null) {
				BookModel book = bookService.getSachById(id); 
				req.setAttribute("book", book); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/productDetail.jsp").forward(req, resp); 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
