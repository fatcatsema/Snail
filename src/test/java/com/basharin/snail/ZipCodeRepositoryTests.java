package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.ZipCode;
import com.basharin.snail.repository.ZipCodeRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ZipCodeRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ZipCodeRepository zipCodeRepo;
	
	@Test
	public void testCreateZipCode() {
		
		ZipCode zipCode = new ZipCode();
		zipCode.setCode("02113");
		zipCode.setCity("Boston");
		zipCode.setState("Massachusetts");
		
		ZipCode savedUser = zipCodeRepo.save(zipCode);
		ZipCode existUser = entityManager.find(ZipCode.class, savedUser.getId());
		
		assertThat(zipCode.getCode()).isEqualTo(existUser.getCode());
	}
}