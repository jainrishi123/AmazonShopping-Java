package com.onlineshopping.amazon.controller;

import com.onlineshopping.amazon.service.ShipperService;
import com.onlineshopping.amazon.vo.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin
@Controller
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    @GetMapping("/v1/shipper")
    ResponseEntity<List<Shipper>> getShippers() {
        return new ResponseEntity<>(shipperService.getShippers(), HttpStatus.OK);
    }
}
