package com.basharin.snail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("calculationService")
public class CalculationService {
	
	@Autowired
	public CargoTypeServices cargoTypeService;
	@Autowired
	public ShippingTypeServices shippingTypeService;
	@Autowired
	public StationServices stationService;
	@Autowired
	public RateServices rateService;
	
	public Double calculatePrice(String from, String to, String cargoType, String shippingType, Double weight) {
		
		Double cargoRate = cargoTypeService.findByType(cargoType).getRate().doubleValue();
		Double shippingRate = shippingTypeService.findByType(shippingType).getRate().doubleValue();
		
		String stationFrom = stationService.findByName(from).getCode();
		String stationTo = stationService.findByName(to).getCode();
		String route = stationFrom.concat(stationTo).toUpperCase();
		Double rate = rateService.findByRoute(route).getFeePerLb().doubleValue();
		
		Double price = rate * cargoRate * shippingRate * weight;
		
		return price;
	}
}