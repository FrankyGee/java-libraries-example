package au.com.franky.guildpresentation.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	private final String line1;
	private String line2;
	private final String suburb;
	private final String state;
	private final String country;
}
