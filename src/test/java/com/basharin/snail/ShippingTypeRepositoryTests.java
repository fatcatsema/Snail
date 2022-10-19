package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.ShippingType;
import com.basharin.snail.repository.ShippingTypeRepository;

/*
 * Class to test ShippingTypeRepository methods.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class ShippingTypeRepositoryTests {
	
	@Autowired
	private ShippingTypeRepository shippingTypeRepo;
	
	// test a method findShippingTypeByType()
	@Test
	public void testFindShippingTypeByType() {
		String type = "express";
		ShippingType shippingType = shippingTypeRepo.findShippingTypeByType(type);
		assertThat(shippingType).isNotNull();
		System.out.println(shippingType.getRate());
	} // close testFindShippingTypeByType()
	
} // close ShippingTypeRepositoryTests class