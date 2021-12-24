package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("select a from Address a where a.street = ?1")
    Address findByStreet(String street);
}
