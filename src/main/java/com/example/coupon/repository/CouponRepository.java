package com.example.coupon.repository;

import com.example.coupon.domain.Coupon;
import com.example.coupon.domain.domainEnum.CouponStatus;
import com.example.coupon.domain.domainEnum.CouponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByCouponStatusAndEndDateAfter (CouponStatus couponStatus, LocalDateTime now);
    boolean existsByName(String name);
}
