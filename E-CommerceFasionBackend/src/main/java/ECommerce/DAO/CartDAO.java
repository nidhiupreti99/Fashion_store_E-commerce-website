package ECommerce.DAO;

import java.util.List;

import ECommerce.model.CartItem;

public interface CartDAO {
	public boolean addCartItem(CartItem cartItem);

	public boolean deleteCartItem(CartItem cartItem);

	public boolean updateCartItem(CartItem cartItem);

	public List<CartItem> listCartItems(String username);

	public CartItem getCartItem(int cartItemId);

}
