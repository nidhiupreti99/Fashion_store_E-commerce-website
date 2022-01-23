package ECommerce.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ECommerce.model.CartItem;
import ECommerce.model.Category;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	SessionFactory sessionFactory ;

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}catch(Exception e){
		    return false;
		}

	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}catch(Exception e){
		    return false;
		}

	}

	@Override
	public List<CartItem> listCartItems(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem where username=:username and paymentStatus='NP'");
		query.setParameter("username", username);
		List<CartItem> cartItemList = query.getResultList();
		session.close();
		
		return cartItemList;	
	}

	@Override
	public CartItem getCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
		CartItem cartItem = session.get(CartItem.class, cartItemId);
		session.close();
		
		return cartItem;
	}

}
