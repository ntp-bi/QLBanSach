package ntp.service;

import java.util.List;

import ntp.model.BookCategoryModel;
import ntp.repository.BookCategoryRepository;

public class BookCategoryService {
	BookCategoryRepository bookCategoryRepository = new BookCategoryRepository();

	public List<BookCategoryModel> getAllBookCategory() {
		return bookCategoryRepository.getAllBookCategory();
	}

	public boolean addBookCategory(String maloai, String tenloai) {
		return bookCategoryRepository.addBookCategory(maloai, tenloai) > 0;
	}

	public boolean updateBookCategory(String maloai, String tenloai) {
		return bookCategoryRepository.updateBookCategory(maloai, tenloai) > 0;
	}

	public boolean deleteBookCategory(String maloai) {
		return bookCategoryRepository.deleteBookCategory(maloai) > 0;
	}

	public BookCategoryModel getBookCategoryById(String maloai) {
		return bookCategoryRepository.getBookCategoryById(maloai);
	}
}
