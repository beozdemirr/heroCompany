package com.example.herocompany.controllers;

import com.example.herocompany.entities.Category;
import com.example.herocompany.repositories.CategoryRepository;
import com.example.herocompany.services.CategoryServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryContreller {
    final CategoryServices categoryServices;

    final CategoryRepository categoryRepository;

    public CategoryContreller(CategoryServices categoryServices, CategoryRepository categoryRepository) {
        this.categoryServices = categoryServices;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category){
        return categoryServices.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
      return   categoryServices.delete(id);
    }

    @GetMapping("/showAll")
    public ResponseEntity showAll(){
        return categoryServices.showAll();
    }

    @GetMapping("/showById/{id}")
    public ResponseEntity showById(@PathVariable Long id){
        return categoryServices.showById(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category){
        return categoryServices.update(category);

    }

}
