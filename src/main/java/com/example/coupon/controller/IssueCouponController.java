package com.example.coupon.controller;

import com.example.coupon.dto.ApiResponse;
import com.example.coupon.dto.CouponDTO;
import com.example.coupon.service.IssueCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class IssueCouponController {
    private final IssueCouponService issuedCouponService;


    @GetMapping("/available")
    public ApiResponse<List<CouponDTO>> getAvailableCoupons() {
        return ApiResponse.success(issuedCouponService.getAvailableCoupon());

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
