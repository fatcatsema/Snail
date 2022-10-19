package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.ZipCode;
import com.basharin.snail.repository.ZipCodeRepository;

/*
 * Class to test ZipCodeRepository methods.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class ZipCodeRepositoryTests {
	
	@Autowired
	private ZipCodeRepository zipCodeRepo;
	
	// test a method findZipCodeByCode()
	@Test
	public void testFindZipCodeByCode() {
		String code = "02113";
		ZipCode zipCode = zipCodeRepo.findZipCodeByCode(code);
		assertThat(zipCode).isNotNull();
	} // close testFindZipCodeByCode()
	
} // close ZipCodeRepositoryTests class