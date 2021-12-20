package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.RetailStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailStoreRepository extends JpaRepository<RetailStore, Long> {
}
