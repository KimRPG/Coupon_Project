package com.example.coupon.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class CouponUsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private IssuedCoupon issuedCoupon;

    private long userId;

    private long orderId;

    private Integer discountAmount;

    private LocalDateTime usedAt;
}
