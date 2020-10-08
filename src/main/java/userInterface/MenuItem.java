package userInterface;

import java.util.ArrayList;

public class MenuItem {
	   private Boolean selected;
	   private String name;
	   private String modifications;
	   private String description;
	   private ArrayList<Ingredient> ingredients;

	   public MenuItem() {
	   }

	   public MenuItem(Boolean selected, String clientID, String modifications, String description, ArrayList<Ingredient> ing) {
	      super();
	      this.selected = selected;
	      this.name = clientID;
	      this.modifications = "";
	      this.description = description;
	      this.ingredients = ing;
	      
	      for(Ingredient i : ing) {
	    	  if(i.isOut())
	    		  this.modifications += "No " + i.getName() + ", ";
	      }
	      this.modifications = this.modifications.substring(0, this.modifications.length()-2);
	   }

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getName() {
		return name;
	}

	public void setName(String clientID) {
		this.name = clientID;
	}

	public String getModifications() {
		return modifications;
	}

	public void setModifications(String modifications) {
		this.modifications = modifications;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MenuItem [selected=" + selected + ", itemName=" + name + ", ipAddress=" + modifications
				+ ", description=" + description + "]";
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	   
	}