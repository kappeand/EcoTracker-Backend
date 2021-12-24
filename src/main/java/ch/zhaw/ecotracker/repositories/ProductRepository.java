package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name = ?1")
    Product findByName(String name);
}
