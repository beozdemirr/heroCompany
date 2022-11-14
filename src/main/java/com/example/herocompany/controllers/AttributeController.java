package com.example.herocompany.controllers;


import com.example.herocompany.entities.Attribute;
import com.example.herocompany.repositories.AttributeRepository;
import com.example.herocompany.services.AttributeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    final AttributeServices attributeServices;

    final AttributeRepository attributeRepository;

    public AttributeController(AttributeServices attributeServices, AttributeRepository attributeRepository) {
        this.attributeServices = attributeServices;
        this.attributeRepository = attributeRepository;
    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Attribute attribute) {
        return attributeServices.save(attribute);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return attributeServices.delete(id);
    }

    @GetMapping("/showAll")
    public ResponseEntity showAll() {
        return attributeServices.showAll();
    }

    @GetMapping("/showById/{id}")
    public ResponseEntity showById(@PathVariable Long id) {
        return attributeServices.showById(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Attribute attribute) {
        return attributeServices.update(attribute);

    }
}

