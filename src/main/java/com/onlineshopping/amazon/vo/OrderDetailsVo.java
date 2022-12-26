package com.onlineshopping.amazon.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsVo {
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "ProductVo ID is required")
    private int productID;

}
