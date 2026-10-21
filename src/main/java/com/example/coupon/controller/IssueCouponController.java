package com.example.coupon.controller;

import com.example.coupon.domain.Coupon;
import com.example.coupon.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class IssueCouponController {
    @GetMapping("/available")
    public List<ApiResponse<Coupon>> getAvailableCoupons() {
        List<ApiResponse<Coupon>> test = new ArrayList<>();
        test.add(new ApiResponse<Coupon>(true, new Coupon(), "test"));
        return test;
    }

    @PostMapping("/{couponId}/issue")
    public ApiResponse<String> issueCoupon(@PathVariable Long couponId) {
        return new ApiResponse<>(true, "hi", "test");
    }

    @GetMapping("/{couponId}/stock")
    public ApiResponse<String> getCouponStock(@PathVariable Long couponId) {
        return new ApiResponse<>(true, "hi", "test");
    }
}
