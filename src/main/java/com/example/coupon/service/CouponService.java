package com.example.coupon.service;

import com.example.coupon.domain.Coupon;
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
public class CouponService {
    private final CouponRepository couponRepository;
    private final IssuedCouponRepository issuedCouponRepository;
    private final CouponUsageHistoryRepository couponUsageHistoryRepository;

    public List<CouponDTO> getAvailableCoupon(){
        return couponRepository.findByCouponStatusAndEndDateAfter(CouponStatus.ACTIVE, LocalDateTime.now())
                .stream()
                .map(CouponDTO::from)
                .toList();
    }

    public Integer getAvailableCouponCount(Long id) {
        Coupon coupon =  couponRepository.findById(id)
                .orElseThrow();
        return coupon.getTotalQuantity() - coupon.getIssuedQuantity();
    }

    @Transactional
    public Integer resetCouponStock(Long id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow();

        couponUsageHistoryRepository.deleteByCouponId(id);
        issuedCouponRepository.deleteByCouponId(id);
        coupon.resetIssuedQuantity();
        return coupon.getTotalQuantity();
    }
}
