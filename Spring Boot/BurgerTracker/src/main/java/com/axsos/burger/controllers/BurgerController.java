package com.axsos.burger.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.axsos.burger.models.Burger;
import com.axsos.burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	private final BurgerService burgerService;
	 public BurgerController(BurgerService burgerService){
	     this.burgerService = burgerService;
	 }
	 
	 @GetMapping("/")
	    public String newBurger(@ModelAttribute("burger") Burger burger,Model model) {
		 List<Burger> allburgers=burgerService.allBurgers();
		 model.addAttribute("allburgers",allburgers);
	        return "index.jsp";
	    }
	    @PostMapping("/new")
	    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,Model model) {
	        if (result.hasErrors()) {
	        	List<Burger> allburgers=burgerService.allBurgers();
	   		 	model.addAttribute("allburgers",allburgers);
	            return "index.jsp";
	        } else {
	            burgerService.createBurger(burger);
	            return "redirect:/";
	        }
	    }
	    
	    @GetMapping("/edit/{id}")
	    public String edit(@ModelAttribute("burger") Burger burger,@PathVariable("id") Long id,Model model) {
		     Burger burger1 = burgerService.findBurger(id);
		     model.addAttribute("burger",burger1);
		     return "edit.jsp";
	    }
	    
	    @PutMapping("/handle")
	    public String editing(@Valid @ModelAttribute("burger") Burger burger,BindingResult result,Model model) {
	    	if (result.hasErrors()) {
			     model.addAttribute("burger",burger);
			     return "edit.jsp";
	        } else {
	        	burger=burgerService.updateBurger(burger);
	            return "redirect:/";
	        }
	    }
}
