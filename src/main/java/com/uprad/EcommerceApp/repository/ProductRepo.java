package com.uprad.EcommerceApp.repository;

import com.uprad.EcommerceApp.entity.Product;

import java.util.HashMap;

public class ProductRepo {
    private static HashMap<Integer, Product> productMap = new HashMap<>();

    public Product findById(int id){
        return productMap.get(id);
    }

    public Product save(Product product){
        productMap.put(product.getId(), product);
        return product;
    }

    public void delete(Product product){
        productMap.remove(product.getId());
    }
}
