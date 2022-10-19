package com.basharin.snail;

import static org.assertj.core.api.Assertions.assertThat;

import com.basharin.snail.repository.ZipCodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.basharin.snail.entity.Customer;
import com.basharin.snail.repository.CustomerRepository;

/*
 * Class to test CustomerRepository methods.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class CustomerRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ZipCodeRepository zipCodeRepo;
	
	// test a method of saving a user into database
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Mikhail");
		customer.setLastName("Basharin");
		customer.setDob("1985-06-21");
		customer.setAddress("213 Lockart Ln");
		customer.setZipCode(zipCodeRepo.findZipCodeByCode("02113"));
		customer.setPhone("484-515-6024");
		customer.setEmail("mishabasharin@gamil.com");
		customer.setPassword("Abc1234567");
		Customer savedCustomer = customerRepo.save(customer);
		Customer existCustomer = entityManager.find(Customer.class, savedCustomer.getId());
		assertThat(customer.getEmail()).isEqualTo(existCustomer.getEmail());
	} // close testCreateCustomer()
	
	// test a method findCustomerByEmail()
	@Test
	public void testFindCustomerByEmail() {
		String email = "mishabasharin@gmail.com";
		Customer customer = customerRepo.findCustomerByEmail(email);
		assertThat(customer).isNotNull();
	} // close testFindCustomerByEmail()
	
} // close CustomerRepositoryTests class