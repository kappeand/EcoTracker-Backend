package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
