package com.example.herocompany.services;


import com.example.herocompany.entities.Customer;
import com.example.herocompany.repositories.CustomerRepository;
import com.example.herocompany.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServices {

    final CustomerRepository customerRepository;


    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }


    public ResponseEntity<Map<REnum, Object>> save(Customer customer) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        customerRepository.save(customer);
        hashMap.put(REnum.status, true);
        hashMap.put(REnum.result, customer);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

  /*  public Customer save(Customer customer) {
        Customer customer1 = new Customer();
        customer1.setCustomerPhone(customer.getCustomerPhone());
        customer1.setCustomerFirstName(customer.getCustomerFirstName());
        customer1.setCustomerLastName(customer.getCustomerLastName());
        customerRepository.save(customer1);

       return customer1;


    }*/



    public ResponseEntity<Map<REnum, Object>> delete(Long id) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            customerRepository.deleteById(id);
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
        hashMap.put(REnum.result, customerRepository.findAll());
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum, Object>> showById(Long id) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            if (customer.isPresent()) {
                hashMap.put(REnum.status, true);
                hashMap.put(REnum.result, customer);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            } else {
                hashMap.put(REnum.status, false);
                hashMap.put(REnum.result, "Not found customer");
                return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            hashMap.put(REnum.status, false);
            hashMap.put(REnum.message, e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Map<REnum, Object>> update(Customer customer) {
        Map<REnum, Object> hashMap = new LinkedHashMap<>();
        try {
            Optional<Customer> customer1 = customerRepository.findById(customer.getId());
            if (customer1.isPresent()) {
                customerRepository.saveAndFlush(customer);
                hashMap.put(REnum.status, true);
                hashMap.put(REnum.result, customer);
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            } else {
                hashMap.put(REnum.status, false);
                hashMap.put(REnum.result, "not found customer");
                return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            hashMap.put(REnum.status, false);
            hashMap.put(REnum.message, e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

    }


}

