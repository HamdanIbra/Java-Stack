package com.axsos.DisplayDate.controllers;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date currentDate = new Date();
		model.addAttribute("currentDate",currentDate);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalTime currentTime = LocalTime.now();
		model.addAttribute("currentTime",currentTime);
		return "time.jsp";
	}
}
