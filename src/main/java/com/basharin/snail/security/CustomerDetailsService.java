package com.basharin.snail.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.basharin.snail.entity.Customer;
import com.basharin.snail.services.CustomerServices;

/*
 * Class to load a user from database
 */
@Service
public class CustomerDetailsService implements UserDetailsService {
    
    @Autowired
    private CustomerServices customerService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerService.findCustomerByEmail(email);
        if (customer != null){
            return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(),  getAuthorities());
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    } // close loadUserByUsername()
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    } // close getAuthorities()
    
} // close CustomerDetailsService class