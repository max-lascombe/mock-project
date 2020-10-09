package userInterface;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponse {

    private boolean isAvailable;
    private String orderList;
	
    public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponse(boolean isAvailable, String orderList) {
		this.isAvailable = isAvailable;
		this.orderList = orderList;
	}

	@JsonProperty("available")
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@JsonProperty("orderList")
	public String getOrder() {
		return orderList;
	}

	public void setOrder(String orderList) {
		this.orderList = orderList;
	}

    
    
    // get/set omitted...
}