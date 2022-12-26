package com.onlineshopping.amazon.service;

import com.onlineshopping.amazon.entity.OrderDetails;
import com.onlineshopping.amazon.entity.Product;
import com.onlineshopping.amazon.exception.ProductException;
import com.onlineshopping.amazon.repository.ProductRepository;
import com.onlineshopping.amazon.vo.OrderDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class OrderDetailsService {

    @Autowired
    ProductRepository productRepository;

    static ProductRepository productRepositoryclone;

    @PostConstruct
    void initial(){
        productRepositoryclone=productRepository;
    }
    public  static OrderDetails convertToOrderDetails(OrderDetailsVo orderDetailsVo){
        OrderDetails orderDetails=new OrderDetails();
        Product pro=productRepositoryclone.findById(orderDetails.getProduct().getProductID()).orElseThrow(()->new ProductException("Product Not Found With Product ID: "+ orderDetails.getProduct().getProductID()));
        orderDetails.setProduct(pro);
        orderDetails.setQuantity(orderDetailsVo.getQuantity());
        return orderDetails;
    }
}
