package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.Rate;
import com.basharin.snail.repository.RateRepository;

/*
 * Class to hold methods of Rate manipulation data.
 */
@Service
public class RateServices {
	
	@Autowired
	private RateRepository rateRepository;
	
	// method to retrieve a 'rate' object by its route code
	public Rate findRateByRoute(String route) {
		List<Rate> rates = rateRepository.findAll();
		for (Rate rate : rates) {
			if (rate.getRoute().equals(route)) {
				return rate;
			}
		}
		return null;
	} // close findRateByRoute()
	
	// method to retrieve a 'rate' object by its 'stationFrom' and 'stationTo' fields
	public Rate findRateByStationFromAndStationTo(String from, String to) {
		List<Rate> rates = rateRepository.findAll();
		for (Rate rate : rates) {
			if (rate.getStationFrom().equals(from) && rate.getStationTo().equals(to)) {
				return rate;
			}
		}
		return null;
	} // close findRateByStationFromAndStationTo()
	
} // close RateServices class