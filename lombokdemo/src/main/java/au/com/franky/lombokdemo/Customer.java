package au.com.franky.lombokdemo;

import lombok.Data;

@Data
public class Customer {
	private int id;
	private String name;
	private Address address;
	private String phoneNumber;
}
