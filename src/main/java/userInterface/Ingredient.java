package userInterface;

public class Ingredient {
	
	private String name;
	private boolean out;
	
	public Ingredient() {

	}
	
	public Ingredient(String name, boolean out) {
		this.name = name;
		this.out = out;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOut() {
		return out;
	}
	public void setOut(boolean out) {
		this.out = out;
	}

	@Override
	public String toString() {
		return name + " out of stock?: " + out;
	}
	
	

}
