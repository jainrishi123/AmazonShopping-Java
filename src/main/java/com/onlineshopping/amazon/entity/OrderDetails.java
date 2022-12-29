package com.onlineshopping.amazon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

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
