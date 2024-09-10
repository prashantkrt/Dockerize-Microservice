package com.mylearning.couponservice.repository;

import com.mylearning.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {
    public Coupon findByCode(String couponCode);
}
