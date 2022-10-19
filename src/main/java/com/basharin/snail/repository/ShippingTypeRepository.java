package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.ShippingType;

/*
 * Interface to hold all abstract methods of ShippingType data manipulation.
 */
@Repository
public interface ShippingTypeRepository extends JpaRepository<ShippingType, Long> {
	
	public ShippingType findShippingTypeByType(String type);
}