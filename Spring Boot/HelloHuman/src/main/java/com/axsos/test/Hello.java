package com.axsos.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@RequestMapping("/")
	public String hello(@RequestParam(value="name",required=false) String x) {
		if (x==null) {
			return "Hello Human";
		}
		else {
			return "Hello: " + x;
		}
        
}
}
