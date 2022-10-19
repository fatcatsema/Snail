package com.basharin.snail.services;

import org.springframework.stereotype.Service;


@Service
public class CargoServices {
	
//	@Autowired
//	private RateServices rateService;
//	@Autowired
//	private CargoTypeServices cargoTypeService;
//	@Autowired
//	private ShippingTypeServices shippingTypeService;
//	@Autowired
//	private CargoTypeRepository cargoTypeRepo;
//	@Autowired
//	private RateRepository rateRepo;
	
//	public Double calculatePrice(String from, String to, String cargoType, String shippingType, Double weight) {
//		Double rate = .findRateByStationFromAndStationTo(from, to).getFeePerLb();
//		Double cargoRate = cargoTypeRepo.findCargoTypeByType(cargoType).getRate();
//		Double shippingRate = shippingTypeService.findShippingTypeByType(shippingType).getRate();
//		Double price = rate * cargoRate * shippingRate * weight;
//		System.out.println(price);
//		return price;
//	}
}