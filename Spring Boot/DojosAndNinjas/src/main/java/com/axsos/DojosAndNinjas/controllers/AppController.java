package com.axsos.DojosAndNinjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.DojosAndNinjas.models.Dojo;
import com.axsos.DojosAndNinjas.models.Ninja;
import com.axsos.DojosAndNinjas.services.AppService;


import jakarta.validation.Valid;

@Controller
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
        this.appService= appService;
    }
	
	@GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
	 
        return "createDojo.jsp";
    }
	
	@PostMapping("/newdojo")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "createDojo.jsp";
        }
        else {
            appService.createDojo(dojo);
            long dojoId=dojo.getId();
            return "redirect:/dojos/"+dojoId;
        }
	}
        
        @GetMapping("/ninjas/new")
        public String newNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
        	List<Dojo> allDojos=appService.allDojos();
       	 model.addAttribute("alldojos",allDojos);
            return "createNinja.jsp";
        }
        
        
        @PostMapping("/newninja")
        public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
                if (result.hasErrors()) {
                	List<Dojo> allDojos=appService.allDojos();
                  	 model.addAttribute("alldojos",allDojos);
                    return "createNinja.jsp";
                }
                else {
                    appService.createNinja(ninja);
                    return "redirect:/ninjas/new";
                }
            }
                
                @GetMapping("/dojos/{id}")
        	    public String viewDojo(@PathVariable("id") Long id,Model model) {
        		 Dojo dojo1 = appService.findDojo(id);
        	     model.addAttribute("dojo",dojo1);
        	        return "viewDojo.jsp";
        	    }
    }
	
	
	
	
	

