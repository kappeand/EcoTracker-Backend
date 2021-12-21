package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
