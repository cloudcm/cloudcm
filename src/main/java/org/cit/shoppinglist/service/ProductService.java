package org.cit.shoppinglist.service;

import java.util.List;

import org.cit.shoppinglist.model.Product;

public interface ProductService {
	
	void saveProduct(Product product);

	void deleteProduct(int productId);

	Product getProductById(int productId);

	List<Product> getAllProducts();
}
