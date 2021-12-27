package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Purchase;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends BaseRepository<Purchase> {
    @Query("select p from Purchase p where p.customer.id = ?1")
    List<Purchase> findByCustomerId(Long id);
}
