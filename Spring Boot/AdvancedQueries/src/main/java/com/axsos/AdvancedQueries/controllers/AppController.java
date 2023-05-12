package com.axsos.AdvancedQueries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.AdvancedQueries.services.AppService;

@RestController
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
        this.appService= appService;
    }
	
	@GetMapping("/")
    public List<Object[]> show() {
	 
        return appService.getCountries7();
    }
    
    
    
}
