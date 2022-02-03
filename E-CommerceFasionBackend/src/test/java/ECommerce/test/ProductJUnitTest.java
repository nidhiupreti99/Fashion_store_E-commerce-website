package ECommerce.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import ECommerce.DAO.ProductDAO;
import ECommerce.model.Product;

class ProductJUnitTest {

static ProductDAO productDAO;
	
	@BeforeAll
	public static void executeFirst() {
		
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("ECommerce");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	
	public void addProductTest() {
		Product product = new Product();
		
		product.setProductId(123);
		product.setProductName("T-Shirt");
		product.setProductDesc("variety of T-shirts");
		product.setStock(124);
		product.setPrice(800);
		product.setSupplierId(123);
		product.setCategoryId(123);


		
		
		assertTrue(productDAO.addProduct(product), "problem in adding product");
		
		
	}


}
