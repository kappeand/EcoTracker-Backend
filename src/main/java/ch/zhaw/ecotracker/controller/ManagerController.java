package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Manager;
import ch.zhaw.ecotracker.repositories.ManagerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @PostMapping(value = "manager")
    public ResponseEntity<Manager> create(@RequestBody Manager manager) {
        return new ResponseEntity<>(this.managerRepository.save(manager), HttpStatus.OK);
    }

    @GetMapping(value = "manager/{id}")
    public ResponseEntity<Manager> readById(@PathVariable Long id) {
        return this.managerRepository.findById(id)
                .map(manager -> new ResponseEntity<>(manager, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "manager/all")
    public ResponseEntity<List<Manager>> readAll() {
        return new ResponseEntity<>(this.managerRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "manager")
    public ResponseEntity<Manager> update(@RequestBody Manager newManager) {
        if (this.managerRepository.existsById(newManager.getId())) {
            return new ResponseEntity<>(this.managerRepository.save(newManager), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "manager")
    public ResponseEntity<Manager> delete(@RequestParam("id") Long id) {
        managerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling