package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.Product;

public interface ProductDao {
     
    void saveOrUpdate(Product product);
     
    void delete(int productId);
     
    Product getById(int contactId);
     
    List<Product> getAllProducts();
}
