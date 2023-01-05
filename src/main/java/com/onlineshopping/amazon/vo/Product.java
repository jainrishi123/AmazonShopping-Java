package com.onlineshopping.amazon.vo;


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
    private Integer supplierId;
    @NotBlank(message = "productName cannot be empty")
    private String productName;
    @NotBlank(message = "productName cannot be empty")
    String productImage;



}



