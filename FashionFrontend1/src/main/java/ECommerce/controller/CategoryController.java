package ECommerce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ECommerce.DAO.CategoryDAO;
import ECommerce.model.Category;
import ECommerce.DAO.CategoryDAOImpl;



@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	
	
	@RequestMapping("/category")
	public String showCategory(Model m) {
		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);
		m.addAttribute("pageinfo", "AboutUs");
		
		return "Category";
		
	}
	
	@RequestMapping(value="/AddCategory", method=RequestMethod.POST)
	public String addCategory(Model m, @RequestParam("catgName")String categoryName, @RequestParam("catgDesc")String categoryDesc) {
		
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			
		context.scan("ECommerce");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");*/

        Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.addCategory(category);
		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);

		
		
		m.addAttribute("pageinfo", "Manage Category");
		
		return "Category";
		
	}
	
	@RequestMapping(value="/UpdateCategory", method=RequestMethod.POST)
	public String UpdateCategory(Model m, @RequestParam("catgId")int categoryId, @RequestParam("catgName")String categoryName, @RequestParam("catgDesc")String categoryDesc) {
		
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			
		context.scan("ECommerce");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");*/

        Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.updateCategory(category);
		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);

		
		
		m.addAttribute("pageinfo", "Manage Category");
		
		return "Category";
		
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(Model m, @PathVariable("categoryId")int categoryId) {
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> listCatg = categoryDAO.listCategories();
		m.addAttribute("listCategories", listCatg);
		
        m.addAttribute("pageinfo", "Manage Category");
		
		return "Category";
		
		

	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(Model m, @PathVariable("categoryId")int categoryId) {
		Category category = categoryDAO.getCategory(categoryId);
		
		m.addAttribute("category", category);
		
        m.addAttribute("pageinfo", "Manage Category");


		return "UpdateCategory";
		

	}
	
	
	
	
	 

}
