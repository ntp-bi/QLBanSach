package ntp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ntp.config.DbConfig;
import ntp.model.HistoryModel;

public class HistoryRepository {
	public List<HistoryModel> getHistoryByCustomerId(long makh) {
		List<HistoryModel> listHistory = new ArrayList<HistoryModel>();

		Connection connection = DbConfig.getMySQLConnection();
		String query = "SELECT * FROM Vlichsu WHERE makh=? ORDER BY MaHoaDon DESC";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, makh);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				HistoryModel history = new HistoryModel();

				history.setMasach(resultSet.getString("masach"));
				history.setTensach(resultSet.getString("tensach"));
				history.setGia(resultSet.getLong("gia"));
				history.setSoluongmua(resultSet.getLong("soluongmua"));
				history.setThanhtien(resultSet.getLong("thanhtien"));
				history.setMakh(resultSet.getLong("makh"));
				history.setDamua(resultSet.getBoolean("damua"));
				history.setAnh(resultSet.getString("anh"));
				history.setNgaymua(resultSet.getString("ngaymua"));
				history.setMahoadon(resultSet.getLong("mahoadon"));
				
				listHistory.add(history);
			}
		} catch (Exception e) {
			System.out.println("An error occurred when get history in database | " + e.getMessage());
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

		return listHistory;
	}
}
