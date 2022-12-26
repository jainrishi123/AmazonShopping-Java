package com.onlineshopping.amazon.controller;

import com.onlineshopping.amazon.entity.Order;
import com.onlineshopping.amazon.service.OrderService;
import com.onlineshopping.amazon.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/v1/order")
    ResponseEntity<List<OrderVo>> getOrder() {
        return new ResponseEntity<>(orderService.getOrder(), HttpStatus.OK);
    }

    @PostMapping("/v1/order")
    ResponseEntity<String> saveOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
    }
}
