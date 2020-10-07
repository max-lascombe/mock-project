package userInterface;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	
	@GetMapping("/address")
	public String showForm(Model model) {
		Address address = new Address();
		model.addAttribute("address", address);
		
		return "Address_Form";
	}
		
	/*
	@PostMapping("/address")
	public String submitForm(@ModelAttribute("address") Address address) {
		return "AddressConfirmation";
	} 
	 */
	
	@PostMapping("/address")
	public String submitForm(@ModelAttribute("address") Address address) {
		
		return "AddressConfirmation";
	} 
	
	
	@GetMapping("/addressConfirmation")
	public String confirmAddress() {
		return "AddressConfirmation";
	}
	
	@GetMapping("/menu")
	public String showMenu() {
		return "Menu";
	}
	
	@GetMapping("/orderConfirmation")
	public String confirmOrder() {
		return "OrderConfirmation";
	}
	
		}

