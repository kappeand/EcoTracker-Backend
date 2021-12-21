package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Coupon;
import ch.zhaw.ecotracker.repositories.CouponRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponController {

    private final CouponRepository couponRepository;

    public CouponController(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @PostMapping(value = "coupon")
    public ResponseEntity<Coupon> create(@RequestBody Coupon coupon) {
        return new ResponseEntity<>(this.couponRepository.save(coupon), HttpStatus.OK);
    }

    @GetMapping(value = "coupon/{id}")
    public ResponseEntity<Coupon> readById(@PathVariable Long id) {
        return this.couponRepository.findById(id)
                .map(coupon -> new ResponseEntity<>(coupon, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "coupon/all")
    public ResponseEntity<List<Coupon>> readAll() {
        return new ResponseEntity<>(this.couponRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "coupon")
    public ResponseEntity<Coupon> update(@RequestBody Coupon newCoupon) {
        if (this.couponRepository.existsById(newCoupon.getId())) {
            return new ResponseEntity<>(this.couponRepository.save(newCoupon), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "coupon")
    public ResponseEntity<Coupon> delete(@RequestParam("id") Long id) {
        couponRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling