package ECommerce.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECommerce.DAO.ProductDAO;
import ECommerce.DAO.SupplierDAO;
import ECommerce.model.Product;
import ECommerce.model.Supplier;

class SupplierJunitTest {

static SupplierDAO supplierDAO;
	
	@BeforeAll
	public static void executeFirst() {
		
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("ECommerce");
		context.refresh();
		
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
	}
	
    @Test
	
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		
		supplier.setSupplierId(123);
		supplier.setSupplierName("T-Shirt");
		supplier.setSupplierAddr("variety of T-shirts");
		

		
		
		assertTrue(supplierDAO.addSupplier(supplier), "problem in adding product");
		
		
	}

}
