package ECommerce.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ECommerce.model.Supplier;
import ECommerce.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory ;

	@Override
	public boolean registerUser(UserDetail user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public boolean updateUser(UserDetail user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e){
		    return false;
		}
	}
	
	@Override
	public UserDetail getUser(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		UserDetail user = (UserDetail)session.get(UserDetail.class, username);
		session.close();
		return user ;
	}

	
}
