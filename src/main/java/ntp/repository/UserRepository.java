package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ntp.config.DbConfig;
import ntp.model.UserModel;
import ntp.model.tableData.UserColumn;

public class UserRepository {	
	// Auth hangding
	public UserModel getKhachHangByEmail(String email) {
		UserModel khachang = new UserModel();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM KhachHang AS k WHERE k.email = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				khachang.setMakh(resultSet.getLong(UserColumn.MAKH.getValue()));
				khachang.setHoten(resultSet.getString(UserColumn.HOTEN.getValue()));
				khachang.setDiachi(resultSet.getString(UserColumn.DIACHI.getValue()));
				khachang.setSodt(resultSet.getString(UserColumn.SODIENTHOAI.getValue()));
				khachang.setEmail(resultSet.getString(UserColumn.EMAIL.getValue()));
				khachang.setTendn(resultSet.getString(UserColumn.TENDANGNHAP.getValue()));
				khachang.setPass(resultSet.getString(UserColumn.PASS.getValue()));
			}

		} catch (Exception e) {
			System.out.println("An error occurred when get khach hang info in database | " + e.getMessage());
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

		return khachang;
	}
}
