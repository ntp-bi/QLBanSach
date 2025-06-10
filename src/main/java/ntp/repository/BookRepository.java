package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ntp.config.DbConfig;
import ntp.model.BookModel;
import ntp.model.tableData.BookColumn;

public class BookRepository {
	public List<BookModel> getAllSach() {
		List<BookModel> listSach = new ArrayList<BookModel>();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM sach AS s ORDER BY s.masach";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
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

				listSach.add(sach);
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get all sach in database | " + e.getMessage());
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

		return listSach;
	}

	public List<BookModel> getSachPriceDESC(int offset, int pageSize) {
		List<BookModel> listSach = new ArrayList<BookModel>();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM sach ORDER BY gia DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

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

				listSach.add(sach);
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get all sach in database | " + e.getMessage());
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

		return listSach;
	}

	public List<BookModel> getSachPriceASC(int offset, int pageSize) {
		List<BookModel> listSach = new ArrayList<BookModel>();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM sach ORDER BY gia ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

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

				listSach.add(sach);
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get all sach in database | " + e.getMessage());
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

		return listSach;
	}

	public int addSach(BookModel newSach) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "INSERT INTO sach(masach, tensach, soluong, gia, maloai, anh, tacgia) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newSach.getMasach());
			statement.setString(2, newSach.getTensach());
			statement.setLong(3, newSach.getSoluong());
			statement.setLong(4, newSach.getGia());
			statement.setString(5, newSach.getMaloai());	
			statement.setString(6, newSach.getAnh());
			statement.setString(7, newSach.getTacgia());

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when insert sach in database | " + e.getMessage());
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

	public int updateSach(BookModel sach) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "UPDATE sach SET tensach = ?, soluong = ?, gia = ?, maloai = ?, anh = ?, tacgia= ? WHERE masach = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, sach.getTensach());
			statement.setLong(2, sach.getSoluong());
			statement.setLong(3, sach.getGia());
			statement.setString(4, sach.getMaloai());	
			statement.setString(5, sach.getAnh());	
			statement.setString(6, sach.getTacgia());
			statement.setString(7, sach.getMasach());

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when update sach in database | " + e.getMessage());
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

	public int deleteSach(String masach) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "DELETE FROM sach WHERE masach = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, masach);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when delete sach in database | " + e.getMessage());
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

	public BookModel getSachById(String masach) {
		BookModel sach = new BookModel();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM sach s WHERE s.masach = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, masach);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				sach.setMasach(resultSet.getString(BookColumn.MASACH.getValue()));
				sach.setTensach(resultSet.getString(BookColumn.TENSACH.getValue()));
				sach.setSoluong(resultSet.getLong(BookColumn.SOLUONG.getValue()));
				sach.setGia(resultSet.getLong(BookColumn.GIA.getValue()));
				sach.setMaloai(resultSet.getString(BookColumn.MALOAI.getValue()));
				sach.setSotap(resultSet.getString(BookColumn.SOTAP.getValue()));
				sach.setAnh(resultSet.getString(BookColumn.ANH.getValue()));
				sach.setNgaynhap(resultSet.getString(BookColumn.NGAYNHAP.getValue()));
				sach.setTacgia(resultSet.getString(BookColumn.TACGIA.getValue()));
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get sach in database | " + e.getMessage());
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

		return sach;
	}

}
