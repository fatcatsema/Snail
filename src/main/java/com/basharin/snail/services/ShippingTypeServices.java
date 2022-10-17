package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.ShippingType;
import com.basharin.snail.repository.ShippingTypeRepository;


@Service
public class ShippingTypeServices {
	
	@Autowired
	private ShippingTypeRepository shippingTypeRepository;
	
	public ShippingType findByType(String type) {
		
		List<ShippingType> shippingTypes = shippingTypeRepository.findAll();
		
		for (ShippingType shippingType : shippingTypes) {
			if (shippingType.getType().equals(type)) {
				return shippingType;
			}
		}
		return null;
	}
}