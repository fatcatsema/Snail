package com.basharin.snail.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.basharin.snail.dto.CustomerDto;
import com.basharin.snail.entity.Customer;
import com.basharin.snail.repository.CustomerRepository;

/*
 * Class to hold methods of Customer manipulation data.
 */
@Service
public class CustomerServices {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ZipCodeServices zipCodeService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// method to retrieve a 'customer' object by its email
	public Customer findCustomerByEmail(String email) {
		List<Customer> customers = customerRepository.findAll();
		for (Customer customer : customers) {
			if (customer.getEmail().equals(email)) {
				return customer;
			}
		}
		return null;
	} // close findCustomerByEmail()
	
	// method to save new user into database
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setDob(customerDto.getDob());
        customer.setAddress(customerDto.getAddress());
        customer.setZipCode(zipCodeService.findZipCodeByCode(customerDto.getZipCode()));
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        customerRepository.save(customer);
    } // close saveCustomer()
    
} // close CustomerServices class