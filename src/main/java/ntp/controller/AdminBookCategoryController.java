package ntp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ntp.model.BookCategoryModel;
import ntp.service.BookCategoryService;

@WebServlet(name = "adminBookCategory", urlPatterns = { "/category" })
public class AdminBookCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			String id = req.getParameter("id");
			String txtml = req.getParameter("maloai");
			String txttl = req.getParameter("tenloai");
			String btnAdd = req.getParameter("btn-add");
			String btnUpdate = req.getParameter("btn-update");
			String action = req.getParameter("action");

			BookCategoryService bookCategoryService = new BookCategoryService();

			if (btnAdd != null) {
				bookCategoryService.addBookCategory(txtml, txttl);
			}
			if (btnUpdate != null) {
				bookCategoryService.updateBookCategory(txtml, txttl);
			}

			List<BookCategoryModel> listBookCategory = bookCategoryService.getAllBookCategory();

			if (id != null && "choice".equals(action)) {
				BookCategoryModel getBookCategoryById = bookCategoryService.getBookCategoryById(id);
				req.setAttribute("getBookCategoryById", getBookCategoryById);
			}

			if (id != null && "delete".equals(action)) {
				bookCategoryService.deleteBookCategory(id);
				resp.sendRedirect(req.getContextPath() + "/category");
				return;
			}

			req.setAttribute("listBookCategory", listBookCategory);

			req.getRequestDispatcher("./Adminloai.jsp").forward(req, resp);
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
