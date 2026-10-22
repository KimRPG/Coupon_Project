package com.example.coupon.repository;

import com.example.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
