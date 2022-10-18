package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.ZipCode;


@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {
	
	public ZipCode findZipCodeByCode(String code);
}