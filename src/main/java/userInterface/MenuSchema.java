package userInterface;

import java.util.Dictionary;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuSchema {
	@JsonProperty("name")
	private String name;
	@JsonProperty("ingredients")
	private Dictionary<String, Boolean> ingredients;
	@JsonProperty("priceCents")
	private float priceCents;
	@JsonProperty("removed")
	private Boolean removed;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dictionary<String, Boolean> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Dictionary<String, Boolean> ingredients) {
		this.ingredients = ingredients;
	}
	public float getPriceCents() {
		return priceCents;
	}
	public void setPriceCents(float priceCents) {
		this.priceCents = priceCents;
	}
	public Boolean getRemoved() {
		return removed;
	}
	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}
	
	
	@Override
	public String toString() {
		return "MenuSchema [name=" + name + ", ingredients=" + ingredients + ", priceCents=" + priceCents + ", removed="
				+ removed + "]";
	}
}
