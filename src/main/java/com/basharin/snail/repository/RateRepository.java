package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.Rate;

/*
 * Interface to hold all abstract methods of Rate data manipulation.
 */
@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
	
	public Rate findRateByRoute(String route);
	public Rate findRateByStationFromAndStationTo(String from, String to);
}