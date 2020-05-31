package au.com.franky.guildpresentation;

import au.com.franky.guildpresentation.data.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class GuildpresentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuildpresentationApplication.class, args);
	}

	@Bean
	public void run() {
		Item item1 = new Item(1, "Spinning Top", "A top what spins");
		Item item2 = new Item(2, "Laughing clown");

		Address address =
				new Address("1 Main St", null, "Adelaide", "South Australia", "Australia");

//		Address.of("1 Main St", "Adelaide", "South Australia", "Australia");
/*		Address.builder()
				.line1("1 Main St")
				.suburb("Adelaide")
				.state("South Australia")
				.country("Australia")
				.build();*/

		Customer customer = new Customer(1, "Jimbo", address, "08 1234 5678");

		OrderItem orderItem1 = new OrderItem(item1, 3);
		OrderItem orderItem2 = new OrderItem(item2, 1);

		Order order = new Order(customer);
		order.add(orderItem1);
		order.add(orderItem2);

		System.out.println("This is your order: " + order);

		test1();
	}

	public String test1() {
		return test2("Hello");
	}

	public String test2(String firstPart) {
		return firstPart + " World";
	}
}
