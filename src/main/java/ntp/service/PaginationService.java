package ntp.service;

import java.util.List;

import ntp.model.BookModel;
import ntp.repository.PaginationRepository;

public class PaginationService {
	PaginationRepository paginationRepository = new PaginationRepository();

	public List<BookModel> getAllSachWithPagination(int offset, int pageSize) throws Exception {
		return paginationRepository.getAllSachWithPagination(offset, pageSize);
	}

	public int countBooks() throws Exception {
		return paginationRepository.countBooks();
	}
}
