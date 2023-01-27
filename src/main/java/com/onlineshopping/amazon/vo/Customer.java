package com.onlineshopping.amazon.vo;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Name should not have special character")
    private String customerName;
    @NotNull(message = "Address cannot be null")
    private String address;
    @NotNull(message = "City cannot be null")
    private String city;
    @NotNull(message = "Country cannot be null")
    private String country;


}
