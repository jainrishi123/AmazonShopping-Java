package com.onlineshopping.amazon.controller;

import com.onlineshopping.amazon.entity.Order;
import com.onlineshopping.amazon.service.OrderService;
import com.onlineshopping.amazon.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/v1/order")
    ResponseEntity<List<Order>> getOrder() {

        return new ResponseEntity<>(orderService.getOrder(), HttpStatus.OK);
    }

    @PostMapping("/v1/order")
    ResponseEntity<String> saveOrder(@RequestBody OrderVo order) throws ParseException {
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
    }

    @GetMapping("/v1/order/{cid}")
    ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable int cid){
        return new ResponseEntity<>(orderService.getByCustomerId(cid),HttpStatus.OK);
    }
}
