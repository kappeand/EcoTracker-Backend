package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
