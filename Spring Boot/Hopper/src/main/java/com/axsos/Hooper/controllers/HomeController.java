package com.axsos.Hooper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Ibrahim Hamdan";
        String itemName = "Steel wire";
        double price = 10.2;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "AlA'zab Things Corner Store";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name",name);
        model.addAttribute("itemName",itemName);
        model.addAttribute("price",price);
        model.addAttribute("description",description);
        model.addAttribute("vendor",vendor);
        return "index.jsp";
    }
    //...
    

}
