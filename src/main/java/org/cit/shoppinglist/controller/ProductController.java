package org.cit.shoppinglist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cit.shoppinglist.model.Product;
import org.cit.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		List<Product> productList = productService.getAllProducts();
		
		model.addObject("productList", productList);
		model.setViewName("products");

		return model;
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Product newProduct = new Product();
		model.addObject("product", newProduct);
		model.setViewName("productForm");
		return model;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Product product) {
		productService.saveProduct(product);
		
		return new ModelAndView("redirect:/products");
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		productService.deleteProduct(productId);
		
		return new ModelAndView("redirect:/products");
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productService.getProductById(productId);
		
		ModelAndView model = new ModelAndView("productForm");
		model.addObject("product", product);

		return model;
	}
}
