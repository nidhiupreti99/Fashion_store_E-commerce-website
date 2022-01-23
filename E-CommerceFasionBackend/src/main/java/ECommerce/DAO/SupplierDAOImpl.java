package ECommerce.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ECommerce.model.Category;
import ECommerce.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory ;

	@Override
	public boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}catch(Exception e){
		    return false;
		}
	}

	@Override
	public List<Supplier> listSuppliers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listSuppliers = query.list();
		session.close();
		
		return listSuppliers;
	}

	@Override
	public Supplier getProduct(int supplierId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Supplier supplier = session.get(Supplier.class, supplierId);
		
		return supplier ;
	}

	
}
