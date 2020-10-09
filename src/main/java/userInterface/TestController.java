package userInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
class TestController {
	
	private HashMap<Integer, String> idmap = new HashMap<Integer, String>();

   public TestController() {
	   // dummy data here
	   idmap.put(1, "Picked Up");
	   idmap.put(2, "Almost There");
	   idmap.put(3, "I'm Here");
   }

	/*
	 * @GetMapping("/driver") public String index(Model model) { return "index"; }
	 */
   
   @RequestMapping(value = "/checkForOrders", method = RequestMethod.GET,
   produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public OrderResponse checkForOrders () {
       HttpHeaders headers = new HttpHeaders();
       headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
       
       RestTemplate restTemplate = new RestTemplate();
       
		/*
		 * ResponseEntity<String> entity = restTemplate.exchange(
		 * "http://delivery-service-api.us-e2.cloudhub.io/getAvailableOrders",
		 * HttpMethod.GET, new HttpEntity<Object>(headers), String.class);
		 */
       
//       OrderWrapper response = restTemplate.getForObject(
//    		   "http://delivery-service-api.us-e2.cloudhub.io/getAvailableOrders2",
//    		   OrderWrapper.class);
//    	List<Order> orders = response.getOrders();
//
//
//       System.out.println(orders.size());
	   //Order[] orders = entity.getBody();
	  // System.out.println(entity.getStatusCode());
       

	  // ResponseEntity<Order[]> responseEntity = restTemplate.getForEntity("http://delivery-service-api.us-e2.cloudhub.io/getAvailableOrders", Order[].class);
	  // Order[] orders = responseEntity.getBody();
	  // System.out.println(orders[0].getDeliveryInfo());
	   //Order[] result = restTemplate.getForObject("http://delivery-service-api.us-e2.cloudhub.io/getAvailableOrders", Order[].class);
	   //Order[] result = restTemplate.getForObject("http://delivery-service-api.us-e2.cloudhub.io/getAvailableOrders", Order[].class);
	   String resp = restTemplate.getForObject("http://delivery-service-api.us-e2.cloudhub.io/getAvailableOrders", String.class);
	   //OrderWrapper orderWrapper;
		System.out.println(resp);
		boolean b = resp.contains("\"Status\": \"available\"");
	    //OrderResponse or = new OrderResponse(false, orders[0]);
	    return new OrderResponse(b, resp);
   }
   
   @RequestMapping("/driver")
   public String getDriverScreen () {
	   return "driver_screen";
   }

   @RequestMapping(value = "/driverupdate", method = RequestMethod.POST)
   @ResponseBody
   public boolean handleEmployeeRequestByArea (@RequestParam(required = false) String orderId, @RequestParam(required = false) Integer id, @RequestParam(required = false) String eta, Model map) {
	   if(orderId != null && id != null) {
		   RestTemplate restTemplate = new RestTemplate();
		   map.addAttribute("msg", "employees request by area: " + id);
	       System.out.println(id);
	       if(id == 1) {
	    	   //handle POST update
	    	   String result = restTemplate.postForObject( "http://delivery-service-api.us-e2.cloudhub.io/update/" + orderId, idmap.get(id), String.class);
	    	    System.out.println(result);
	    	   return true;
	       }else if(id == 2 && eta != null) {
	    	   //handle POST eta
	    	   String etaRes = restTemplate.postForObject( "http://delivery-service-api.us-e2.cloudhub.io/update/" + orderId, eta, String.class);
	    	   //handle POST update
	    	   String updateRes = restTemplate.postForObject( "http://delivery-service-api.us-e2.cloudhub.io/update/" + orderId, idmap.get(id), String.class);
	    	   System.out.println(etaRes);
	    	   System.out.println(updateRes);
	    	   return true;
	       }else if(id == 3) {
	    	   //handle post update
	    	   String updateRes = restTemplate.postForObject( "http://delivery-service-api.us-e2.cloudhub.io/update/" + orderId, idmap.get(id), String.class);
	    	   System.out.println(updateRes);
	    	   return true;
	       }
	       
	   }
       
       return false;
   }

}