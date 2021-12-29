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

    @GetMapping(value = "/streetandhousenumber/{street}/{housenumber}")
    public ResponseEntity<Supplier> readByStreetAndHouseNumber(@PathVariable String street, @PathVariable String housenumber) {
        return new ResponseEntity<>(this.supplierRepository.findByStreetAndHouseNumber(street, housenumber), HttpStatus.OK);
    }
}
