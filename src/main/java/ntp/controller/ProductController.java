package ntp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ntp.model.BookCategoryModel;
import ntp.model.BookModel;
import ntp.service.BookCategoryService;
import ntp.service.BookService;
import ntp.service.PaginationService;

@WebServlet(name = "productController", urlPatterns = { "/product" })
public class ProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			BookService bookService = new BookService();
			BookCategoryService bookCategoryService = new BookCategoryService();
			PaginationService paginationService = new PaginationService();

			String maloai = req.getParameter("maloai");
			String name = req.getParameter("txtkey");
			String pageStr = req.getParameter("page");
			String sort = req.getParameter("sort");

			int page = (pageStr == null || pageStr.isEmpty()) ? 1 : Integer.parseInt(pageStr);
			int pageSize = 15; // Số lượng sách hiển thị trên mỗi trang
			int offset = (page - 1) * pageSize;
			int totalBooks = 0; // Biến lưu tổng số sách sau khi lọc

			List<BookModel> listBook = bookService.getAllSach();
			List<BookCategoryModel> listBookCategory = bookCategoryService.getAllBookCategory();

			if ("desc".equals(sort)) {
				listBook = bookService.getSachPriceDESC(offset, pageSize);
				totalBooks = paginationService.countBooks(); // Đếm tổng số sách trong DB
			} else if ("asc".equals(sort)) {
				listBook = bookService.getSachPriceASC(offset, pageSize);
				totalBooks = paginationService.countBooks(); // Đếm tổng số sách trong DB
			} else {
				if (maloai != null) {
					listBook = bookService.findBookByCateIdWithPagination(maloai, offset, pageSize);
					totalBooks = bookService.countBooksByCateId(maloai); // Đếm tổng số sách theo danh mục
				} else if (name != null) {
					listBook = bookService.findBookByNameWithPagination(name, offset, pageSize);
					totalBooks = bookService.countBooksByName(name); // Đếm tổng số sách theo tên tìm kiếm
				} else {
					listBook = paginationService.getAllSachWithPagination(offset, pageSize);
					totalBooks = paginationService.countBooks(); // Đếm tổng số sách trong DB
				}
			}

			int totalPages = (int) Math.ceil((double) totalBooks / pageSize);

			req.setAttribute("listBook", listBook);
			req.setAttribute("listBookCategory", listBookCategory);
			req.setAttribute("currentPage", page);
			req.setAttribute("totalPages", totalPages);

			req.getRequestDispatcher("./productPage.jsp").forward(req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
