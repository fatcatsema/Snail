package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.Cargo;

/*
 * Interface to hold all abstract methods of Cargo data manipulation.
 */
@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
}