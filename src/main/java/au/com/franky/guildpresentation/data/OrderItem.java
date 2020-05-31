package au.com.franky.guildpresentation.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
	private final Item item;
	private int quantity;
}
