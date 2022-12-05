package org.pizzeria.crud.controller;

import java.util.List;
import java.util.Optional;

import org.pizzeria.crud.pojo.Pizza;
import org.pizzeria.crud.serv.PizzaService;

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
@RequestMapping("/")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("routeName", "index");
		return "index";
	}
	
	@GetMapping("/home")
	public String goHome(Model model) {
		model.addAttribute("routeName", "home");
		return "home" ;
	}
	
	
	@GetMapping("/pizza/{id}")
	public String editPizza(@PathVariable("id") int id) {
		
		return "pizza" ;
	}
	
	
	
	@GetMapping("/pizza/newPizza")
	public String createPizza(Model model) {
		
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		model.addAttribute("routeName", "new");
		
		return "newPizza";
	}
	
	@PostMapping("/pizza/newPizza")
	public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		model.addAttribute("routeName", "edit");
		
		return "editPizza";
	}
	
	@PostMapping("/pizza/edit")
	public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		pizzaService.deletePizzaById(id);
		
		return "redirect:/";
	}
}