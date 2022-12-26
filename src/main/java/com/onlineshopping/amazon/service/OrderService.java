package com.onlineshopping.amazon.service;

import com.onlineshopping.amazon.entity.Customer;
import com.onlineshopping.amazon.entity.Order;
import com.onlineshopping.amazon.entity.OrderDetails;
import com.onlineshopping.amazon.entity.Shipper;
import com.onlineshopping.amazon.repository.OrderRepository;
import com.onlineshopping.amazon.vo.OrderDetailsVo;
import com.onlineshopping.amazon.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    static Order getOrder(OrderVo orderVo) throws ParseException {
        Order order = new Order();
        Customer customer = new Customer();
        customer.setCustomerId(orderVo.getCustomerID());
        Shipper shipper = new Shipper();
        shipper.setShipperId(orderVo.getShipperID());
        List<OrderDetails> orderDetails = new ArrayList<>();
        for (OrderDetailsVo orderDetailsVo : orderVo.getOrderDetailVos()) { //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetails(orderDetailsVo));
        }

        return Order.builder().date((Date) new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate())).
                shipper(shipper).customer(customer).orderDetails(orderDetails).build();



    }

    public List<OrderVo> getOrder() {
        List<OrderVo> orders = new ArrayList<>();
        for (Order o : orderRepository.findAll())
            orders.add(getVoOrder(o));
        return orders;
    }

    public String saveOrder(Order order) {
        orderRepository.save(order);
        return "Order Saved";
    }

    public OrderVo getVoOrder(Order order) {
        OrderVo orderVo = new OrderVo();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        orderVo.setDate(dateFormat.format(order.getDate()));
        orderVo.setCustomerID(order.getCustomer().getCustomerId());
        orderVo.setShipperID(order.getShipper().getShipperId());
        List<OrderDetailsVo> orderVos = new ArrayList<>();
        for (OrderDetails o : order.getOrderDetails()) {
            orderVos.add(OrderDetailsVo.builder().productID(o.getProductId()).quantity(o.getQuantity()).build());
        }
        orderVo.setOrderDetailVos(orderVos);
        return orderVo;

    }


}
