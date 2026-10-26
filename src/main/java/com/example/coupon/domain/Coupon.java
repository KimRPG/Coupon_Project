package com.example.coupon.domain;

import com.example.coupon.domain.domainEnum.CouponType;
import com.example.coupon.domain.domainEnum.CouponStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(name = "coupone_name")
    private String name;

    private String description;

    private CouponType couponType;

    private CouponStatus couponStatus;

    private int discountValue;

    private Integer minOrderAmount;

    private Integer maxDiscountAmount;

    private int totalQuantity;

    private int issuedQuantity;

    private int validDays;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public void resetIssuedQuantity() {
        this.issuedQuantity = 0;
    }

    public void issue() {
        LocalDateTime now = LocalDateTime.now();
        if (couponStatus != CouponStatus.ACTIVE || now.isBefore(startDate) || now.isAfter(endDate)) {
            throw new IllegalStateException("발급 가능한 쿠폰이 아닙니다.");
        }
        if (issuedQuantity >= totalQuantity) {
            throw new IllegalStateException("쿠폰 재고가 없습니다.");
        }
        this.issuedQuantity++;
    }
}
