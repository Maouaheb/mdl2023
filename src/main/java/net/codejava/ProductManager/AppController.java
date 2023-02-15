package net.codejava.ProductManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	ProductService service;
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> products=service.getAll();
		model.addAttribute("products", products);
		return "index";
	}
	@RequestMapping("/new")
	public String addProduct(Model model) {
		Product p=new Product();
		model.addAttribute("product", p);
		return "new_product";
		
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable(name="id") int id) {
		ModelAndView mav=new ModelAndView("edit_product");
		Product product=service.getById(id);
		mav.addObject("product", product);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
