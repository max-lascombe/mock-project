package userInterface;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuItem {
	   private Boolean remove;
	   private String name;
	   private ArrayList<Ingredient> ingredients;

	   public MenuItem() {
	   }

	   public MenuItem(Boolean remove, String name, ArrayList<Ingredient> ing) {
	      super();
	      this.remove = remove;
	      this.name = name;
	      this.ingredients = ing;
	   }

		@JsonProperty("removed")
	public Boolean getRemove() {
		return remove;
	}

	public void setRemove(Boolean selected) {
		this.remove = selected;
	}

	public String getName() {
		return name;
	}

	public void setName(String clientID) {
		this.name = clientID;
	}

	public String getModifications() {
		String mods = "";
		for(Ingredient i : ingredients) {
	    	  if(i.isOut())
	    		  mods += "No " + i.getName() + ", ";
	      }
			if(mods.length() > 2) {
				mods = mods.substring(0, mods.length()-2);
			}
		return mods;
	}
	
	@Override
	public String toString() {
		return "MenuItem [remove=" + remove + ", itemName=" + name
				+ ", description=" + "]";
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	   
	}