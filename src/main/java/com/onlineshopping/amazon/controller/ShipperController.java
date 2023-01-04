package com.onlineshopping.amazon.controller;

import com.onlineshopping.amazon.service.ShipperService;
import com.onlineshopping.amazon.vo.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/v1/shipper")
    ResponseEntity<String> saveShipper(@RequestBody @Valid Shipper shipper){
        return new ResponseEntity<>(shipperService.saveShipper(shipper),HttpStatus.OK);
    }

    @DeleteMapping("/v1/shipper/{sid}")
    ResponseEntity<String> deleteShipper(@PathVariable Integer sid){
        return new ResponseEntity<>(shipperService.deleteShipper(sid),HttpStatus.OK);
    }
}
