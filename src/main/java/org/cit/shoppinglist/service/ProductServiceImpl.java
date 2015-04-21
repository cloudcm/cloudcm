package org.cit.shoppinglist.service;

import java.util.List;

import org.cit.shoppinglist.dao.ProductDao;
import org.cit.shoppinglist.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public void saveProduct(Product contact) {
		try {
			productDao.saveOrUpdate(contact);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int productId) {
		try {
			productDao.delete(productId);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Product getProductById(int productId) {
		try {
			return productDao.getById(productId);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			return productDao.getAllProducts();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
