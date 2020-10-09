package userInterface;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
class RestaurantController {

   private ArrayList<MenuItem> testMenuItems = new ArrayList<MenuItem>();
   private ArrayList<Ingredient> testIngredients = new ArrayList<Ingredient>();

   public RestaurantController() {
      /* Dummy data */
	   //replace with eventually getting data from database using API
	   
	  String API = "http://menu.us-e2.cloudhub.io/menu";
 	  String restaurantId = "";
 	  RestTemplate restTemplate = new RestTemplate();
 	  
		
		
	  String response = restTemplate.getForObject(
	  API, String.class);
	  //System.out.println(response);
	  //List<MenuItem> menuitems = response.getItemList();
	  
	  //testMenuItems = (ArrayList<MenuItem>) menuitems;
	  
	  testIngredients.add(new Ingredient("Olives", false));
	  testIngredients.add(new Ingredient("Pepperoni", false));
	  testIngredients.add(new Ingredient("Ham", true));
	  testIngredients.add(new Ingredient("Pineapple", true));
	  testIngredients.add(new Ingredient("Onion", false));
	  testIngredients.add(new Ingredient("Mushroom", false));
	  testIngredients.add(new Ingredient("Salami", true));
	  testIngredients.add(new Ingredient("Mango", true));
	  
      testMenuItems.add(new MenuItem(false, "1", testIngredients));
      testMenuItems.add(new MenuItem(false, "2", testIngredients));
      testMenuItems.add(new MenuItem(false, "3",  testIngredients));
      testMenuItems.add(new MenuItem(false, "4", testIngredients));
		  
		/*
		 * try { parseAndHandleJSON(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
      
      System.out.println("Reset");
   }
   
/*    public void parseAndHandleJSON() throws IOException, ParseException{
	   String API = "http://menu.us-e2.cloudhub.io/menu";
	 	  String restaurantId = "";
	    URL url = new URL(API);
		//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//Set the request to GET or POST as per the requirements
		conn.setRequestMethod("GET");
		//Use the connect method to create the connection bridge
		conn.connect();
		//Get the response status of the Rest API
		int responsecode = conn.getResponseCode();
		System.out.println("Response code is: " +responsecode);
		
		String inline = "";
		
		if(responsecode != 200)
			throw new RuntimeException("HttpResponseCode: " +responsecode);
		else
		{
			//Scanner functionality will read the JSON data from the stream
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext())
			{
				inline+=sc.nextLine();
			}
			//System.out.println("\nJSON Response in String format"); 
			//System.out.println(inline);
			//Close the stream when reading the data has been finished
			sc.close();
		}
		
		JSONParser parse = new JSONParser();
		//Type caste the parsed json data in json object
		JSONObject jobj = (JSONObject)parse.parse(inline);
		//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
		JSONArray menuItems = (JSONArray) jobj.get("Menu");
		
		
		
		for(int i = 0; i < menuItems.size(); i++) {
			JSONObject menuItem = (JSONObject)menuItems.get(i);
			boolean remove = (boolean) menuItem.get("removed");
			String name = (String) menuItem.get("name");
			JSONArray ingsAsArr =  (JSONArray) menuItem.get("ingredients");
			//ArrayList<Ingredient> testIngredients = new ArrayList<Ingredient>(ingsAsArr.);
			testMenuItems.add(new MenuItem(remove, name, testIngredients));
		}
		System.out.println(menuItems.get(0));
   } */
   
   @GetMapping("/vieworders")
	public String getCardPage() {
		return "cards";
	}

   @GetMapping("/modifymenu")
   String index(Model model) {
	  MenuWrapper wrapper = new MenuWrapper();
      wrapper.setItemList(testMenuItems);
      model.addAttribute("wrapper", wrapper);
	  
      return "modmenu";
   }

   //@RequestMapping(value = "/query/submitQuery", method = RequestMethod.POST)
   @PostMapping("/modifymenu")
   public String processQuery(@ModelAttribute MenuWrapper wrapper, Model model) {

      System.out.println(wrapper.getItemList() != null ? wrapper.getItemList().size() : "null list");
      System.out.println("auewhitihauwetihauaewihtu-");
      for(MenuItem e : wrapper.getItemList()) {
    	  //make Mulesoft API call to db to set unavailable ingredients and/or items
    	  System.out.println(e.getIngredients());
      }
      
		/*
		 * String API = ""; String restaurantId = "";
		 * 
		 * RestTemplate restTemplate = new RestTemplate(); MenuWrapper response =
		 * restTemplate.patchForObject(API, wrapper, MenuWrapper.class);
		 */
      
      //Just convert JSON to string and send that to the javascript and then just do the request there

      model.addAttribute("wrapper", wrapper);

      return "modmenu";
   }
}