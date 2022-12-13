package com.basharin.snail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basharin.snail.entity.Route;

/*
 * Interface to hold all abstract methods of Rate data manipulation.
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
	
	public Route findRouteByCode(String code);
	public Route findRouteByStationFromAndStationTo(String from, String to);
}