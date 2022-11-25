package com.example.herocompany.repositories;

import com.example.herocompany.entities.Customer;
import com.example.herocompany.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.price = '123'")
    List<Product> findProductsByPrice();

    @Query("SELECT p FROM Product p WHERE p.price >= :price")
    List<Product> findProductsByPriceGreaterThanEqual(
            @Param("price") Integer price);


}