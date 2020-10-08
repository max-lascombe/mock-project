package userInterface;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class RestaurantController {

   private ArrayList<MenuItem> testMenuItems = new ArrayList<MenuItem>();
   private ArrayList<Ingredient> testIngredients = new ArrayList<Ingredient>();

   public RestaurantController() {
      /* Dummy data */
	   //replace with eventually getting data from database using API
	  testIngredients.add(new Ingredient("Olives", false));
	  testIngredients.add(new Ingredient("Pepperoni", false));
	  testIngredients.add(new Ingredient("Ham", true));
	  testIngredients.add(new Ingredient("Pineapple", true));
	  testIngredients.add(new Ingredient("Onion", false));
	  testIngredients.add(new Ingredient("Mushroom", false));
	  testIngredients.add(new Ingredient("Salami", true));
	  testIngredients.add(new Ingredient("Mango", true));
	  
      testMenuItems.add(new MenuItem(false, "1", "192.168.0.10", "Client A", testIngredients));
      testMenuItems.add(new MenuItem(false, "2", "192.168.0.11", "Client B", testIngredients));
      testMenuItems.add(new MenuItem(false, "3", "192.168.0.12", "Client C", testIngredients));
      testMenuItems.add(new MenuItem(false, "4", "192.168.0.13", "Client D", testIngredients));
      
      System.out.println("Reset");
   }
   
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

      model.addAttribute("wrapper", wrapper);

      return "modmenu";
   }
}