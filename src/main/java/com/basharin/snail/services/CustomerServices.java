package com.basharin.snail.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.basharin.snail.dto.CustomerDto;
import com.basharin.snail.entity.Customer;
import com.basharin.snail.repository.CustomerRepository;


@Service
public class CustomerServices {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ZipCodeServices zipCodeService;
	private PasswordEncoder passwordEncoder;

	public Customer findCustomerByEmail(String email) {
		List<Customer> customers = customerRepository.findAll();
		for (Customer customer : customers) {
			if (customer.getEmail().equals(email)) {
				return customer;
			}
		}
		return null;
	}
	
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setDob(customerDto.getDob());
        customer.setAddress(customerDto.getDob());
        customer.setZipCode(zipCodeService.findZipCodeByCode(customerDto.getZipCode()));
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        // encrypt the password using spring security
        customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        customerRepository.save(customer);
    }
    
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map((customer) -> mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }
    
    private CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }
}