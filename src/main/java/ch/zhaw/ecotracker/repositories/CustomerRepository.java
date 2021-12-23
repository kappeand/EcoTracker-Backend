package ch.zhaw.ecotracker.repositories;

import ch.zhaw.ecotracker.entities.Customer;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends PersonBaseRepository<Customer> {
}
