package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Person;
import ch.zhaw.ecotracker.repositories.BaseRepository;
import ch.zhaw.ecotracker.repositories.PersonBaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class PersonBaseController<T extends Person> extends BaseController<T> {

    protected PersonBaseRepository<T> personBaseRepository;

    public PersonBaseController(BaseRepository<T> baseRepository, PersonBaseRepository<T> personBaseRepository) {
        super(baseRepository);
        this.personBaseRepository = personBaseRepository;
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<T>> readByName(@PathVariable String name) {
        try {
            List<T> readPerson = this.personBaseRepository.findByName(name);
            super.logger.info("Read " + readPerson.size() + " " + super.entityName + " by name [" + name + "]");
            return new ResponseEntity<>(readPerson, HttpStatus.OK);
        } catch (Exception e) {
            super.logger.severe("Failed to read " + super.entityName + " by name [" + name + "]");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
