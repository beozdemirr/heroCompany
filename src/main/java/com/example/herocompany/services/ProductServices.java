package com.example.herocompany.services;


import com.example.herocompany.entities.Product;
import com.example.herocompany.dto.ProductDto;
import com.example.herocompany.repositories.AttributeRepository;
import com.example.herocompany.repositories.CategoryRepository;
import com.example.herocompany.repositories.ProductRepository;
import com.example.herocompany.utils.REnum;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ProductServices {

    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;
    final AttributeRepository attributeRepository;

    public ProductServices(ProductRepository productRepository, CategoryRepository categoryRepository, AttributeRepository attributeRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.attributeRepository = attributeRepository;
    }

    public ResponseEntity<Map<REnum, Object>> save(ProductDto productDto) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setDetail(productDto.getDetail());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryRepository.findById(productDto.getCategoryId()).get());
        product.setAttributes(attributeRepository.findAllById(productDto.getAttributesIdList()));
     //   product.setAttributes(attributeList(productDto.getAttributesIdList()));
        productRepository.save(product);
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, productDto);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);

    }

/*    public List<Attribute> attributeList(List<Long> attributeIdList){
        return attributeRepository.findAllById(attributeIdList);
    }*/


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

    public ResponseEntity<Map<REnum, Object>> findProductsByCategory() {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, productRepository.findProductsByPrice());
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum, Object>> findProductsByPriceGreaterThanEqual(@Param("price") int price) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, productRepository.findProductsByPriceGreaterThanEqual(price));
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

}



