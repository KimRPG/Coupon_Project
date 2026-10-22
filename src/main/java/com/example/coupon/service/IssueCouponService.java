package com.example.coupon.service;

import com.example.coupon.dto.ApiResponse;
import com.example.coupon.dto.CouponDTO;
import com.example.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueCouponService {
    private CouponDTO couponDTO;
    private final CouponRepository couponRepository;

}
