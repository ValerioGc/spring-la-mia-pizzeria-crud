package org.pizzeria.crud.controller;

import java.util.List;
import java.util.Optional;

import org.pizzeria.crud.pojo.Drink;
import org.pizzeria.crud.serv.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	private DrinkService drinkService;

// index
	@GetMapping
	public String index(Model model) {
		
		List<Drink> drinks = drinkService.findAll();
		model.addAttribute("drinks", drinks);
		model.addAttribute("routeName", "drink");
		
		return "index-drinks";
	}
	
// Show
	@GetMapping("/{id}")
	public String getDrink1(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		Drink drink = optDrink.get();
		model.addAttribute("obj", drink);
		model.addAttribute("element", "drink");
		model.addAttribute("routeName", "showDrink");
		
		return "show";
	}
		
		
// Create	
	@GetMapping("/newDrink")
	public String createDrink(Model model) {
		
		Drink drink = new Drink();
		model.addAttribute("drink", drink);
		model.addAttribute("routeName", "newDrink");
		
		return "newDrink";
	}
	
	@PostMapping("/newDrink")
	public String storeDrink(@Valid @ModelAttribute("drink") Drink drink) {
		drinkService.save(drink);
		return "redirect:/drink";
	}
	
// Edit
	@GetMapping("/edit/{id}")
	public String editDrink(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		Drink drink = optDrink.get();
		model.addAttribute("drink", drink);
		model.addAttribute("routeName", "drinkEdit");
		
		return "editDrink";
	}

	@PostMapping("/edit")
	public String updateDrink(@Valid @ModelAttribute("drink") Drink drink) {
		
		drinkService.save(drink);
		
		return "redirect:/drink";
	}
	
// Delete
	@GetMapping("/delete/{id}")
	public String deleteDrink(@PathVariable("id") int id) {
		
		drinkService.deleteDrinkById(id);
		
		return "redirect:/drink";
	}

}
