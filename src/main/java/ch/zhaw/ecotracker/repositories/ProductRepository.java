package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    @Query("select p from Product p where p.name = ?1")
    List<Product> findByName(String name);
}
