package com.onlineshopping.amazon.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "OrderDetail_10709086")
public class OrderDetails {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int orderDetailId;
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;
    int quantity;
}
