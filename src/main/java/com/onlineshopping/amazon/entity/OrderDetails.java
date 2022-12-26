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
    @JsonBackReference
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    Order order;
    int orderId;
    @ManyToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    Product product;
    int productId;
    int quantity;
}
