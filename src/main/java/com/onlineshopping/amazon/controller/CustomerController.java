package com.onlineshopping.amazon.controller;


import com.onlineshopping.amazon.service.CustomerService;
import com.onlineshopping.amazon.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Validated
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/v1/customer")
    ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @PostMapping("/v1/customer")
    ResponseEntity<String> saveCustomer(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
    }

    @PutMapping("/v1/customer")
    ResponseEntity<String> updateCustomer(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

}
