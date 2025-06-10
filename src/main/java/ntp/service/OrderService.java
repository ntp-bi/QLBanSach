package ntp.service;

import java.util.List;

import ntp.model.OrderModel;
import ntp.repository.OrderRepository;

public class OrderService {
	OrderRepository orderRepository = new OrderRepository();

	public List<OrderModel> getAllOrder() throws Exception {
		return orderRepository.getAllOrder();
	}

	public OrderModel getOrderById(long maCTHD) throws Exception {
		return orderRepository.getOrderById(maCTHD);
	}

	public boolean deleteOrder(long maCTHD) {
		return orderRepository.deleteOrder(maCTHD) > 0;
	}

	public boolean acceptOrder(long maCTHD) {
		return orderRepository.acceptOrder(maCTHD) > 0;
	}
}
