package userInterface;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
	    String uri = "https://anypoint.mulesoft.com/exchange/8eaaedc4-7e9e-4a3c-a9a9-b2ed01022f30/orders/";
	    RestTemplate restTemplate = new RestTemplate();
	     	     
	    restTemplate.postForObject( uri, address, Address.class);
	    
	    //return "Menu";
	    return "Menu";

	}
	
	
	@GetMapping("/menu")
	private void showMenu()
	{
	    final String uri = "http://menu.us-e2.cloudhub.io/menu";

	    RestTemplate restTemplate = new RestTemplate();
	 
	    String result = restTemplate.getForObject(uri, String.class);
	    
	    Gson gson = new Gson();
	    
	    System.out.println(result);
	 
	    
	    MenuSchema menuschema = gson.fromJson(result, MenuSchema.class);
	    
	    
	    System.out.println(menuschema);

	}

	
	@GetMapping("/orderConfirmation")
	public String confirmOrder() {
		return "OrderConfirmation";
	}
	
}

