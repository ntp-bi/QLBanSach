package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ntp.config.DbConfig;
import ntp.model.LoginModel;
import ntp.model.tableData.LoginColumn;

public class AuthRepository {
	public int checkExistingOfKhachHangByEmailNPassword(String email, String password) {
		int count = 0;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT count(*) AS count FROM KhachHang AS k WHERE k.email = ? AND k.pass = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}

		} catch (Exception e) {
			System.out.println("An error occurred when count khach hang in database | " + e.getMessage());
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
	
	public int checkExistingOfKhachHangByEmail(String email) {
		int count = 0;

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT count(*) AS count FROM KhachHang AS k WHERE k.email = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);			

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}

		} catch (Exception e) {
			System.out.println("An error occurred when count khach hang in database | " + e.getMessage());
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

	// GET ROLE
	public LoginModel getQuyen(boolean quyen) {
		LoginModel dangNhapModel = new LoginModel();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM DangNhap AS d WHERE d.Quyen = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setBoolean(1, quyen);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				dangNhapModel.setTenDangNhap(resultSet.getString(LoginColumn.TENDANGNHAP.getValue()));
				dangNhapModel.setMatKhau(resultSet.getString(LoginColumn.MATKHAU.getValue()));
				dangNhapModel.setQuyen(resultSet.getBoolean(LoginColumn.QUYEN.getValue()));
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get quyen info in database | " + e.getMessage());
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

		return dangNhapModel;
	}
}
