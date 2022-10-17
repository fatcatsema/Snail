package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.CargoType;


@Repository
public interface CargoTypeRepository extends JpaRepository<CargoType, Long> {

	public CargoType findByType(String type);
}