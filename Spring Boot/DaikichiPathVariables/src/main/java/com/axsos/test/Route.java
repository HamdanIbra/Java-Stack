package com.axsos.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class Route {
	@RequestMapping("/travel/{city}")
		public String view(@PathVariable("city") String city) {
			return "Congratulations! you will soon travel to " + city;
	}
	
	@RequestMapping("/lotto/{x}")
	public String view2(@PathVariable("x") int x) {
		if (x%2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
	}
}
