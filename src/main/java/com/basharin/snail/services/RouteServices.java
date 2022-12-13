package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.Route;
import com.basharin.snail.repository.RouteRepository;

/*
 * Class to hold methods of Rate manipulation data.
 */
@Service
public class RouteServices {
	
	@Autowired
	private RouteRepository routeRepository;
	
	// method to retrieve a 'route' object by its code
	public Route findRouteByCode(String code) {
		List<Route> routes = routeRepository.findAll();
		for (Route route : routes) {
			if (route.getCode().equals(code)) {
				return route;
			}
		}
		return null;
	} // close findRateByRoute()
	
	// method to retrieve a 'route' object by its 'stationFrom' and 'stationTo' fields
	public Route findRouteByStationFromAndStationTo(String from, String to) {
		List<Route> routes = routeRepository.findAll();
		for (Route route : routes) {
			if (route.getStationFrom().equals(from) && route.getStationTo().equals(to)) {
				return route;
			}
		}
		return null;
	} // close findRateByStationFromAndStationTo()
	
} // close RateServices class