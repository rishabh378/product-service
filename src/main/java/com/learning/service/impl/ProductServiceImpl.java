package com.learning.service.impl;

import com.learning.constants.ErrorMessage;
import com.learning.constants.InfoMessage;
import com.learning.entity.Product;
import com.learning.respository.ProductRepository;
import com.learning.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        log.info(InfoMessage.PRODUCT_GET_ALL);
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        log.info(String.format(InfoMessage.PRODUCT_GET, id));
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
        log.info(InfoMessage.PRODUCT_ADDED);
    }

    public void addAllProducts(List<Product> productList) {
        productRepository.saveAll(productList);
        log.info(InfoMessage.PRODUCTS_ADDED);
    }

    public Boolean updateProductById(Long id, Product product) {
        boolean updatedSuccessfully = false;
        if(productRepository.existsById(id)) {
            productRepository.save(product);
            log.info(String.format(InfoMessage.PRODUCT_UPDATED, id));
            return updatedSuccessfully = true;
        } else {
            log.error(String.format(ErrorMessage.PRODUCT_NOT_FOUND, id));
            return updatedSuccessfully;
        }

    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
        if(!productRepository.existsById(id)) {
            log.info(String.format(InfoMessage.PRODUCT_DELETED, id));
        } else {
            log.error(String.format(ErrorMessage.PRODUCT_NOT_FOUND, id));
        }
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
        if (productRepository.count() == 0) {
            log.info(InfoMessage.PRODUCT_ALL_DELETED);
        } else {
            log.error(ErrorMessage.DELETE_PRODUCTS_FAILED);
        }
    }
    public void deleteAllInBatch(List<Product> productList) {
        productRepository.deleteAllInBatch(productList);
        log.info(InfoMessage.PRODUCT_DELETED_IN_BATCH);
    }
}
