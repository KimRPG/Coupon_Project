package com.example.coupon.repository;

import com.example.coupon.domain.IssuedCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedCouponRepository extends JpaRepository<IssuedCoupon, Long> {
    @Modifying
    @Query("delete from IssuedCoupon ic where ic.coupon.id = :couponId")
    void deleteByCouponId(@Param("couponId") Long couponId);

    boolean existsByCouponIdAndUserId(Long couponId, long userId);
}
