package ECommerce.DAO;

import java.util.List;

import ECommerce.model.Supplier;

public interface SupplierDAO {
	
	public boolean addSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

	public boolean updateSupplier(Supplier supplier);

	public List<Supplier> listSuppliers();

	public Supplier getProduct(int supplierId);
}
