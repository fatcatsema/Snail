//package com.basharin.snail;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.basharin.snail.dto.CargoDto;
//
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class CargoDtoTest {
//	
//	@Test
//	public void testCreateCargoDtoObject() {
//		
//		// given
//		String stationFrom = "Philadelphia";
//		String stationTo = "Pittsburg";
//		String cargoType = "Common";
//		String shippingType = "Regular";
//		Double weight = 2.0;
//		
//		// when
//		CargoDto cargo = new CargoDto(stationFrom, stationTo, cargoType, shippingType, weight);
//		
//		// then
////		assertThat(cargo.getPrice()).isNotNull();
////		System.out.println("Station From: " + cargo.getFrom());
////		System.out.println("Station To: " + cargo.getTo());
////		System.out.println("Cargo Type: " + cargo.getCargoType());
////		System.out.println("Shipping Type: " + cargo.getShippingType());
////		System.out.println("Weight: " + cargo.getWeight());
////		System.out.println("Price: " + cargo.getPrice());
//	}
//}