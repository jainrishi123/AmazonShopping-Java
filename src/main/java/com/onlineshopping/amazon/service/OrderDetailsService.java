package com.onlineshopping.amazon.service;

import com.onlineshopping.amazon.entity.OrderDetails;
import com.onlineshopping.amazon.entity.Product;
import com.onlineshopping.amazon.vo.OrderDetailsVo;

public class OrderDetailsService {

    public static OrderDetails convertToOrderDetails(OrderDetailsVo orderDetailsVo) {
        OrderDetails orderDetails = new OrderDetails();
        Product pro = new Product();
        pro.setProductID(orderDetailsVo.getProductID());
        orderDetails.setProduct(pro);

        orderDetails.setQuantity(orderDetailsVo.getQuantity());
        return orderDetails;
    }

//
}
