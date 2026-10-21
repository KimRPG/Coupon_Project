package com.example.coupon.dto;

import com.example.coupon.domain.domainEnum.CouponStatus;
import com.example.coupon.domain.domainEnum.CouponType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record CouponDTO(
        Long id,
        String name,
        String description,
        CouponType couponType,
        CouponStatus couponStatus,
        int discountValue,
        Integer minOrderAmount,
        Integer maxDiscountAmount,
        int totalQuantity,
        int issuedQuantity,
        int validDays,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
