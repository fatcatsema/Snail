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
import com.basharin.snail.services.CargoTypeServices;
import com.basharin.snail.services.CustomerServices;
import com.basharin.snail.services.RouteServices;
import com.basharin.snail.services.ShippingTypeServices;

/*
 * Controller class is responsible for processing incoming
 * REST API requests, preparing a model, and returning the
 * view to be rendered as a response.
 */
@Controller
public class AppController {
	
	@Autowired
	private CustomerServices customerService;
	@Autowired
	private RouteServices routeService;
	@Autowired
	private CargoTypeServices cargoTypeService;
	@Autowired
	private ShippingTypeServices shippingTypeService;
	
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
		CargoDto cargoDto = new CargoDto();
		model.addAttribute("cargo", cargoDto);
		return "calculation";
	}
	
	// method to calculate and display shipment price
	@PostMapping("/calculation_process")
	public String displayPrice(@ModelAttribute("cargo") CargoDto cargoDto, Model model) {
		// calculate the price
		Double rate = routeService.findRouteByStationFromAndStationTo(cargoDto.getFrom(), cargoDto.getTo()).getFeePerLb();
		Double cargoRate = cargoTypeService.findCargoTypeByType(cargoDto.getCargoType()).getRate();
		Double shippingRate = shippingTypeService.findShippingTypeByType(cargoDto.getShippingType()).getRate();
		Double weight = cargoDto.getWeight();
		Double price = rate * cargoRate * shippingRate * weight;
		String priceOutput = "$   " + price;
		model.addAttribute("price", priceOutput);
		// calculate the delivery time
		Integer time = 0;
		Integer standardTime = routeService.findRouteByStationFromAndStationTo(cargoDto.getFrom(), cargoDto.getTo()).getDeliveryTime();
		String shipmentType = cargoDto.getShippingType();
		if (shipmentType.equals("Express")) {
			if (standardTime > 1) {
				time = (int) (standardTime * 0.7);
			} else {
				time = standardTime;
			}
		} else {
			time = standardTime;
		}
		String timeString = time + " days";
		model.addAttribute("time", timeString);
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
            result.rejectValue("email", null, "There is already an account registered with the same email.");
        }
        if(result.hasErrors()){
            model.addAttribute("customer", customerDto);
            return "registration";
        }
        customerService.saveCustomer(customerDto);
        return "redirect:/login";
    }
} // close AppController class