package com.example.herocompany.controllers;


import com.example.herocompany.entities.Customer;
import com.example.herocompany.repositories.CustomerRepository;
import com.example.herocompany.services.CustomerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    final CustomerRepository customerRepository;
    final CustomerServices customerServices;

    public CustomerController(CustomerRepository customerRepository, CustomerServices customerServices) {
        this.customerRepository = customerRepository;
        this.customerServices = customerServices;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Customer customer) {return customerServices.save(customer);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {return customerServices.delete(id);}

    @GetMapping("/showAll")
    public ResponseEntity showAll() {return customerServices.showAll();}


    @GetMapping("/showById/{id}")
    public ResponseEntity showById(@PathVariable Long id) {return customerServices.showById(id);}

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Customer customer){
        return customerServices.update(customer);
    }

}
