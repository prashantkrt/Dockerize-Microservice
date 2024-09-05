package com.mylearning.coupanservice.coupanservice.repository;

import com.mylearning.coupanservice.coupanservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long> {
    public Coupon findByCouponCode(String couponCode);
}
