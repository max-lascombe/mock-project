package userInterface;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class OrderWrapper {
    private List<Order> OrdersList;
    
    

    public OrderWrapper() {
		OrdersList = new ArrayList<Order>();
	}
    
	public OrderWrapper(List<Order> orders) {
		this.OrdersList = orders;
	}

	public List<Order> getOrders() {
        return OrdersList;
    }

    public void setOrders(List<Order> orders) {
        this.OrdersList = orders;
    }

    @Override
    public String toString() {
        return "CarResponse{" +
                "orders=" + OrdersList +
                '}';
    }
}