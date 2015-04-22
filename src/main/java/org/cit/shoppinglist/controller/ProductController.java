package org.cit.shoppinglist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.cit.shoppinglist.model.Product;
import org.cit.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products")
	public String listProduct(Model model) throws IOException {
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);

		return "products";
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public String newProduct(Model model) {
		Product newProduct = new Product();
		model.addAttribute("product", newProduct);
		
		return "productForm";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
            return "productForm";
        }
		
		productService.saveProduct(product);
		
		return "redirect:/admin/products";
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		productService.deleteProduct(productId);
		
		return "redirect:/admin/products";
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public String editProduct(Model model, HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productService.getProductById(productId);
		
		model.addAttribute("product", product);

		return "productForm";
	}
}
