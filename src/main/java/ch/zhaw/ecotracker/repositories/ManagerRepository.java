package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Manager;

import javax.transaction.Transactional;

@Transactional
public interface ManagerRepository extends PersonBaseRepository<Manager> {
}
