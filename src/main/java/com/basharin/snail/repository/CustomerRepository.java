package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.Customer;

/*
 * Interface to hold all abstract methods of Customer data manipulation.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findCustomerByEmail(String email);
}