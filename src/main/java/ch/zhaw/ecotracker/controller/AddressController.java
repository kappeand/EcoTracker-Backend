package ch.zhaw.ecotracker.controller;

import ch.zhaw.ecotracker.entities.Address;
import ch.zhaw.ecotracker.repositories.AddressRepository;
import ch.zhaw.ecotracker.repositories.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController extends BaseController<Address> {
    private final AddressRepository addressRepository;

    public AddressController(BaseRepository<Address> baseRepository, AddressRepository addressRepository) {
        super(baseRepository);
        this.addressRepository = addressRepository;
    }

    @GetMapping(value = "/street/{street}")
    public ResponseEntity<List<Address>> readByStreet(@PathVariable String street) {
        return new ResponseEntity<>(this.addressRepository.findByStreet(street), HttpStatus.OK);
    }
}