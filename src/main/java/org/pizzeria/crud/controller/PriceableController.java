package org.pizzeria.crud.controller;

import java.util.LinkedList;
import java.util.List;

import org.pizzeria.crud.intf.PriceableInt;
import org.pizzeria.crud.serv.DrinkService;
import org.pizzeria.crud.serv.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller	
@RequestMapping("/priceable")
public class PriceableController {
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private PizzaService pizzaService;


	@GetMapping
	public String getPriceable(Model model) {
	
		List<PriceableInt> elementsPriceables = new LinkedList<>();
		
		// Add elements
		elementsPriceables.addAll(drinkService.findAll());
		elementsPriceables.addAll(pizzaService.findAll());
	
		//Sort
		elementsPriceables.sort((p1, p2) -> p1.getPrice() - p2.getPrice());
	
		
		//Attributes
		model.addAttribute("obj", elementsPriceables);
		model.addAttribute("routeName", "search");
	
		return "SRCtemplates/priceable";
	}
}
