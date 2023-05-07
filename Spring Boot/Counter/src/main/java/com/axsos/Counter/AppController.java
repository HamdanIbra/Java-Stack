package com.axsos.Counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppController {
@RequestMapping("/")
public String index(HttpSession session) {
	if (session.getAttribute("counter") == null) {
	      // The attribute does not exist in the session
	      session.setAttribute("counter", 0);
	}
	int count=(int)session.getAttribute("counter")+1;
	session.setAttribute("counter",count );
	return "index.jsp";
}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		return "counter.jsp";
	}
}
