package com.example.herocompany.services;

import com.example.herocompany.entities.Category;
import com.example.herocompany.repositories.CategoryRepository;
import com.example.herocompany.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Transactional
@Service
public class CategoryServices {


    final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    public ResponseEntity<Map<REnum, Object>> save(Category category) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        categoryRepository.save(category);
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, category);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum, Object>> delete(Long id) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            categoryRepository.deleteById(id);
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
        hashMap.put(REnum.result, categoryRepository.findAll());
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum, Object>> showById(Long id) {
        Map<REnum, Object> hashmap = new LinkedHashMap<>();
        try {
            Optional<Category> category = categoryRepository.findById(id);
            if (category.isPresent()) {
                hashmap.put(REnum.status, true);
                hashmap.put(REnum.result, category);
                return new ResponseEntity<>(hashmap, HttpStatus.OK);
            } else {
                hashmap.put(REnum.status, false);
                hashmap.put(REnum.result, "Not found category");
                return new ResponseEntity<>(hashmap, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            hashmap.put(REnum.status, false);
            hashmap.put(REnum.message, e.getMessage());
            return new ResponseEntity<>(hashmap, HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<Map<REnum, Object>> update(Category category) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
            if (optionalCategory.isPresent()) {
                categoryRepository.saveAndFlush(category);
                hashMap.put(REnum.status, true);
                hashMap.put(REnum.result, category);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);

            } else {
                hashMap.put(REnum.status, false);
                hashMap.put(REnum.result, "not found category");
                return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception e) {
            hashMap.put(REnum.status, false);
            hashMap.put(REnum.result, e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);

        }
    }

}
