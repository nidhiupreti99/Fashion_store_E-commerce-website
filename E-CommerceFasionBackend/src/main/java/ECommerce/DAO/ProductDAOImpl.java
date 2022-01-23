package ECommerce.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ECommerce.model.Category;
import ECommerce.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory ;

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> listProducts = query.list();
		session.close();
		
		return listProducts;
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, productId);
		
		return product;
	}

}
