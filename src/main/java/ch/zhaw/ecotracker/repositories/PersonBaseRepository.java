package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonBaseRepository<T extends Person> extends JpaRepository<T, Long> {
}
