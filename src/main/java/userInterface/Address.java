package userInterface;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	
	@JsonProperty("address")
	private String address1;
	
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String time;
	private String guestEmails;
	
	// Generating getters and setters
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGuestEmails() {
		return guestEmails;
	}
	public void setGuestEmails(String guestEmails) {
		this.guestEmails = guestEmails;
	}
	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + ", time=" + time + ", guestEmails=" + guestEmails + "]";
	}
	
	
	
}