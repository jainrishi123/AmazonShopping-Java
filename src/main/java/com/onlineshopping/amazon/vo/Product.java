package com.onlineshopping.amazon.vo;
//
//import com.onlineshopping.amazon.entity.Supplier;
//import com.onlineshopping.amazon.repository.SupplierRepository;
//import lombok.Builder;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.*;
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Pattern;
//
//
//@Builder
//@Data
//public class Product {
//
//
//    private int productID;
//
//
//
//    @Min(value = 1,message = "Minimum should be 1")
//    int unit;
//    int price;
//    int supplierId;
//    @Pattern(regexp = "^[0-9]",message = "Must be in digits")
//    String productName;
//
//
//
//
//    //    Present In Product Service Layer
//
//
//
////    public static Product getvoProduct(com.onlineshopping.amazon.entity.Product product){
////        Product p=new Product();
////        p.setPrice(product.getPrice());
////        p.setProductID(product.getProductID());
////        p.setProductName(product.getProductName());
////        p.setUnit(product.getUnit());
////        p.setSupplierId(product.getSupplierId());
////        p.setSupplier(product.getSupplier());
////        return p;
////    }
////
//
//
//
////    public static com.onlineshopping.amazon.entity.Product getEntityProduct(Product p){
//////        com.onlineshopping.amazon.entity.Product p1=com.onlineshopping.amazon.entity.Product.builder().
//////        productID(p.getProductID()).productName(p.getProductName()).price(p.getPrice()).unit(p.getUnit()).build();
////        com.onlineshopping.amazon.entity.Product p1=new com.onlineshopping.amazon.entity.Product();
////        p1.setPrice(p.getPrice());
////        p1.setProductID(p.getProductID());
////        p1.setProductName(p.getProductName());
////        p1.setUnit(p.getUnit());
////        p1.setSupplier(p.getSupplier());
////        p1.setSupplierId(p.getSupplierId());
////        return p1;
//
//    }


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
public class Product {

    private int productID;
    @Min(value = 1, message = "Minimum 1 Unit is required")
    private Integer unit;

    @NotNull
    private Integer price;
    @NotNull
//    @Pattern(regexp = "[0-9]*",message = "Must be valid Id")
    private Integer supplierId;
    @NotBlank(message = "productName cannot be empty")
    private String productName;


}



