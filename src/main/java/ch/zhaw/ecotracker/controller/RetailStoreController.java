package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.RetailStore;
import ch.zhaw.ecotracker.repositories.RetailStoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RetailStoreController {

    private final RetailStoreRepository retailStoreRepository;

    public RetailStoreController(RetailStoreRepository retailStoreRepository) {
        this.retailStoreRepository = retailStoreRepository;
    }

    @PostMapping(value = "retailStore")
    public ResponseEntity<RetailStore> create(@RequestBody RetailStore retailStore) {
        return new ResponseEntity<>(this.retailStoreRepository.save(retailStore), HttpStatus.OK);
    }

    @GetMapping(value = "retailStore/{id}")
    public ResponseEntity<RetailStore> readById(@PathVariable Long id) {
        return this.retailStoreRepository.findById(id)
                .map(retailStore -> new ResponseEntity<>(retailStore, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "retailStore/all")
    public ResponseEntity<List<RetailStore>> readAll() {
        return new ResponseEntity<>(this.retailStoreRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "retailStore")
    public ResponseEntity<RetailStore> update(@RequestBody RetailStore newRetailStore) {
        if (this.retailStoreRepository.existsById(newRetailStore.getId())) {
            return new ResponseEntity<>(this.retailStoreRepository.save(newRetailStore), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "retailStore")
    public ResponseEntity<RetailStore> delete(@RequestParam("id") Long id) {
        retailStoreRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling