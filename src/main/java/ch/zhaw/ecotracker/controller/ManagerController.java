package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Manager;
import ch.zhaw.ecotracker.repositories.PersonBaseRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController extends PersonBaseController<Manager> {

    public ManagerController(PersonBaseRepository<Manager> personBaseRepository) {
        super.personBaseRepository = personBaseRepository;
    }
}

//Todo: exception handling