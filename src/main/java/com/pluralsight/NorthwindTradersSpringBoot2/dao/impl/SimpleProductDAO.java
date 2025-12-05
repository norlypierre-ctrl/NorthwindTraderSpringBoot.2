package com.pluralsight.NorthwindTradersSpringBoot2.dao.impl;

import com.pluralsight.NorthwindTradersSpringBoot2.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot2.dao.interfaces.IProductDAO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements IProductDAO {
    private final List<Product> products;

    public SimpleProductDAO() {
        products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 101, 999));
        products.add(new Product(2, "Phone", 102, 799));
        products.add(new Product(3, "Tablet", 103, 599));
    }

    @Override
    public Product add(Product product) {
        int maxId = products.stream().mapToInt(Product::getProductId).max().orElse(0);
        product.setProductId(maxId + 1);
        products.add(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        return products.stream().filter(p -> p.getProductId() == productId).findFirst().orElse(null);
    }

    @Override
    public void update(int productId, Product product) {
        int idx = getProductIndex(productId);
        if (idx != -1)
            products.set(idx, product);
    }

    @Override
    public void delete(int productId) {
        int idx = getProductIndex(productId);
        if (idx != -1)
            products.remove(idx);
    }

    private int getProductIndex(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId)
                return i;
        }
        return -1;
    }
}