package com.onlineshopping.amazon.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer implements Serializable {


    @Min(value = 10000, message = "Enter valid Postal Code")
    Integer postalCode;
    private Integer customerId;
    @NotNull(message = "Customer name cannot be null")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Name should not have digits and special character")
    private String customerName;
    @NotNull(message = "Address cannot be null")
    private String address;
    @NotNull(message = "City cannot be null")
    private String city;
    @NotNull(message = "Country cannot be null")
    private String country;


}
