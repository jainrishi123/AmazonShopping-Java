package com.onlineshopping.amazon.service;

import com.onlineshopping.amazon.entity.*;
import com.onlineshopping.amazon.exception.CustomerException;
import com.onlineshopping.amazon.exception.ProductException;
import com.onlineshopping.amazon.exception.SupplierException;
import com.onlineshopping.amazon.repository.CustomerRepository;
import com.onlineshopping.amazon.repository.OrderRepository;
import com.onlineshopping.amazon.repository.ProductRepository;
import com.onlineshopping.amazon.repository.ShipperRepository;
import com.onlineshopping.amazon.vo.OrderDetailsVo;
import com.onlineshopping.amazon.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShipperRepository shipperRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;

    static Order getEntityOrder(OrderVo orderVo) throws ParseException {
        Order order = new Order();
        Customer customer = new Customer();
        customer.setCustomerId(orderVo.getCustomerID());
        Shipper shipper = new Shipper();
        shipper.setShipperId(orderVo.getShipperID());
        List<OrderDetails> orderDetails = new ArrayList<>();
        for (OrderDetailsVo orderDetailsVo : orderVo.getOrderDetails()) { //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetails(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);
        order.setShipper(shipper);
        return order;
//        return Order.builder().date((Date) new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate())).
//                shipper(shipper).customer(customer).orderDetails(orderDetails).build();


    }

    static Order convertToOrders(OrderVo orderVo) throws ParseException {
        Order order = new Order();
        order.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate()));
        Customer customers = new Customer();
        customers.setCustomerId(orderVo.getCustomerID());
        order.setCustomer(customers);
        Shipper shippers = new Shipper();
        shippers.setShipperId(orderVo.getShipperID());
        order.setShipper(shippers);
        List<OrderDetails> orderDetails = new ArrayList<>(); // Generics
        for (OrderDetailsVo orderDetailsVo : orderVo.getOrderDetails()) { //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetails(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);
        return order;
    }

    public List<Order> getByCustomerId(int cid){
        return orderRepository.findByCustomerCustomerId(cid);
    }
    public List<Order> getOrder() {

        return orderRepository.findAll();
    }

    //    public String saveOrder(OrderVo order) throws ParseException {
//        orderRepository.save(getEntityOrder(order));
//        return "Order Saved";
//    }
    public String saveOrder(OrderVo order) throws ParseException {
        for(OrderDetailsVo o:order.getOrderDetails()){
            Product p=productRepository.findById(o.getProductID()).orElseThrow(()->
                    new ProductException("Product Not Found with Product Id"+o.getProductID()));
            if(o.getQuantity()>p.getUnit()){
                throw new ProductException(p.getProductName()+" is Out of Stock");
            }
            else {
                p.setUnit(p.getUnit()-o.getQuantity());
                productService.updateProduct(productService.getVoProduct(p));
            }
        }
        Order orderEntity = convertToOrders(order);

//        for (OrderDetails o : orderEntity.getOrderDetails()) {
//            Product p = productRepository.findById(o.getProduct().getProductID()).get();
//            if (o.getQuantity() > p.getUnit()) {
//                throw new ProductException(p.getProductName() + "is Out of Stock");
//            } else {
//                p.setUnit(p.getUnit() - o.getQuantity());
//                productRepository.save(p);
//            }
//        }


        if (customerRepository.findById(order.getCustomerID()).isEmpty())
            throw new CustomerException("Customer not found with Customer Id" + order.getCustomerID());
        if (shipperRepository.findById(order.getShipperID()).isEmpty())
            throw new SupplierException("Shipper not found with Shipper Id:" + order.getShipperID());
        orderRepository.save(orderEntity);
        return "Order Place";
    }

    public OrderVo getVoOrder(Order order) {
        OrderVo orderVo = new OrderVo();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        orderVo.setDate(dateFormat.format(order.getDate()));
        orderVo.setCustomerID(order.getCustomer().getCustomerId());
        orderVo.setShipperID(order.getShipper().getShipperId());
        List<OrderDetailsVo> orderVos = new ArrayList<>();
        for (OrderDetails o : order.getOrderDetails()) {
            orderVos.add(OrderDetailsVo.builder().productID(o.getProduct().getProductID()).quantity(o.getQuantity()).build());
        }
        orderVo.setOrderDetails(orderVos);
        return orderVo;

    }


}
