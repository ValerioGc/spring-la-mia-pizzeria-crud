package org.pizzeria.crud;

import org.pizzeria.crud.pojo.Drink;
import org.pizzeria.crud.pojo.Pizza;
import org.pizzeria.crud.serv.DrinkService;
import org.pizzeria.crud.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DrinkService drinkService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("bufala", "lorem pizzum", 15);
		Pizza p2 = new Pizza("boscaiola", "lorem pizzum", 7);
		Pizza p3 = new Pizza("quattro formaggi", "lorem ipsum", 12);
		Pizza p4 = new Pizza("margherita", "lorem pizzum", 6);
		Pizza p5 = new Pizza("capricciosa", "lorem pizzum", 6);
		Pizza p6 = new Pizza("bu", "lorem pizzum", 15);
		Pizza p7 = new Pizza("norcina", "lorem pizzum", 17);
		Pizza p8 = new Pizza("crostino", "lorem ipsum", 12);
		Pizza p9 = new Pizza("margherita con bufala", "lorem pizzum", 16);
		Pizza p10 = new Pizza("diavola", "lorem pizzum", 19);
		Pizza p11 = new Pizza("noci e pere", "lorem ipsum", 12);
		Pizza p12= new Pizza("margherit con bufala", "lorem pizzum", 16);
		Pizza p13 = new Pizza("diavol", "lorem pizzum", 19);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
		pizzaService.save(p6);
		pizzaService.save(p7);
		pizzaService.save(p8);
		pizzaService.save(p9);
		pizzaService.save(p10);
		pizzaService.save(p11);
		pizzaService.save(p12);
		pizzaService.save(p13);
		
		Drink d1 = new Drink("coca cola", "lorem ipsum", 2);
		Drink d2 = new Drink("fanta", "lorem ipsumm", 2);
		Drink d3 = new Drink("pepsi", "lorem ipsumm", 2);
		Drink d4 = new Drink("vino", "lorem ipsumm", 16);
		Drink d5 = new Drink("sprite", "lorem ipsumm", 2);
		Drink d6 = new Drink("peroni", "lorem pizzum", 2);
		Drink d7 = new Drink("nastro azzurro", "lorem ipsum", 3);
		Drink d8 = new Drink("heineken", "lorem ipsum", 3);
		Drink d9 = new Drink("acqua", "lorem ipsum", 1);
		Drink d10 = new Drink("chinotto", "lorem ipsum", 2);


		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		drinkService.save(d4);
		drinkService.save(d5);
		drinkService.save(d6);
		drinkService.save(d7);
		drinkService.save(d8);
		drinkService.save(d9);
		drinkService.save(d10);

	}
}
