package com.example.coupon.service;

import com.example.coupon.domain.Coupon;
import com.example.coupon.domain.IssuedCoupon;
import com.example.coupon.domain.domainEnum.CouponStatus;
import com.example.coupon.domain.domainEnum.CouponType;
import com.example.coupon.dto.ApiResponse;
import com.example.coupon.dto.CouponDTO;
import com.example.coupon.repository.CouponRepository;
import com.example.coupon.repository.CouponUsageHistoryRepository;
import com.example.coupon.repository.IssuedCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueCouponService {
    private final CouponRepository couponRepository;
    private final IssuedCouponRepository issuedCouponRepository;
    private final CouponUsageHistoryRepository couponUsageHistoryRepository;

//    @Transactional
    public Long issueCoupon(Long couponId, long userId) {
        if (issuedCouponRepository.existsByCouponIdAndUserId(couponId, userId)) {
            throw new IllegalStateException("이미 발급받은 쿠폰입니다.");
        }
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 쿠폰입니다."));
        coupon.issue(); //+1 하는부분
//        couponRepository.flush();
        return issuedCouponRepository.save(IssuedCoupon.issue(coupon, userId)).getId();//insert
    }
}
