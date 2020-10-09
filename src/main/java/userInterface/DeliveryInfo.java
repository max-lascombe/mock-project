package userInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryInfo {

	private String Address;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public DeliveryInfo(String Address) {
		this.Address = Address;
	}

	public DeliveryInfo() {

	}

}
