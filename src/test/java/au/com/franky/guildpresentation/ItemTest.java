package au.com.franky.guildpresentation;

import au.com.franky.guildpresentation.data.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {
	public static final String DUMMY_DESCRIPTION = "Dummy description";
	public static final String DUMMY_NAME = "Test item";
	private Item item;

	@BeforeEach
	void setUp() {
		item = createTestItem();
	}

	@Test
	void constructorNullArgumentNoDescription() {
		Executable createNewItem = () -> new Item(1, null);
		assertThrows(NullPointerException.class, createNewItem);
	}

	@Test
	void constructorNullArgumentWithDescription() {
		Executable createNewItem = () -> new Item(1, null, DUMMY_DESCRIPTION);
		assertThrows(NullPointerException.class, createNewItem);
	}

	@Test
	void getId() {
		assertEquals(1, item.getId());
	}

	@Test
	void getName() {
		assertEquals(DUMMY_NAME, item.getName());
	}

	@Test
	void getDescription() {
		assertEquals(DUMMY_DESCRIPTION, item.getDescription());
	}

	@Test
	void setDescription() {
		String newDescription = "A different thing";
		item.setDescription(newDescription);
		assertEquals(newDescription, item.getDescription());
	}

	@Test
	void testEquals() {
		Item item2 = createTestItem();
		assertEquals(item, item2);
	}

	@Test
	void testHashCode() {
		Item item2 = createTestItem();
		assertEquals(item.hashCode(), item2.hashCode());
	}

	@Test
	void testToString() {
		System.out.println(item);
		assertEquals(String.format("Item(id=1, name=%s, description=%s)", DUMMY_NAME, DUMMY_DESCRIPTION), item.toString());
	}

	// HELPERS //
	private Item createTestItem() {
		return new Item(1, DUMMY_NAME, DUMMY_DESCRIPTION);
	}
}
