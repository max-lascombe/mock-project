package userInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Order {
	
	private String Status;
	private String OrderId;
	private DeliveryInfo DeliveryInfo;
	private DeliveryInfo RestaurantInfo;
	private String DeliveryUpdates;
	
	public Order() {

	}
	
	public Order(String status, String orderId, DeliveryInfo deliveryInfo,
			DeliveryInfo restaurantInfo, String deliveryUpdates) {
		Status = status;
		OrderId = orderId;
		DeliveryInfo = deliveryInfo;
		RestaurantInfo = restaurantInfo;
		DeliveryUpdates = deliveryUpdates;
	}

	@JsonProperty("OrderId")
	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String OrderId) {
		this.OrderId = OrderId;
	}

	@JsonProperty("DeliveryInfo")
	public DeliveryInfo getDeliveryInfo() {
		return DeliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfo DeliveryInfo) {
		this.DeliveryInfo = DeliveryInfo;
	}

	@JsonProperty("DeliveryUpdates")
	public String getDeliveryUpdates() {
		return DeliveryUpdates;
	}

	public void setDeliveryUpdates(String DeliveryUpdates) {
		this.DeliveryUpdates = DeliveryUpdates;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	@JsonProperty("RestaurantInfo")
	public DeliveryInfo getRestaurantInfo() {
		return RestaurantInfo;
	}

	public void setRestaurantInfo(DeliveryInfo restaurantInfo) {
		RestaurantInfo = restaurantInfo;
	}

}
