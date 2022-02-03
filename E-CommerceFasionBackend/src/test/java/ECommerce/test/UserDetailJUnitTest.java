package ECommerce.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ECommerce.DAO.UserDAO;
import ECommerce.model.UserDetail;

class UserDetailJUnitTest {
	static UserDAO userDAO;

	@BeforeAll
	public static void executeFirst() {
		
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("ECommerce");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
    @Test
	
	public void registerUserTest() {
		UserDetail userDetail = new UserDetail();
		
		userDetail.setUserName("Nidhii");
		userDetail.setPassword("1234");
		userDetail.setEnabled(true);
		userDetail.setRole("ROLE_ADMIN");
		userDetail.setCustomerName("Nidhi");
		userDetail.setCustomerAddr("Gurgaon");
				
		

		
		
		assertTrue(userDAO.registerUser(userDetail), "problem in registering user");
		
		
	}

}
