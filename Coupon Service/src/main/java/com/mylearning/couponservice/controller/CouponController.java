package com.mylearning.couponservice.controller;

import com.mylearning.couponservice.dto.CouponDto;
import com.mylearning.couponservice.model.Coupon;
import com.mylearning.couponservice.repository.CouponRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponRepo couponRepo;

    public CouponController(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    @PostMapping(value = "/createCoupon")
    public Coupon createCoupon(@RequestBody CouponDto couponDto) {
        Coupon coupon = new Coupon();
        coupon.setCode(couponDto.getCode());
        coupon.setDiscount(couponDto.getDiscount());
        coupon.setExpirationDate(couponDto.getExpirationDate());
        return couponRepo.save(coupon);
    }

    @GetMapping(value = "/getCoupon/{code}")
    public Coupon getCoupon(@PathVariable("code") String couponCode) {
        return couponRepo.findByCode(couponCode);
    }

}
