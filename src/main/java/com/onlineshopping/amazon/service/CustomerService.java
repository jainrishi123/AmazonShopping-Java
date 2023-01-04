package com.onlineshopping.amazon.service;

import com.onlineshopping.amazon.entity.Customer;
import com.onlineshopping.amazon.exception.CustomerException;
import com.onlineshopping.amazon.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public List<com.onlineshopping.amazon.vo.Customer> getCustomers() {
        List<com.onlineshopping.amazon.vo.Customer> cus = new ArrayList<>();
        for (Customer c : customerRepository.findAll())
            cus.add(getVoCustomer(c));
        return cus;
    }

    public String saveCustomer(com.onlineshopping.amazon.vo.Customer customer) {

        customerRepository.save(getEntityCustomer(customer));
        return "New Customer Saved";

    }

    public String updateCustomer(com.onlineshopping.amazon.vo.Customer customer) {
        if (customerRepository.findById(customer.getCustomerId()).isEmpty()) {
            throw new CustomerException("Customer does not exist with CustomerId: " + customer.getCustomerId());
        } else {
            customerRepository.save(getEntityCustomer(customer));
            return "Customer Updated";
        }
    }

    public String deleteCustomer(Integer cid) {
        customerRepository.delete(customerRepository.findById(cid).orElseThrow(()
                -> new CustomerException("Customer Not Found with Customer Id: " + cid)));
        return ("Customer Deleted with Customer Id: " + cid);
    }

    public Customer getEntityCustomer(com.onlineshopping.amazon.vo.Customer customer) {
        return Customer.builder().customerName(customer.getCustomerName())
                .address(customer.getAddress()).city(customer.getCity()).postalCode(customer.getPostalCode()).
                country(customer.getCountry()).build();
    }

    public com.onlineshopping.amazon.vo.Customer getVoCustomer(Customer customer) {
        return com.onlineshopping.amazon.vo.Customer.builder().customerId(customer.getCustomerId()).
                customerName(customer.getCustomerName()).address(customer.getAddress()).city(customer.getCity()).
                postalCode(customer.getPostalCode()).country(customer.getCountry()).build();
    }
}
