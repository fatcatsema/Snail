package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.CargoType;
import com.basharin.snail.repository.CargoTypeRepository;

/*
 * Class to hold methods of CargoType manipulation data.
 */
@Service
public class CargoTypeServices {
	
	@Autowired
	private CargoTypeRepository cargoTypeRepository;
	
	// method to retrieve a 'cargo type' object by its type
	public CargoType findCargoTypeByType(String type) {
		List<CargoType> cargoTypes = cargoTypeRepository.findAll();
		for (CargoType cargoType : cargoTypes) {
			if (cargoType.getType().equals(type)) {
				return cargoType;
			}
		}
		return null;
	}// close findCargoTypeByType()
	
} // close CargoTypeServices class