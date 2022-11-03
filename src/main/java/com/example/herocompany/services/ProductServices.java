package com.example.herocompany.services;


import com.example.herocompany.entities.Product;
import com.example.herocompany.repositories.ProductRepository;
import com.example.herocompany.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ProductServices {

    final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Map<REnum, Object>> save(Product product) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        Product product1 = productRepository.save(product);
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, product);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum, Object>> delete(Long id) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            productRepository.deleteById(id);
            hashMap.put(REnum.status, true);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception e) {
            hashMap.put(REnum.status, false);
            hashMap.put(REnum.message, e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<Map<REnum, Object>> showAll() {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, productRepository.findAll());
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }


    public ResponseEntity<Map<REnum, Object>> showById(Long id) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                hashMap.put(REnum.status, true);
                hashMap.put(REnum.result, productRepository.findById(id));
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            } else {

                hashMap.put(REnum.status, false);
                hashMap.put(REnum.result, "Not found customer");
                return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            hashMap.put(REnum.status, false);
            hashMap.put(REnum.message, e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }


    }

    public ResponseEntity<Map<REnum, Object>> update(Product product) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<Product> product1 = productRepository.findById(product.getId());
            if (product1.isPresent()) {
                productRepository.saveAndFlush(product);
                hashMap.put(REnum.status, true);
                hashMap.put(REnum.result, product);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            } else {
                hashMap.put(REnum.status, false);
                hashMap.put(REnum.result, "not found product");
                return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            hashMap.put(REnum.status, false);
            hashMap.put(REnum.message, e.getMessage());
            return new ResponseEntity<>(hashMap,HttpStatus.BAD_REQUEST);
        }


    }

}


//password ve username kontrolü tek satırda if ile yapılacak
//şifre şifreleme
//md5 metodu diye arat





//müşteri password ekle

