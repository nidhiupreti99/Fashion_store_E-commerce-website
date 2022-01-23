package ECommerce.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ECommerce.model.Category;

@Repository("categoryDAO")
@Transactional
@Component
public class CategoryDAOImpl implements CategoryDAO {
	
	
	@Autowired
	SessionFactory sessionFactory ;

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch(Exception e){
		    return false;
		}

	}

	@Override 
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
		    return false;
		}

	}

	@Override
	public List<Category> listCategories() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> listCategories = query.list();
		session.close();
		
		return listCategories;
	}

	@Override
	public Category getCategory(int categoryId) {
		
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, categoryId);
		
		return category;
	}

}
