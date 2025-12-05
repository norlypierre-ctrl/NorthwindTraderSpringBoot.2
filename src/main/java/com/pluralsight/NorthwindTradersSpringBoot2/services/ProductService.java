package com.pluralsight.NorthwindTradersSpringBoot2.services;

import com.pluralsight.NorthwindTradersSpringBoot2.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot2.dao.interfaces.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final IProductDAO productDAO;

    @Autowired
    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    public void updateProduct(int productId, Product product) {
        productDAO.updateProduct(productId, product);
    }

    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }
}