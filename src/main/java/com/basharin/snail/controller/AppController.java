package com.basharin.snail.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.basharin.snail.dto.CargoDto;
import com.basharin.snail.dto.CustomerDto;
import com.basharin.snail.entity.Customer;
import com.basharin.snail.services.CustomerServices;

/*
 * Controller class is responsible for processing incoming
 * REST API requests, preparing a model, and returning the
 * view to be rendered as a response.
 */
@Controller
public class AppController {
	
	@Autowired
	private CustomerServices customerService;
	
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
	public String viewCalculationPage(Model model) {
		model.addAttribute("cargo", new CargoDto());
		return "calculation";
	}
	
	// method to calculate and display shipment price
	@PostMapping("/calculation_process")
	public String displayPrice(@ModelAttribute("cargo") CargoDto cargoDto, Model model) {
		String price = "$   " + cargoDto.getPrice();
//		System.out.println(cargoDto.toString());
		model.addAttribute("price", price);
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
	public String viewRegistrationPage(Model model) {
		model.addAttribute("customer", new CustomerDto());
		return "registration";
	}
	
	// method to register new user
    @PostMapping("/registration/save")
    public String registerCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult result, Model model) {
		Customer existingCustomer = customerService.findCustomerByEmail(customerDto.getEmail());
        if(existingCustomer != null && existingCustomer.getEmail() != null && !existingCustomer.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("customer", customerDto);
            return "registration";
        }
        customerService.saveCustomer(customerDto);
        return "redirect:/login";
    }
} // close AppController class