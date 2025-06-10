package ntp.service;

import java.util.ArrayList;
import java.util.List;

import ntp.model.CartModel;

public class CartService {
	public List<CartModel> listCart = new ArrayList<CartModel>();

	public void addToCart(String masach, String tensach, Long soluongmua, Long gia, String anh) {
		boolean exists = false;

		for (CartModel cart : listCart) {
			if (cart.getMasach().equals(masach)) {
				// Nếu sản phẩm đã tồn tại, tăng số lượng và không thêm mới
				cart.setSoluongmua(cart.getSoluongmua() + soluongmua);
				exists = true;
				break;
			}
		}

		// Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm mới
		if (!exists) {
			listCart.add(new CartModel(masach, tensach, gia, soluongmua, anh));
		}
	}

	public void deleteCartItem(String masach) {
		for (CartModel cart : listCart) {
			if (cart.getMasach().equals(masach)) {
				listCart.remove(cart);
				return;
			}
		}
	}
	
	public void updateCartItem(String masach, Long soluongmoi) {
		for(CartModel cart : listCart) {
			if(cart.getMasach().equals(masach)) {
				cart.setSoluongmua(soluongmoi);
				break;
			}
		}
	}
	
	public long totalPrice() {
		long s = 0;
		for(int i = 0; i < listCart.size(); i++) {
			s += listCart.get(i).getThanhTien();
		}
		
		return s;
	}
	
	public long getCartItem() {
		return listCart.size();
	}		
}
