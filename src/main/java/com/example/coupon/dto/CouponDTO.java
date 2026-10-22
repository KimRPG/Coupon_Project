package com.example.coupon.dto;

import com.example.coupon.domain.Coupon;
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
    public static CouponDTO from(Coupon coupon) {
        return new CouponDTO(
                coupon.getId(),
                coupon.getName(),
                coupon.getDescription(),
                coupon.getCouponType(),
                coupon.getCouponStatus(),
                coupon.getDiscountValue(),
                coupon.getMinOrderAmount(),
                coupon.getMaxDiscountAmount(),
                coupon.getTotalQuantity(),
                coupon.getIssuedQuantity(),
                coupon.getValidDays(),
                coupon.getStartDate(),
                coupon.getEndDate()
        );
    }
}
