package com.example.coupon.controller;

import com.example.coupon.dto.ApiResponse;
import com.example.coupon.dto.CouponDTO;
import com.example.coupon.dto.IssueCouponRequest;
import com.example.coupon.service.CouponService;
import com.example.coupon.service.IssueCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class IssueCouponController {
    private final CouponService couponService;
    private final IssueCouponService issueCouponService;


    @GetMapping("/available")
    public ApiResponse<List<CouponDTO>> getAvailableCoupons() {
        return ApiResponse.success(couponService.getAvailableCoupon());

    }

    @PostMapping("/{couponId}/issue")
    public ApiResponse<Long> issueCoupon(@PathVariable Long couponId, @RequestBody IssueCouponRequest request) {
        return ApiResponse.success(issueCouponService.issueCoupon(couponId, request.userId()));
    }

    @GetMapping("/{couponId}/stock")
    public ApiResponse<Integer> getCouponStock(@PathVariable Long couponId) {
        return ApiResponse.success(couponService.getAvailableCouponCount(couponId));
    }

    @PostMapping("/{couponId}/stock/init")
    public ApiResponse<Integer> initCouponStock(@PathVariable Long couponId) {
        return ApiResponse.success(couponService.resetCouponStock(couponId));
    }

}
