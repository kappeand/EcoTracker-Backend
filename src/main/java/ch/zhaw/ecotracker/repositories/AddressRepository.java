package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Address;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends BaseRepository<Address> {
    @Query("select a from Address a where a.street = ?1")
    List<Address> findByStreet(String street);
}
