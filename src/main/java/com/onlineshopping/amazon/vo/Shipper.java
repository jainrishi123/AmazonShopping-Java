package com.onlineshopping.amazon.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

//import javax.validation.constraints.NotNull;

@Data
@Builder
public class Shipper {

    @NotNull(message = "Shipper Must Not Be Null")
    String shipperName;
    @NotNull(message = "Phone Number Must be 10 Digits")
    Long phone;
    private int shipperId;


}