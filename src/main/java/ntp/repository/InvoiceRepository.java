package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ntp.config.DbConfig;

public class InvoiceRepository {
	public int addInvoice(long makh) throws Exception {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "INSERT INTO hoadon(makh, NgayMua, damua) VALUES(?,?,0)";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, makh);

			// Get current date
			java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			statement.setDate(2, currentDate);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when adding invoice to the database | " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					System.out.println("An error occurred when closing the database connection | " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	// Lấy mã hóa đơn (maHD) lớn nhất trong bảng hoadon, tức là hóa đơn vừa mới tạo.
	public long getMaInvoice() throws Exception {
		long result = 0;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT MAX(MaHoaDon) AS maHD FROM hoadon";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				result = resultSet.getLong("maHD");
			}
		} catch (Exception e) {
			System.out.println("An error occurred when max invoice to the database | " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					System.out.println("An error occurred when closing the database connection | " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public int addInvoiceDetail(String masach, long soluongmua, long mahoadon) throws Exception {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "INSERT INTO ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon, damua) VALUES(?, ?, ?, ?)";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, masach);
			statement.setLong(2, soluongmua);
			statement.setLong(3, mahoadon);
			statement.setBoolean(4, false);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when adding detail invoice to the database | " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					System.out.println("An error occurred when closing the database connection | " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return result;
	}
}
