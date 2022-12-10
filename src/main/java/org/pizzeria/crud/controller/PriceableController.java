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
import org.springframework.web.bind.annotation.RequestParam;



@Controller	
@RequestMapping("/priceable")
public class PriceableController {
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private PizzaService pizzaService;


	@GetMapping
	public String getPriceable(Model model, 
					           @RequestParam(name = "q", required = false) 
							   String query) {
	
		List<PriceableInt> elementsPriceables = new LinkedList<>();
		
		elementsPriceables.addAll(drinkService.findAll());
		elementsPriceables.addAll(pizzaService.findAll());
	
		elementsPriceables.sort((p1, p2) -> p1.getPrice() - p2.getPrice());
	
		
	
		model.addAttribute("elementsPriceable", elementsPriceables);
		model.addAttribute("query", query);
		model.addAttribute("routeName", "search");
	
		return "SRCtemplates/priceable";
	}
}
