package ntp.service;

import java.util.List;

import ntp.model.HistoryModel;
import ntp.repository.HistoryRepository;

public class HistoryService {
	HistoryRepository historyRepository = new HistoryRepository();

	public List<HistoryModel> getHistoryByCustomerId(long makh) {
		return historyRepository.getHistoryByCustomerId(makh);
	}
}
