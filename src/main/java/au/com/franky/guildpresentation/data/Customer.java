package au.com.franky.guildpresentation.data;

import lombok.Data;

@Data
public class Customer {
	private final int id;
	private final String name;
	private final Address address;
	private final String phoneNumber;
}
