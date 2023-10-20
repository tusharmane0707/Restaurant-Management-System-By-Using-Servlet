package service;

import java.util.List;

import dao.CartDao;
import dto.Cart;

public class CartService {

	CartDao cartDao = new CartDao();

	public Cart addCart(Cart cart) {
		return cartDao.addCart(cart);
	}

	public boolean delCart(int id) {
		return cartDao.delCart(id);
	}

	public Cart getCartById(int id) {
		return cartDao.getCartById(id);
	}

	public List<Cart> getCarts() {
		return cartDao.getCarts();
	}

	public boolean deleteAll() {
		return cartDao.deleteAll();
	}
	
	public boolean updateStatus() {
		return cartDao.updateStatus();
	}
}