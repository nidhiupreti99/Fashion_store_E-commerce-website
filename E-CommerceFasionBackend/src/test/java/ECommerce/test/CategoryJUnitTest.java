package ECommerce.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECommerce.DAO.CategoryDAO;
import ECommerce.model.Category;

class CategoryJUnitTest {

	static CategoryDAO categoryDAO;
	
	@BeforeAll
	public static void executeFirst() {
		
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("ECommerce");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	
	public void addCategoryTest() {
		Category category = new Category();
		
		category.setCategoryId(123);
		category.setCategoryName("T-Shirt");
		category.setCategoryDesc("variety of T-shirts");
		
		assertTrue(categoryDAO.addCategory(category), "problem in adding category");
		
		
	}
	

}

