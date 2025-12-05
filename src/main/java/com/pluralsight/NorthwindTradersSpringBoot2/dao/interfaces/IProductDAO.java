package com.pluralsight.NorthwindTradersSpringBoot2.dao.interfaces;

import com.pluralsight.NorthwindTradersSpringBoot2.models.Product;

import java.util.List;

public interface IProductDAO {
    Product add(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    void update(int productId, Product product);
    void delete(int productId);
}