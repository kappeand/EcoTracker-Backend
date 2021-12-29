package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.repositories.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<T> {
    protected BaseRepository<T> baseRepository;

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        return new ResponseEntity<>(this.baseRepository.save(entity), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> readById(@PathVariable Long id) {
        return this.baseRepository.findById(id)
                .map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<T>> readAll() {
        return new ResponseEntity<>(this.baseRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody Long id, T newEntity) {
        if (this.baseRepository.existsById(id)) {
            return new ResponseEntity<>(this.baseRepository.save(newEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<T> delete(@RequestParam("id") Long id) {
        baseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
