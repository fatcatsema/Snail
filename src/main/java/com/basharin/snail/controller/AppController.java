package com.basharin.snail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.basharin.snail.dto.CustomerDto;
import com.basharin.snail.entity.Customer;
import com.basharin.snail.services.CustomerServices;


@Controller
public class AppController {
	
	
	@Autowired
	private CustomerServices customerService;
	
//	@Autowired
//	private CustomerRepository customerRepository;
	
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
		model.addAttribute("customer", new CustomerDto());
		return "registration";
	}
	
//	@PostMapping("/registration")
//	public String submitForm(@ModelAttribute("customer") Customer customer) {
//	    return "registration_success";
//	}
	
	@GetMapping("/customers")
	public String listUsers(Model model) {
		List<CustomerDto> listCustomers = customerService.findAllCustomers();
		model.addAttribute("listCustomers", listCustomers);
		return "customers";
	}
	
    @PostMapping("/registration/save")
    public String registerCustomer(@Validated @ModelAttribute("customer") CustomerDto customerDto, BindingResult result, Model model){
    	
		Customer existingCustomer = customerService.findCustomerByEmail(customerDto.getEmail());

        if(existingCustomer != null && existingCustomer.getEmail() != null && !existingCustomer.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("customer", customerDto);
            return "registration";
        }
        customerService.saveCustomer(customerDto);
        return "redirect:/registration?success";
    }
}