package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Purchase;
import ch.zhaw.ecotracker.repositories.BaseRepository;
import ch.zhaw.ecotracker.repositories.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController extends BaseController<Purchase> {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(BaseRepository<Purchase> baseRepository, PurchaseRepository purchaseRepository) {
        super(baseRepository);
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<List<Purchase>> readByCustomerId(@PathVariable Long customerId) {
        return new ResponseEntity<>(this.purchaseRepository.findByCustomerId(customerId), HttpStatus.OK);
    }
}
