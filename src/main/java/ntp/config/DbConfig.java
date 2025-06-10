package ntp.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig {
	private static String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String URL = "jdbc:sqlserver://ADMIN-PC:1433;databaseName=QLBanSach;encrypt=false";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123";

	public static Connection getMySQLConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Lỗi khi kết nối vào database | " + e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		Connection connection = DbConfig.getMySQLConnection();

		if (connection != null) {
			System.out.println("Đã kết nối thành công đến SQL Server.");
		} else {
			System.out.println("Kết nối thất bại.");
		}
	}
}
