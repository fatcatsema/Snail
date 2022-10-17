package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.Customer;
import com.basharin.snail.repository.CustomerRepository;
import com.basharin.snail.repository.ZipCodeRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ZipCodeRepository zipCodeRepo;
	
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setFirstName("Mikhail");
		customer.setLastName("Basharin");
		customer.setDob("1985-06-21");
		customer.setAddress("213 Lockart Ln");
		customer.setZipCode(zipCodeRepo.findByCode("02113"));
		customer.setPhone("484-515-6024");
		customer.setEmail("mishabasharin@gamil.com");
//		customer.setPassword("Laverda2015$");
		
		Customer savedUser = customerRepo.save(customer);
		Customer existUser = entityManager.find(Customer.class, savedUser.getId());
		
		assertThat(customer.getEmail()).isEqualTo(existUser.getEmail());
	}
}