package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Address;
import ch.zhaw.ecotracker.repositories.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping(value = "address")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        return new ResponseEntity<>(this.addressRepository.save(address), HttpStatus.OK);
    }

    @GetMapping(value = "address/{id}")
    public ResponseEntity<Address> readById(@PathVariable Long id) {
        return this.addressRepository.findById(id)
                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "address/all")
    public ResponseEntity<List<Address>> readAll() {
        return new ResponseEntity<>(this.addressRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "address/street/{street}")
    public ResponseEntity<List<Address>> readByStreet(@PathVariable String street) {
        return new ResponseEntity<>(this.addressRepository.findByStreet(street), HttpStatus.OK);
    }

    @PutMapping(value = "address")
    public ResponseEntity<Address> update(@RequestBody Address newAddress) {
        if (this.addressRepository.existsById(newAddress.getId())) {
            return new ResponseEntity<>(this.addressRepository.save(newAddress), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "address")
    public ResponseEntity<Address> delete(@RequestParam("id") Long id) {
        addressRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling