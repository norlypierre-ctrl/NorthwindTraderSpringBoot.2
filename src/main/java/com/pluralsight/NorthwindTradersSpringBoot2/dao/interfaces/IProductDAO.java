package com.pluralsight.NorthwindTradersSpringBoot2.dao.interfaces;

import com.pluralsight.NorthwindTradersSpringBoot2.models.Product;

import java.util.List;

public interface IProductDAO {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    void updateProduct(int productId, Product product);
    void deleteProduct(int productId);
}