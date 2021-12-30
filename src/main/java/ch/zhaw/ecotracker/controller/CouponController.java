package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Coupon;
import ch.zhaw.ecotracker.repositories.BaseRepository;
import ch.zhaw.ecotracker.repositories.CouponRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/coupon")
public class CouponController extends BaseController<Coupon> {

    private final CouponRepository couponRepository;

    public CouponController(BaseRepository<Coupon> baseRepository, CouponRepository couponRepository) {
        super(baseRepository);
        this.couponRepository = couponRepository;
    }

    @GetMapping(value = "/customerId/{customerId}")
    public ResponseEntity<List<Coupon>> readByCustomerId(@PathVariable Long customerId) {
        return new ResponseEntity<>(this.couponRepository.findByCustomerId(customerId), HttpStatus.OK);
    }
}
