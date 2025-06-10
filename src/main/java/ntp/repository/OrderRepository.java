package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ntp.config.DbConfig;
import ntp.model.OrderModel;

public class OrderRepository {
	public List<OrderModel> getAllOrder() throws Exception {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM VAdminXacNhan ORDER BY MaChiTietHD DESC";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OrderModel order = new OrderModel();

				order.setMaChiTietHD(resultSet.getLong("MaChiTietHD"));
				order.setHoten(resultSet.getString("hoten"));
				order.setTensach(resultSet.getString("tensach"));
				order.setGia(resultSet.getLong("gia"));
				order.setSoLuongMua(resultSet.getLong("SoLuongMua"));
				order.setThanhtien(resultSet.getString("thanhtien"));
				order.setDamua(resultSet.getBoolean("damua"));

				listOrder.add(order);
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get all order in database | " + e.getMessage());
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

		return listOrder;
	}
	
	public OrderModel getOrderById(long maCTHD) throws Exception {		
		OrderModel order = new OrderModel();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM VAdminXacNhan WHERE MaChiTietHD = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, maCTHD);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				order.setMaChiTietHD(resultSet.getLong("MaChiTietHD"));
				order.setHoten(resultSet.getString("hoten"));
				order.setTensach(resultSet.getString("tensach"));
				order.setGia(resultSet.getLong("gia"));
				order.setSoLuongMua(resultSet.getLong("SoLuongMua"));
				order.setThanhtien(resultSet.getString("thanhtien"));
				order.setDamua(resultSet.getBoolean("damua"));				
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get all order in database | " + e.getMessage());
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

		return order;
	}

	public int deleteOrder(long maCTHD) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "DELETE hoadon\r\n"
				+ "FROM hoadon HD INNER JOIN ChiTietHoaDon CTHD \r\n"
				+ "ON HD.MaHoaDon = CTHD.MaHoaDon\r\n"
				+ "WHERE MaChiTietHD = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, maCTHD);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when accept order in database | " + e.getMessage());
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

	public int acceptOrder(long maCTHD) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "UPDATE VAdminXacNhan SET damua = 1 WHERE MaChiTietHD = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, maCTHD);

			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("An error occurred when accept order in database | " + e.getMessage());
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
}
