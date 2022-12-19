package com.learning.controller.impl;

import com.learning.constants.ErrorMessage;
import com.learning.constants.InfoMessage;
import com.learning.controller.ProductController;
import com.learning.entity.Product;
import com.learning.s2s.client.CarClient;
import com.learning.s2s.shared.Car;
import com.learning.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CarClient carClient;

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public List<Car> getAllCars() {
        return carClient.getAllCars();
    }

    @Override
    public Product getProductById(Long id) {
        return productService.getProductById(id);
    }

    @Override
    public String addProduct(Product product) {
        productService.addProduct(product);
        return InfoMessage.PRODUCT_ADDED;
    }

    @Override
    public String addAllProducts(List<Product> productList) {
        productService.addAllProducts(productList);
        return InfoMessage.PRODUCTS_ADDED;
    }

    @Override
    public String updateProductById(Long id, Product product) {
        boolean updatedSuccessfully = productService.updateProductById(id, product);
        if (updatedSuccessfully == true) {
            return String.format(InfoMessage.PRODUCT_UPDATED, id);
        } else {
            return String.format(ErrorMessage.PRODUCT_NOT_FOUND, id);
        }
    }

    @Override
    public String deleteProductById(Long id) {
        productService.deleteProductById(id);
        return String.format(InfoMessage.PRODUCT_DELETED, id);
    }

    @Override
    public String deleteAllProducts() {
        productService.deleteAllProducts();
        return InfoMessage.PRODUCT_ALL_DELETED;
    }

    @Override
    public String deleteAllInBatch(List<Product> productList) {
        productService.deleteAllInBatch(productList);
        return InfoMessage.PRODUCT_DELETED_IN_BATCH;
    }

}
