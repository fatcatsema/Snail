package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.Rate;
import com.basharin.snail.repository.RateRepository;


@Service
public class RateServices {
	
	@Autowired
	public RateRepository rateRepository;
	
	public Rate findByRoute(String route) {
		List<Rate> rates = rateRepository.findAll();
		for (Rate rate : rates) {
			if (rate.getRoute().equals(route)) {
				return rate;
			}
		}
		return null;
	}
}