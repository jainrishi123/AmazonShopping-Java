package com.onlineshopping.amazon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "Shipper_10709086")
@NoArgsConstructor
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shipperId;
    String shipperName;
    Long phone;


}
