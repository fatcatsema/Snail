package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.ZipCode;

/*
 * Interface to hold all abstract methods of ZipCode data manipulation.
 */
@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {
	
	public ZipCode findZipCodeByCode(String code);
}