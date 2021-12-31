package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.repositories.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

public class BaseController<T> {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    protected String entityName = this.getClass().getSimpleName().split("Controller")[0];

    protected BaseRepository<T> baseRepository;

    public BaseController(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        try {
            T createdEntity = this.baseRepository.save(entity);
            this.logger.info("Created " + createdEntity);
            return new ResponseEntity<>(createdEntity, HttpStatus.OK);
        } catch (Exception e) {
            this.logger.severe("Failed to create " + entity);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> readById(@PathVariable Long id) {
        try {
            return this.baseRepository.findById(id)
                    .map(entity -> {
                        this.logger.info("Read " + entity);
                        return new ResponseEntity<>(entity, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        this.logger.warning(this.entityName + " with id [" + id + "] not found");
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    });
        } catch (Exception e) {
            this.logger.severe("Failed to read " + this.entityName + " by id [" + id + "]");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<T>> readAll() {
        try {
            List<T> foundEntities = this.baseRepository.findAll();
            this.logger.info("Read " + foundEntities.size() + " " + this.entityName);
            return new ResponseEntity<>(foundEntities, HttpStatus.OK);
        } catch (Exception e) {
            this.logger.severe("Failed to read any " + entityName);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T entity) {
        try {
            if (this.baseRepository.existsById(id)) {

                T updatedEntity = this.baseRepository.save(entity);
                this.logger.info("Updated " + updatedEntity);
                return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
            } else {
                this.logger.warning(this.entityName + " by id [" + id + "] not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            this.logger.severe("Failed to update " + entity);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<T> delete(@PathVariable Long id) {
        try {
            if (this.baseRepository.existsById(id)) {
                baseRepository.deleteById(id);
                this.logger.info("Deleted " + this.entityName + " with id [" + id + "]");
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                this.logger.warning(this.entityName + " with id [" + id + "] not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            this.logger.severe("Failed to delete " + this.entityName + " by id [" + id + "]");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}