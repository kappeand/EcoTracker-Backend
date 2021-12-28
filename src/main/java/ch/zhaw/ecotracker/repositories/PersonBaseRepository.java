package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface PersonBaseRepository<T extends Person> extends BaseRepository<T> {

    @Query("select p from #{#entityName} p where p.name = ?1")
    List<T> findByName(String name);
}
