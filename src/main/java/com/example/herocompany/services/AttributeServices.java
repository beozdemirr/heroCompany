package com.example.herocompany.services;


import com.example.herocompany.dto.AttributeDto;
import com.example.herocompany.entities.Attribute;
import com.example.herocompany.repositories.AttributeRepository;
import com.example.herocompany.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AttributeServices {

    final AttributeRepository attributeRepository;

    public AttributeServices(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public ResponseEntity<Map<REnum, Object>> save(AttributeDto attributeDto) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        Attribute attribute = new Attribute();
        attribute.setFeature(attributeDto.getFeature());
        attributeRepository.save(attribute);
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, attribute);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }


    public ResponseEntity<Map<REnum, Object>> delete(Long id) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            attributeRepository.deleteById(id);
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
        hashMap.put(REnum.result, attributeRepository.findAll());
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum, Object>> showById(Long id) {
        Map<REnum, Object> hashmap = new LinkedHashMap<>();
        try {
            Optional<Attribute> attribute = attributeRepository.findById(id);
            if (attribute.isPresent()) {
                hashmap.put(REnum.status, true);
                hashmap.put(REnum.result, attribute);
                return new ResponseEntity<>(hashmap, HttpStatus.OK);
            } else {
                hashmap.put(REnum.status, false);
                hashmap.put(REnum.result, "Not found attribute");
                return new ResponseEntity<>(hashmap, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            hashmap.put(REnum.status, false);
            hashmap.put(REnum.message, e.getMessage());
            return new ResponseEntity<>(hashmap, HttpStatus.BAD_REQUEST);

        }
    }


    public ResponseEntity<Map<REnum, Object>> update(Attribute attribute) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<Attribute> optionalAttribute = attributeRepository.findById(attribute.getId());
            if (optionalAttribute.isPresent()) {
                attributeRepository.saveAndFlush(attribute);
                hashMap.put(REnum.status, true);
                hashMap.put(REnum.result, attribute);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);

            } else {
                hashMap.put(REnum.status, false);
                hashMap.put(REnum.result, "not found attribute");
                return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception e) {
            hashMap.put(REnum.status, false);
            hashMap.put(REnum.result, e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);

        }
    }


}
