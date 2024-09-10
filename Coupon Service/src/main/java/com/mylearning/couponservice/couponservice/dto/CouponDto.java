package com.mylearning.couponservice.couponservice.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CouponDto {
    private String code;
    private BigDecimal discount;
    private String expirationDate;
}
