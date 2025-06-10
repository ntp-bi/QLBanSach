package ntp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ntp.model.BookModel;
import ntp.repository.BookRepository;

public class BookService {
	BookRepository bookRepository = new BookRepository();
	List<BookModel> listBook = new ArrayList<BookModel>();

	public List<BookModel> findBookByCateIdWithPagination(String maloai, int offset, int pageSize) throws Exception {
		List<BookModel> ds = new ArrayList<BookModel>();
		int count = 0; // Để đếm số sách đã thêm vào danh sách kết quả

		for (BookModel book : listBook) {
			if (book.getMaloai().trim().equalsIgnoreCase(maloai.trim())) {
				if (count >= offset && ds.size() < pageSize) {
					ds.add(book);
				}
				count++;
			}
		}

		return ds;
	}

	// Đếm số sách theo danh mục
	public int countBooksByCateId(String maloai) throws SQLException {
		int count = 0;
		for (BookModel book : listBook) {
			if (book.getMaloai().trim().equalsIgnoreCase(maloai.trim())) {
				count++;
			}
		}
		return count;
	}

	public List<BookModel> findBookByNameWithPagination(String name, int offset, int pageSize) {
		List<BookModel> ds = new ArrayList<BookModel>();
		int count = 0; // Đếm số sách đã thêm vào danh sách kết quả

		for (BookModel book : listBook) {
			if (book.getTensach().toLowerCase().trim().contains(name.toLowerCase().trim())
					|| book.getTacgia().toLowerCase().trim().contains(name.toLowerCase().trim())) {
				if (count >= offset && ds.size() < pageSize) {
					ds.add(book);
				}
				count++;
			}
		}

		return ds;
	}

	// Đếm số sách theo tên tìm kiếm
	public int countBooksByName(String name) throws SQLException {
		int count = 0;
		for (BookModel book : listBook) {
			if (book.getTensach().toLowerCase().trim().contains(name.toLowerCase().trim())
					|| book.getTacgia().toLowerCase().trim().contains(name.toLowerCase().trim())) {
				count++;
			}
		}
		return count;
	}	

	public List<BookModel> getAllSach() {
		listBook = bookRepository.getAllSach();
		return listBook;
	}

	public List<BookModel> getSachPriceDESC(int offset, int pageSize) {
		listBook = bookRepository.getSachPriceDESC(offset, pageSize);
		return listBook;
	}

	public List<BookModel> getSachPriceASC(int offset, int pageSize) {
		listBook = bookRepository.getSachPriceASC(offset, pageSize);
		return listBook;
	}

	public boolean addSach(BookModel newSach) {
		return bookRepository.addSach(newSach) > 0;
	}

	public boolean updateSach(BookModel sach) {
		return bookRepository.updateSach(sach) > 0;
	}

	public boolean deleteSach(String masach) {
		return bookRepository.deleteSach(masach) > 0;
	}

	public BookModel getSachById(String masach) {
		return bookRepository.getSachById(masach);
	}

}
