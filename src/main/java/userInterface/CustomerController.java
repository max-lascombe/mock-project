package userInterface;

import java.awt.PageAttributes.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CustomerController {
	
	@GetMapping("/address")
	public String showForm(Model model) {
		Address address = new Address();
		model.addAttribute("address", address);
		
		return "Address_Form";
	}
	
	@PostMapping("/address")
	public String submitForm(@ModelAttribute("address") Address address) {
		
		return "AddressConfirmation";
	} 
	
	
	@GetMapping("/addressConfirmation")
	public String confirmAddress() {
		return "AddressConfirmation";
	}
	

	@PostMapping("/addressConfirmation")
	private String postAddress(@ModelAttribute("address") Address address)
	{
	    final String uri = "https://anypoint.mulesoft.com/exchange/8eaaedc4-7e9e-4a3c-a9a9-b2ed01022f30/orders/";
	    RestTemplate restTemplate = new RestTemplate();
	     	     
	    restTemplate.postForObject( uri, address, Address.class);
	    return ("/menu");

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

