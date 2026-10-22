package com.example.coupon.config;

import com.example.coupon.domain.Coupon;
import com.example.coupon.domain.domainEnum.*;
import com.example.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Component @Profile("local") @RequiredArgsConstructor
@ConditionalOnProperty(name = "app.seed.enabled", havingValue = "true")
public class LocalDataInitializer implements CommandLineRunner {
    private final CouponRepository coupons;
    @Override @Transactional
    public void run(String... args) {
        seed("선착순 5천원 할인", CouponType.FIXED_AMOUNT, CouponStatus.ACTIVE, 5000, 100, 10000, null, false);
        seed("선착순 10퍼센트 할인", CouponType.PERCENTAGE, CouponStatus.ACTIVE, 10, 50, 10000, 3000, false);
        seed("발급 종료 테스트 쿠폰", CouponType.FIXED_AMOUNT, CouponStatus.EXPIRED, 1000, 10, null, null, true);
    }
    private void seed(String name, CouponType type, CouponStatus status, int discount,
                      int quantity, Integer minimum, Integer maximum, boolean expired) {
        if (coupons.existsByName(name)) return;
        LocalDateTime now = LocalDateTime.now();
        coupons.save(
                Coupon.builder()
                .name(name)
                .description("로컬 개발용 초기 데이터")
                .couponType(type)
                .couponStatus(status)
                .discountValue(discount)
                .totalQuantity(quantity)
                .issuedQuantity(0)
                .minOrderAmount(minimum)
                .maxDiscountAmount(maximum)
                .validDays(30).
                startDate(now.minusDays(1))
                .endDate(expired ? now.minusHours(1) : now.plusYears(1))
                .build()
        );
    }
}
