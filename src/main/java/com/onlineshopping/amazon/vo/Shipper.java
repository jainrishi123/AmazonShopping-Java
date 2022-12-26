package com.onlineshopping.amazon.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Shipper {


    String shipperName;
    Long phone;
    private int shipperId;


}