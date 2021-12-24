package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("select s from Supplier s where s.address.street = ?1 and s.address.houseNumber = ?2")
    Supplier findByStreetAndHouseNumber(String street, String houseNumber);
}
