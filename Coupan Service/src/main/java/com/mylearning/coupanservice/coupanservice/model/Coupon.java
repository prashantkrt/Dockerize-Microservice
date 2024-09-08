package com.mylearning.coupanservice.coupanservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "coupon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name="Code")
    private String code;
    @Column(name="Discount")
    private BigDecimal discount;
    @Column(name="Expiration_Date")
    private String expirationDate;
}
