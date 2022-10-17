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
import com.basharin.snail.services.ZipCodeServices;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ZipCodeServices zipCodeService;
	
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setFirstName("Mikhail");
		customer.setLastName("Basharin");
		customer.setDob("1985-06-21");
		customer.setAddress("213 Lockart Ln");
		customer.setZipCode(zipCodeService.findByCode("02113"));
//		customer.setZipCode("19116");
		customer.setPhone("484-515-6024");
		customer.setEmail("mishabasharin@gamil.com");
		customer.setPassword("Abc1234567");
		
		Customer savedCustomer = customerRepo.save(customer);
		Customer existCustomer = entityManager.find(Customer.class, savedCustomer.getId());
		
		assertThat(customer.getEmail()).isEqualTo(existCustomer.getEmail());
	}
}