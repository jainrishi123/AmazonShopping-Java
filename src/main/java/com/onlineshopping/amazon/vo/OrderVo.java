package com.onlineshopping.amazon.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVo {
    @NotNull(message = "Date is required")
    @Pattern(regexp = "^(2[0-9]{3})-(0[1-9]|1[012])-(0[1-9]|[12][1-9]|[3][01])", message = "date should be in yyyy-mm-dd format and should be valid")
    private String date;
    @NotNull(message = "CustomerVo Id is required")
    private int customerID;
    @NotNull(message = "Shipper Id is required")
    private int shipperID;
    @NotNull(message = "OrderVo detail is required")
    private List<OrderDetailsVo> orderDetails;

}