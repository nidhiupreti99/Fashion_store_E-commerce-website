package ECommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	 @RequestMapping("/Login")
	   public String showLogin(Model m) {
		   m.addAttribute("pageinfo", "Login");
		   
		   return "Login";
	   }
	 
	 @RequestMapping("/register")
	   public String register(Model m) {
		 
		   m.addAttribute("pageInfo", "Login");
		   
		   return "Register";
	   }
	 
	 @RequestMapping("/aboutus")
	   public String showAboutUs(Model m) {
		 
		   m.addAttribute("pageInfo", "Login");
		   
		   return "AboutUs";
	   }
	 
	 @RequestMapping("/contactus")
	   public String showContactUs(Model m) {
		 
		   m.addAttribute("pageInfo", "Login");
		 
		   return "ContactUs";
	   }

}
