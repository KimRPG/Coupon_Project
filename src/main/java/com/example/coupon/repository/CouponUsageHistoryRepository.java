package com.example.coupon.repository;

import com.example.coupon.domain.CouponUsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponUsageHistoryRepository extends JpaRepository<CouponUsageHistory, Long> {
    @Modifying
    @Query("delete from CouponUsageHistory h where h.issuedCoupon.id in " +
            "(select ic.id from IssuedCoupon ic where ic.coupon.id = :couponId)")
    void deleteByCouponId(@Param("couponId") Long couponId);
}
