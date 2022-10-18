package com.basharin.snail.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.Customer;
import com.basharin.snail.services.CustomerServices;


@Service
public class CustomerDetailsService implements UserDetailsService {

//    private CustomerRepository customerRepository;
	
//  public CustomerDetailsService(CustomerRepository customerRepository) {
//  this.customerRepository = customerRepository;
//}
    
    @Autowired
    private CustomerServices customerService;
    
	public CustomerDetailsService(CustomerServices customerService) {
		this.customerService = customerService;
	}

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Customer customer = customerService.findCustomerByEmail(usernameOrEmail);
        if (customer != null){
            return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(), null);
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}