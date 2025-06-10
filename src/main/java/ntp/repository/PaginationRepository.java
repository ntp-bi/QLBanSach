package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ntp.config.DbConfig;
import ntp.model.BookModel;
import ntp.model.tableData.BookColumn;

public class PaginationRepository {
	public List<BookModel> getAllSachWithPagination(int offset, int pageSize) throws Exception {
		List<BookModel> listBook = new ArrayList<BookModel>();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM sach ORDER BY masach OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, offset);
			statement.setInt(2, pageSize);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				BookModel sach = new BookModel();

				sach.setMasach(resultSet.getString(BookColumn.MASACH.getValue()));
				sach.setTensach(resultSet.getString(BookColumn.TENSACH.getValue()));
				sach.setSoluong(resultSet.getLong(BookColumn.SOLUONG.getValue()));
				sach.setGia(resultSet.getLong(BookColumn.GIA.getValue()));
				sach.setMaloai(resultSet.getString(BookColumn.MALOAI.getValue()));
				sach.setSotap(resultSet.getString(BookColumn.SOTAP.getValue()));
				sach.setAnh(resultSet.getString(BookColumn.ANH.getValue()));
				sach.setNgaynhap(resultSet.getString(BookColumn.NGAYNHAP.getValue()));
				sach.setTacgia(resultSet.getString(BookColumn.TACGIA.getValue()));

				listBook.add(sach);
			}
		} catch (Exception e) {
			System.out.println("An error occurred when pagination sach in database | " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					System.out.println("An error occurred when close database | " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return listBook;

	}

	public int countBooks() throws Exception {
		int count = 0;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT COUNT(*) AS count FROM sach";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}
		} catch (Exception e) {
			System.out.println("An error occurred when count sach in database | " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					System.out.println("An error occurred when close database | " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return count;
	}

}
