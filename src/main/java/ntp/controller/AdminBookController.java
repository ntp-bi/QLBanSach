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

@WebServlet(name = "adminBookController", urlPatterns = {"/book"})
public class AdminBookController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			String id = req.getParameter("id");
			String txtms = req.getParameter("txtms");
			String txtts = req.getParameter("txtts");
			String txttg = req.getParameter("txttg");
			String txtsl = req.getParameter("txtsl");
			String txtg = req.getParameter("txtg");
			String txtml = req.getParameter("txtml");
			String txta = req.getParameter("txta");
			String btnAdd = req.getParameter("btn-add");
			String btnUpdate = req.getParameter("btn-update");
			String action = req.getParameter("action");

			BookService bookService = new BookService();
			BookCategoryService bookCategoryService = new BookCategoryService();
			
			if (btnAdd != null) {			
				BookModel newSach = new BookModel();	
				newSach.setMasach(txtms);
			    newSach.setTensach(txtts);
			    newSach.setSoluong(Long.parseLong(txtsl));
			    newSach.setGia(Long.parseLong(txtg));
			    newSach.setMaloai(txtml);
			    newSach.setAnh(txta);
			    newSach.setTacgia(txttg);
				
				bookService.addSach(newSach);
			}
			if (btnUpdate != null) {
				BookModel sach = new BookModel();
				
				sach.setTensach(txtts);
				sach.setSoluong(Long.parseLong(txtsl));
				sach.setGia(Long.parseLong(txtg));
				sach.setMaloai(txtml);
				sach.setAnh(txta);
				sach.setTacgia(txttg);
				sach.setMasach(txtms);
			    
				bookService.updateSach(sach);
			}

			List<BookModel> listBook = bookService.getAllSach();
			List<BookCategoryModel> listBookCategory = bookCategoryService.getAllBookCategory();

			if (id != null && "choice".equals(action)) {
				BookModel getBookById = bookService.getSachById(id);
				req.setAttribute("getBookById", getBookById);
			}

			if (id != null && "delete".equals(action)) {
				bookService.deleteSach(id);
				resp.sendRedirect(req.getContextPath() + "/book");
				return;
			}

			req.setAttribute("listBook", listBook);
			req.setAttribute("listBookCategory", listBookCategory);

			req.getRequestDispatcher("./AdminSach.jsp").forward(req, resp);
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
