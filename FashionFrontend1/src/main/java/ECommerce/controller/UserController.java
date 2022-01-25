
package ECommerce.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ECommerce.DAO.ProductDAO;
import ECommerce.DAO.UserDAO;
import ECommerce.model.Category;
import ECommerce.model.Product;
import ECommerce.model.UserDetail;

@Controller
public class UserController {
  
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/userhome")
	public String showUserName(Model m, HttpSession session) {
		m.addAttribute("pageinfo", "Product Catalog");
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "UserHome";
	}
	
	@RequestMapping(value="/adminhome")
	public String showAdminName(Model m, HttpSession session) {
		m.addAttribute("pageinfo", "Product Catalog");
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "AdminHome";
	}
	
	@RequestMapping(value="/adduser")
	public String addUser(Model m, @RequestParam("customerName")String customerName, @RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("customerAddr")String customerAddr) {
		
		UserDetail userDetail = new UserDetail();
		userDetail.setCustomerName(customerName);
		userDetail.setCustomerAddr(customerAddr);
		userDetail.setPassword(password);
		userDetail.setRole("ROLE_USER");
		userDetail.setUserName(username);
		userDetail.setEnabled(true);
		
		userDAO.registerUser(userDetail);
		
		
		return "Login";
	}
	
	
	
	@RequestMapping(value="/login_success")
	public String loginCheck(Model m, HttpSession session) {
		String page="";
		boolean loggedIn = false;
		
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication authentication = securitycontext.getAuthentication();
		
		String username= authentication.getName();
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) authentication.getAuthorities();
		
		for(GrantedAuthority role:roles) {
			session.setAttribute("role", role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN")) {
				loggedIn=true;
				page="AdminHome";
				m.addAttribute("pageinfo", "Admin Home");

				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("productList", listProducts);

				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}else {
				m.addAttribute("pageinfo", "User Home");
				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("productList", listProducts);
				loggedIn=true;
				page="UserHome";
				
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		return page;
	} 
}
