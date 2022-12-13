package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.basharin.snail.repository.CargoTypeRepository;
import com.basharin.snail.repository.RouteRepository;
import com.basharin.snail.repository.ShippingTypeRepository;


@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class CalculationPriceTest {
	
	@Autowired
	private RouteRepository rateRepo;
	@Autowired
	private CargoTypeRepository cargoTypeRepo;
	@Autowired
	private ShippingTypeRepository shippingTypeRepo;
	
	@Test
	public void testCalculateShipmentPrice() {
		
		// given
		String stationFrom = "Philadelphia";
		String stationTo = "Pittsburg";
		String cargoType = "Common";
		String shippingType = "Regular";
		Double weight = 2.0;
		
		// when
		Double rate = rateRepo.findRouteByStationFromAndStationTo(stationFrom, stationTo).getFeePerLb();
		Double cargoRate = cargoTypeRepo.findCargoTypeByType(cargoType).getRate();
		Double shippingRate = shippingTypeRepo.findShippingTypeByType(shippingType).getRate();
		Double price = rate * cargoRate * shippingRate * weight;
		
		System.out.println("Rate: " + rate + " Cargo Rate: " + cargoRate + " Shipping Rate: " + shippingRate + " Weight: " + weight);
		System.out.println("Price: " + price);
		
		// then
		assertThat(price).isNotNull();
	}
}