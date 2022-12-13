package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.Route;
import com.basharin.snail.repository.RouteRepository;

/*
 * Class to test RateRepository methods.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class RateRepositoryTests {
	
	@Autowired
	private RouteRepository rateRepo;
	
	// test a method findRateByStationFromAndStationTo()
	@Test
	public void testFindRateByStationFromAndStationTo() {
		String from = "Albany";
		String to = "Baltimore";
		Route route = rateRepo.findRouteByStationFromAndStationTo(from, to);
		assertThat(route).isNotNull();
		System.out.println(route.getFeePerLb());
	} // close testFindRateByStationFromAndStationTo()
	
} // close RateRepositoryTests class