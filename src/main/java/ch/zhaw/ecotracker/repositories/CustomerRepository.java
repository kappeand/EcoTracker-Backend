package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
