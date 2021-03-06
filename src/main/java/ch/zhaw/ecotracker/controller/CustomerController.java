package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Customer;
import ch.zhaw.ecotracker.repositories.BaseRepository;
import ch.zhaw.ecotracker.repositories.PersonBaseRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController extends PersonBaseController<Customer> {

    public CustomerController(BaseRepository<Customer> baseRepository, PersonBaseRepository<Customer> personBaseRepository) {
        super(baseRepository, personBaseRepository);
    }
}

