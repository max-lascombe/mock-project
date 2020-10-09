package userInterface;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuWrapper {

	@JsonProperty("Menu")
	   private ArrayList<MenuItem> itemList;

		@JsonProperty("Menu")
	   public ArrayList<MenuItem> getItemList() {
	      return itemList;
	   }
		@JsonProperty("Menu")
	   public void setItemList(ArrayList<MenuItem> menuItems) {
	      this.itemList = menuItems;
	   }
	}