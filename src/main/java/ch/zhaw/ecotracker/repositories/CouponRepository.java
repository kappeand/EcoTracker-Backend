package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Coupon;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepository extends BaseRepository<Coupon> {
    @Query("select c from Coupon c where c.customer.id = ?1")
    List<Coupon> findByCustomerId(Long id);
}
