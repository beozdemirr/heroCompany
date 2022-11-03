package com.example.herocompany.repositories;

import com.example.herocompany.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {


}