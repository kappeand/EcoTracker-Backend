package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
