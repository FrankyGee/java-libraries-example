package au.com.franky.guildpresentation.data;

import java.util.Objects;

public class Item {
	private final int id;
	private final String name;
	private String description;

	public Item(int id, String name) {
		Objects.requireNonNull(name);
		this.id = id;
		this.name = name;
	}

	public Item(int id, String name, String description) {
		Objects.requireNonNull(name);
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return id == item.id &&
				name.equals(item.name) &&
				Objects.equals(description, item.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description);
	}

	public String toString() {
		return "Item(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ")";
	}
}
