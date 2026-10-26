package com.example.coupon.domain;

import com.example.coupon.domain.domainEnum.CouponStatus;
import com.example.coupon.domain.domainEnum.IssuedCouponStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public static IssuedCoupon issue(Coupon coupon, long userId) {
        IssuedCoupon issuedCoupon = new IssuedCoupon();
        issuedCoupon.coupon = coupon;
        issuedCoupon.userId = userId;
        issuedCoupon.status = IssuedCouponStatus.ISSUED;
        issuedCoupon.issuedAt = LocalDateTime.now();
        issuedCoupon.expiredAt = issuedCoupon.issuedAt.plusDays(coupon.getValidDays());
        return issuedCoupon;
    }
}
