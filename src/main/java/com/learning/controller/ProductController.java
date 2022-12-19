package com.learning.controller;

import com.learning.entity.Product;
import com.learning.s2s.shared.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
public interface ProductController {

    @GetMapping
    public List<Product> getAllProducts();

    @GetMapping("/car")
    public List<Car> getAllCars();

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id);

    @PostMapping
    public String addProduct(@RequestBody Product product);

    @PostMapping("/add-all")
    public String addAllProducts(@RequestBody List<Product> productList);

    @PutMapping("/{id}")
    public String updateProductById(@PathVariable Long id, @RequestBody Product product);

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id);

    @DeleteMapping("/delete-all")
    public String deleteAllProducts();

    @DeleteMapping("/delete-in-batch")
    public String deleteAllInBatch(@RequestBody List<Product> productList);

}
