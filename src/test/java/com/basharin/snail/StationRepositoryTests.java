package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.Station;
import com.basharin.snail.repository.StationRepository;

/*
 * Class to test StationRepository methods.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class StationRepositoryTests {

	@Autowired
	private StationRepository stationRepo;
	
	// test a method findStationByName()
	@Test
	public void testFindStationByName() {
		String name = "Philadelphia";
		Station station = stationRepo.findStationByName(name);
		assertThat(station).isNotNull();
		System.out.println(station.getCode());
	} // close testFindStationByName()
	
} // close StationRepositoryTests class