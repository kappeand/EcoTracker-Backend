package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Purchase;
import ch.zhaw.ecotracker.repositories.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping(value = "purchase")
    public ResponseEntity<Purchase> create(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(this.purchaseRepository.save(purchase), HttpStatus.OK);
    }

    @GetMapping(value = "purchase/{id}")
    public ResponseEntity<Purchase> readById(@PathVariable Long id) {
        return this.purchaseRepository.findById(id)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "purchase/all")
    public ResponseEntity<List<Purchase>> readAll() {
        return new ResponseEntity<>(this.purchaseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "purchase/{customerId}")
    public ResponseEntity<List<Purchase>> readByCustomerId(@PathVariable Long customerId) {
        return new ResponseEntity<>(this.purchaseRepository.findByCustomerId(customerId), HttpStatus.OK);
    }

    @PutMapping(value = "purchase")
    public ResponseEntity<Purchase> update(@RequestBody Purchase newPurchase) {
        if (this.purchaseRepository.existsById(newPurchase.getId())) {
            return new ResponseEntity<>(this.purchaseRepository.save(newPurchase), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "purchase")
    public ResponseEntity<Purchase> delete(@RequestParam("id") Long id) {
        purchaseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling