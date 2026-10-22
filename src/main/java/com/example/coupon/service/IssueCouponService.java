package com.example.coupon.service;

import com.example.coupon.domain.Coupon;
import com.example.coupon.domain.domainEnum.CouponStatus;
import com.example.coupon.domain.domainEnum.CouponType;
import com.example.coupon.dto.ApiResponse;
import com.example.coupon.dto.CouponDTO;
import com.example.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueCouponService {
    private CouponDTO couponDTO;
    private final CouponRepository couponRepository;

    public List<CouponDTO> getAvailableCoupon(){
        return couponRepository.findByCouponStatusAndEndDateAfter(CouponStatus.ACTIVE, LocalDateTime.now())
                .stream()
                .map(CouponDTO::from)
                .toList();
    }

}
