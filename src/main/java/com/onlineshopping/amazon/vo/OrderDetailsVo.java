package com.onlineshopping.amazon.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.validation.constraints.NotNull;
import jakarta.persistence.*;
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
