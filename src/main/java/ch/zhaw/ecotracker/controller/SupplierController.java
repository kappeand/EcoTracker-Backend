package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Supplier;
import ch.zhaw.ecotracker.repositories.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @PostMapping(value = "supplier")
    public ResponseEntity<Supplier> create(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(this.supplierRepository.save(supplier), HttpStatus.OK);
    }

    @GetMapping(value = "supplier/{id}")
    public ResponseEntity<Supplier> readById(@PathVariable Long id) {
        return this.supplierRepository.findById(id)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "supplier/all")
    public ResponseEntity<List<Supplier>> readAll() {
        return new ResponseEntity<>(this.supplierRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "supplier")
    public ResponseEntity<Supplier> update(@RequestBody Supplier newSupplier) {
        if (this.supplierRepository.existsById(newSupplier.getId())) {
            return new ResponseEntity<>(this.supplierRepository.save(newSupplier), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "supplier")
    public ResponseEntity<Supplier  > delete(@RequestParam("id") Long id) {
        supplierRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling