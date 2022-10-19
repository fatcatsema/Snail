package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.Rate;
import com.basharin.snail.repository.RateRepository;

/*
 * Class to test RateRepository methods.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class RateRepositoryTests {
	
	@Autowired
	private RateRepository rateRepo;
	
	// test a method findRateByStationFromAndStationTo()
	@Test
	public void testFindRateByStationFromAndStationTo() {
		String from = "Philadelphia";
		String to = "Pittsburg";
		Rate rate = rateRepo.findRateByStationFromAndStationTo(from, to);
		assertThat(rate).isNotNull();
		System.out.println(rate.getFeePerLb());
	} // close testFindRateByStationFromAndStationTo()
	
} // close RateRepositoryTests class