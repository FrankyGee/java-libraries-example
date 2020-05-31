package au.com.franky.lombokdemo;

import lombok.Data;

import java.util.List;

@Data
public class OrderItem {
	private Item item;
	private int quantity;
	private Customer customer;
}
