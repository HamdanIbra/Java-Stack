package com.axsos.ninja;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class NinjaGoldController {
	@RequestMapping("/")
	public String ninja(HttpSession session) {
		if (session.getAttribute("total") == null) {
		      // The attribute does not exist in the session
		      session.setAttribute("total", 0);
		}
		if (session.getAttribute("list") == null) {
			// The attribute does not exist in the session
			ArrayList<Object> mylist = new ArrayList<>();
			session.setAttribute("list", mylist);
		}
		return "index.jsp";
	}
	@RequestMapping("/handle")
	public String handle(
			@RequestParam(value="location") String location,
			HttpSession session
			) {
		Date now = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MMMM d' 'yyyy h:mm a");
	    String formattedDate = formatter.format(now);
		session.setAttribute("location", location);
		if (location.equals("quest")) {
			Random random = new Random();
		    int randomNumber;

		    do {
		      randomNumber = random.nextInt(101) - 50;
		    } while (randomNumber == 0);
		    
		    int total = (int) session.getAttribute("total");
		    total += randomNumber;
		    session.setAttribute("total", total);
		    
		    ArrayList<Object> list = (ArrayList<Object>) session.getAttribute("list");

		    // Modify the ArrayList
		    if (randomNumber > 0) {
		    	list.add(0,"You completed a " + location + "and earned " + randomNumber+" gold. (" + formattedDate +" )");
		    }
		    else{
		    	randomNumber=Math.abs(randomNumber);
		    	list.add(0,"You failed a" + location + " and lost " + randomNumber + " gold.Ouch ( " + formattedDate +" )");
		    }

		    // Update the ArrayList in the session
		    
		    session.setAttribute("list", list);
		    
			
		}
		else if(location.equals("farm")) {
			Random random = new Random();
		    int randomNumber = random.nextInt(11) + 10;
		    int total = (int) session.getAttribute("total");
		    System.out.println(randomNumber);
		    total += randomNumber;
		    System.out.println(total);
		    session.setAttribute("total", total);
		    ArrayList<Object> list = (ArrayList<Object>) session.getAttribute("list");
		    list.add(0,"You entered a" + location + " and earned " + randomNumber+" gold. (" + formattedDate +" )");
		    
		    session.setAttribute("list", list);
		}
		
		else if(location.equals("cave")) {
			Random random = new Random();
		    int randomNumber = random.nextInt(6) + 5;
		    int total = (int) session.getAttribute("total");
		    
		    total += randomNumber;
		    session.setAttribute("total", total);
		    ArrayList<Object> list = (ArrayList<Object>) session.getAttribute("list");
		    list.add(0,"You entered a " + location + " and earned " + randomNumber+" gold. (" + formattedDate +" )");
		    session.setAttribute("list", list);
		}
		
		else if(location.equals("house") ) {
			Random random = new Random();
		    int randomNumber = random.nextInt(3) + 2;
		    int total = (int) session.getAttribute("total");
		    total += randomNumber;
		    session.setAttribute("total", total);
		    ArrayList<Object> list = (ArrayList<Object>) session.getAttribute("list");
		    list.add(0,"You entered a " + location + " and earned " + randomNumber+" gold. (" + formattedDate +" )");
		    session.setAttribute("list", list);
		}
		
		return "redirect:/";
	}


}
