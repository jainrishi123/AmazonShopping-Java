package com.onlineshopping.amazon.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onlineshopping.amazon.entity.Customer;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
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
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    Customer customer;

    @ManyToOne @JoinColumn(name = "shipperId")
    private Shipper shipper;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JoinColumn(name = "orderId")
    private List<OrderDetails> orderDetails;

}
