package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ntp.config.DbConfig;

public class RegisterAccountRepository {
	public int dangKyTaiKhoan(String hoten, String diachi, String sodt, String email, String tendn, String pass) {
		int result = -1;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "INSERT INTO KhachHang(hoten,diachi,sodt,email,tendn,pass) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, hoten);
			statement.setString(2, diachi);
			statement.setString(3, sodt);
			statement.setString(4, email);
			statement.setString(5, tendn);
			statement.setString(6, pass);

			result = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("An error occurred when insert user in database | " + e.getMessage());
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
