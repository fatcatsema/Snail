package com.basharin.snail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.basharin.snail.entity.CargoType;
import com.basharin.snail.entity.Customer;
import com.basharin.snail.entity.Rate;
import com.basharin.snail.entity.ShippingType;
import com.basharin.snail.repository.CustomerRepository;


@Controller
public class AppController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "home";
	}
	
	@GetMapping("/about")
	public String viewAboutPage() {
		return "about";
	}
	
	@GetMapping("/career")
	public String viewCareerPage() {
		return "career";
	}
	
	@GetMapping("/contacts")
	public String viewContactsPage() {
		return "contacts";
	}
	
	@GetMapping("/login")
	public String viewLoginPage() {
		return "login";
	}
	
	@GetMapping("/tracking")
	public String viewTrackingPage() {
		return "tracking";
	}
	
	@GetMapping("/calculation")
	public String viewCalculationPage() {
		return "calculation";
	}
	
	@GetMapping("/customerservice")
	public String viewCustomerServicePage() {
		return "customerservice";
	}
	
	@GetMapping("/personalpage")
	public String viewPersonalPage() {
		return "personalpage";
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String submitForm(@ModelAttribute("customer") Customer customer) {
	    return "registration_success";
	}
	
//	@PostMapping("/registration")
//	public String processRegister(Customer customer) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(customer.getPassword());
//		customer.setPassword(encodedPassword);
//		customerRepository.save(customer);
//		return "register_success_2";
//	}
}