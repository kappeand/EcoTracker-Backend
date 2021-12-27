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
        super.baseRepository = baseRepository;
        this.personBaseRepository = personBaseRepository;
    }

    public PersonBaseController() {
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<T>> readByName(@PathVariable String name) {
        return new ResponseEntity<>(this.personBaseRepository.findPersonByName(name), HttpStatus.OK);
    }
}
