package com.onlineshopping.amazon.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_10709086")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @ManyToOne @JoinColumn(name = "shipperId")
    private Shipper shipper;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private List<OrderDetails> orderDetails;

}
