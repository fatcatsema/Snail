package com.basharin.snail.dto;

import javax.validation.constraints.NotEmpty;

//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.basharin.snail.repository.CargoTypeRepository;
//import com.basharin.snail.repository.RateRepository;
//import com.basharin.snail.repository.ShippingTypeRepository;
//import com.basharin.snail.services.CargoTypeServices;
//import com.basharin.snail.services.RateServices;
//import com.basharin.snail.services.ShippingTypeServices;

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
	
	// constructor to get info about a user's shipment, calculate
	// its price, and temporal store the data about the cargo
	public CargoDto(String from, String to, String cargoType, String shippingType, Double weight) {
		this.from = from;
		this.to = to;
		this.cargoType = cargoType;
		this.shippingType = shippingType;
		this.weight = weight;
	}
} // close CargoDto class