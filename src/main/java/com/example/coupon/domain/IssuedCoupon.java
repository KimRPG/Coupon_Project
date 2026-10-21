package com.example.coupon.domain;

import com.example.coupon.domain.domainEnum.CouponStatus;
import com.example.coupon.domain.domainEnum.IssuedCouponStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class IssuedCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //고민해봐
    @ManyToOne
    private Coupon coupon;

    private long userId;

    private IssuedCouponStatus status;

    private LocalDateTime issuedAt;

    private LocalDateTime expiredAt;

    private LocalDateTime usedAt;
}
