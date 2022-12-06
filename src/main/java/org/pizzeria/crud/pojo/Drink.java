package org.pizzeria.crud.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "drink")
public class Drink {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NotNull(message = "Il nome della pizza non deve essere vuoto")
	private String name;
	
	@Column(nullable = true)
	@Lob
	private String description;
	
	@Column
	@Min(value = 1)
	@Max(value = 100)
	@NotNull(message = "Il prezzo deve essere superiore a 0 euro")
	private int price;
	
	public Drink() { }
	public Drink(String name, String description, int price ) {
		setName(name);
		setDescription(description);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + getName()
			+ "\nDescription: " + getDescription()
			+ "\nPrice: " + getPrice();
	}
}
