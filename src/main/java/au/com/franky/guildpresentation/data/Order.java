package au.com.franky.guildpresentation.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
	private final List<OrderItem> orderItems = new ArrayList<>();
	private final Customer customer;

	public void add(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
}
