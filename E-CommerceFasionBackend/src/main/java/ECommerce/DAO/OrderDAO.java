package ECommerce.DAO;

import ECommerce.model.OrderDetail;

public interface OrderDAO {
  
	public boolean saveOrder(OrderDetail orderDetail);
	public boolean updateCart(String username);
}

