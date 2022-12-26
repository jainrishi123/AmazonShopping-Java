package com.onlineshopping.amazon.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Customer_10709086")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;


    private String customerName;

    private String address;

    private String city;

    int postalCode;
    private String country;


}