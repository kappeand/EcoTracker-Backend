package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
