package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}