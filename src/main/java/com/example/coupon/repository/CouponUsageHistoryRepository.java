package com.example.coupon.repository;

import com.example.coupon.domain.CouponUsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponUsageHistoryRepository extends JpaRepository<CouponUsageHistory, Long> {
}
