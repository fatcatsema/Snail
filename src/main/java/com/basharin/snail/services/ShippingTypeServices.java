package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.ShippingType;
import com.basharin.snail.repository.ShippingTypeRepository;

/*
 * Class to hold methods of ShippingType manipulation data.
 */
@Service
public class ShippingTypeServices {
	
	@Autowired
	private ShippingTypeRepository shippingTypeRepository;
	
	// method to retrieve a 'shipping type' object by its type
	public ShippingType findShippingTypeByType(String type) {
		List<ShippingType> shippingTypes = shippingTypeRepository.findAll();
		for (ShippingType shippingType : shippingTypes) {
			if (shippingType.getType().equals(type)) {
				return shippingType;
			}
		}
		return null;
	} // close findShippingTypeByType()
	
} // close ShippingTypeServices class