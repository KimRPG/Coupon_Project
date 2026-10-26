package com.example.coupon.repository;

import com.example.coupon.domain.Coupon;
import com.example.coupon.domain.domainEnum.CouponStatus;
import com.example.coupon.domain.domainEnum.CouponType;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByCouponStatusAndEndDateAfter (CouponStatus couponStatus, LocalDateTime now);
    boolean existsByName(String name);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Coupon> findWithLockById(Long id);
}
