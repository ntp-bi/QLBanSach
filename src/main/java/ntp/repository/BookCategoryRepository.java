package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ntp.config.DbConfig;
import ntp.model.BookCategoryModel;
import ntp.model.tableData.BookCategoryColumn;

public class BookCategoryRepository {
	public List<BookCategoryModel> getAllBookCategory() {
		List<BookCategoryModel> listBookCategory = new ArrayList<BookCategoryModel>();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM loai AS l ORDER BY l.maloai";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				BookCategoryModel bookCategory = new BookCategoryModel();

				bookCategory.setMaloai(resultSet.getString(BookCategoryColumn.MALOAI.getValue()));
				bookCategory.setTenloai(resultSet.getString(BookCategoryColumn.TENLOAI.getValue()));

				listBookCategory.add(bookCategory);
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get all loai sach in database | " + e.getMessage());
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

		return listBookCategory;
	}

	public int addBookCategory(String maloai, String tenloai) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "INSERT INTO loai(maloai, tenloai) VALUES(?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, maloai);
			statement.setString(2, tenloai);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when add loai sach in database | " + e.getMessage());
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

		return result;
	}

	public int updateBookCategory(String maloai, String tenloai) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "UPDATE loai SET tenloai = ? WHERE maloai = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, tenloai);
			statement.setString(2, maloai);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when update loai sach in database | " + e.getMessage());
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

		return result;
	}

	public int deleteBookCategory(String maloai) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "DELETE FROM loai WHERE maloai = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, maloai);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when delete loai sach in database | " + e.getMessage());
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

		return result;
	}

	public BookCategoryModel getBookCategoryById(String maloai) {
		BookCategoryModel bookCategory = new BookCategoryModel();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM loai WHERE maloai= ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, maloai);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				bookCategory.setMaloai(resultSet.getString(BookCategoryColumn.MALOAI.getValue()));
				bookCategory.setTenloai(resultSet.getString(BookCategoryColumn.TENLOAI.getValue()));
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get all loai sach in database | " + e.getMessage());
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

		return bookCategory;
	}
}
