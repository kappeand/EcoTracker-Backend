package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Person;
import ch.zhaw.ecotracker.repositories.PersonBaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PersonBaseController<T extends Person> {

    protected PersonBaseRepository<T> personBaseRepository;

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T person) {
        return new ResponseEntity<>(this.personBaseRepository.save(person), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<T> readById(@PathVariable Long id) {
        return this.personBaseRepository.findById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<T>> readAll() {
        return new ResponseEntity<>(this.personBaseRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T newPerson) {
        if (this.personBaseRepository.existsById(newPerson.getId())) {
            return new ResponseEntity<>(this.personBaseRepository.save(newPerson), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<T> delete(@RequestParam("id") Long id) {
        personBaseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//Todo: exception handling