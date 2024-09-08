package com.mylearning.productservice.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coupon {
    private Long id;
    private String code;
    private BigDecimal discount;
    private String expirationDate;
}
