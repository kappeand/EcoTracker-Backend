package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Supplier;
import ch.zhaw.ecotracker.repositories.BaseRepository;
import ch.zhaw.ecotracker.repositories.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController extends BaseController<Supplier> {

    private final SupplierRepository supplierRepository;

    public SupplierController(BaseRepository<Supplier> baseRepository, SupplierRepository supplierRepository) {
        super(baseRepository);
        this.supplierRepository = supplierRepository;
    }

    @GetMapping(value = "/streetAndHouseNumber/{street}/{houseNumber}")
    public ResponseEntity<Supplier> readByStreetAndHouseNumber(@PathVariable String street, @PathVariable String houseNumber) {
        try {
            Supplier readSupplier = this.supplierRepository.findByStreetAndHouseNumber(street, houseNumber);
            super.logger.info("Read " + readSupplier + " by street [" + street + "] and houseNumber [" + houseNumber + "]");
            return new ResponseEntity<>(readSupplier, HttpStatus.OK);
        } catch (Exception e) {
            super.logger.severe("Failed to read suppliers by street [" + street + "] and houseNumber [" + houseNumber + "]");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
