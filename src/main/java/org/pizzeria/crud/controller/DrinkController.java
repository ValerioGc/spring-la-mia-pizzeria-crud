package org.pizzeria.crud.controller;

import java.util.List;
import java.util.Optional;

import org.pizzeria.crud.pojo.Drink;
import org.pizzeria.crud.pojo.Pizza;
import org.pizzeria.crud.serv.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("obj", drinks);
		model.addAttribute("routeName", "drink");
		
		return "CRUDtemplates/index";
	}
	
// Show
	@GetMapping("/{id}")
	public String getDrink1(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		Drink drink = optDrink.get();
		model.addAttribute("obj", drink);
		model.addAttribute("element", "drink");
		model.addAttribute("routeName", "showDrink");
		
		return "CRUDtemplates/show";
	}
		
		
// Create	
	@GetMapping("/newDrink")
	public String createDrink(Model model) {
		
		Drink drink = new Drink();
		model.addAttribute("obj", drink);
		model.addAttribute("routeName", "newDrink");
		model.addAttribute("element", "drink");
		model.addAttribute("action", "/drink/newDrink");
		
		return "CRUDtemplates/new";
	}
	
	@PostMapping("/newDrink")
	public String storeDrink(@Valid @ModelAttribute("drink") Drink drink, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/newDrink";
		}
		
		drinkService.save(drink);
		
		return "redirect:/drink";
	}
	
// Edit
	@GetMapping("/edit/{id}")
	public String editDrink(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		Drink drink = optDrink.get();
		model.addAttribute("obj", drink);
		model.addAttribute("routeName", "drinkEdit");
		model.addAttribute("element", "drink");
		model.addAttribute("action", "/drink/edit");
		
		return "CRUDtemplates/edit";
	}

	@PostMapping("/edit")
	public String updateDrink(@Valid @ModelAttribute("drink") Drink drink, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/drink/edit/" + drink.getId();
		}
		
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
