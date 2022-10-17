package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.CargoType;
import com.basharin.snail.repository.CargoTypeRepository;


@Service
public class CargoTypeServices {
	
	@Autowired
	private CargoTypeRepository cargoTypeRepository;
	
	public CargoType findByType(String type) {
		List<CargoType> cargoTypes = cargoTypeRepository.findAll();
		for (CargoType cargoType : cargoTypes) {
			if (cargoType.getType().equals(type)) {
				return cargoType;
			}
		}
		return null;
	}
}