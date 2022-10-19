package com.basharin.snail.dto;

import javax.validation.constraints.NotEmpty;

import com.basharin.snail.services.CargoTypeServices;
import com.basharin.snail.services.RateServices;
import com.basharin.snail.services.ShippingTypeServices;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/*
 * Class to generate and temporal store information
 * about a cargo requested by a user.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class CargoDto {
	
	@NotEmpty
	String from;
	@NotEmpty
	String to;
	@NotEmpty
	Double weight;
	@NotEmpty
	String cargoType;
	@NotEmpty
	String shippingType;
	Double price;
	
	RateServices rateService;
	CargoTypeServices cargoTypeService;
	ShippingTypeServices shippingTypeService;
	
	// constructor to get info about a user's shipment, calculate
	// its price, and temporal store the data about the cargo
	public CargoDto(String from, String to, String cargoType, String shippingType, Double weight) {
		this.from = from;
		this.to = to;
		this.cargoType = cargoType;
		this.shippingType = shippingType;
		this.weight = weight;
		this.price = calculatePrice(from, to, cargoType, shippingType, weight);
	}
	
	// method to calculate price of a shipment
	private Double calculatePrice(String from, String to, String cargoType, String shippingType, Double weight) {
		Double rate = rateService.findRateByStationFromAndStationTo(from, to).getFeePerLb();
		Double cargoRate = cargoTypeService.findCargoTypeByType(cargoType).getRate();
		Double shippingRate = shippingTypeService.findShippingTypeByType(shippingType).getRate();
		return rate * cargoRate * shippingRate * weight;
	} // close calculatePrice()

	@Override
	public String toString() {
		return "CargoDto [from=" + from + ", to=" + to + ", weight=" + weight + ", cargoType=" + cargoType
				+ ", shippingType=" + shippingType + ", price=" + price + "]";
	}
} // close CargoDto class