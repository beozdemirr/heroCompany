package com.example.herocompany.controllers;


import com.example.herocompany.entities.Product;
import com.example.herocompany.repositories.ProductRepository;
import com.example.herocompany.services.ProductServices;
import com.example.herocompany.utils.REnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    final ProductServices productServices;
    final ProductRepository productRepository;

    public ProductController(ProductServices productServices, ProductRepository productRepository) {
        this.productServices = productServices;
        this.productRepository = productRepository;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return productServices.save(product);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable  Long id) {
        return productServices.delete(id);
    }

    @GetMapping("/showAll")
    public ResponseEntity showAll() {
        return  productServices.showAll();
    }

    @GetMapping("/showById/{id}")
    public ResponseEntity showById(@PathVariable Long id) {
        return productServices.showById(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product){
        return productServices.update(product);
    }

}
