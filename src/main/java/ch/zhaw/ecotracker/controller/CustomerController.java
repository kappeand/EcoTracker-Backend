package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Customer;
import ch.zhaw.ecotracker.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(value = "customer")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return new ResponseEntity<>(this.customerRepository.save(customer), HttpStatus.OK);
    }

    @GetMapping(value = "customer/{id}")
    public ResponseEntity<Customer> readById(@PathVariable Long id) {
        return this.customerRepository.findById(id)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "customer/all")
    public ResponseEntity<List<Customer>> readAll() {
        return new ResponseEntity<>(this.customerRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "customer")
    public ResponseEntity<Customer> update(@RequestBody Customer newCustomer) {
        if (this.customerRepository.existsById(newCustomer.getId())) {
            return new ResponseEntity<>(this.customerRepository.save(newCustomer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "customer")
    public ResponseEntity<Customer> delete(@RequestParam("id") Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling