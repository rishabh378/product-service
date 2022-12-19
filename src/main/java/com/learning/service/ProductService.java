package com.learning.service;

import com.learning.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public void addProduct(Product product);
    public void addAllProducts(List<Product> productList);
    public Boolean updateProductById(Long id, Product product);
    public void deleteProductById(Long id);
    public void deleteAllProducts();
    public void deleteAllInBatch(List<Product> productList);
}
