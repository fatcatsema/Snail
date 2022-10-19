package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.CargoType;
import com.basharin.snail.repository.CargoTypeRepository;

/*
 * Class to test CargoTypeRepository methods.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class CargoTypeRepositoryTests {

	@Autowired
	private CargoTypeRepository cargoTypeRepo;
	
	// test a method findCargoTypeByType()
	@Test
	public void testFindCargoTypeByType() {
		String type = "common";
		CargoType cargoType = cargoTypeRepo.findCargoTypeByType(type);
		assertThat(cargoType).isNotNull();
		System.out.println(cargoType.getRate());
	} // close testFindCargoTypeByType()
	
} // close CargoTypeRepositoryTests class