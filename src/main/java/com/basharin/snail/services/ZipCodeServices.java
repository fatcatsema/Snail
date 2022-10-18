package com.basharin.snail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.ZipCode;
import com.basharin.snail.repository.ZipCodeRepository;


@Service
public class ZipCodeServices {
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	public ZipCode findZipCodeByCode(String code) {
		List<ZipCode> zipCodes = zipCodeRepository.findAll();
		for (ZipCode zipCode : zipCodes) {
			if (zipCode.getCode().equals(code)) {
				return zipCode;
			}
		}
		return null;
	}
}