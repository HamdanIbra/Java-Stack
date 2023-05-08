package com.axsos.LoginAndRegistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.LoginAndRegistration.models.Book;
import com.axsos.LoginAndRegistration.models.LoginUser;
import com.axsos.LoginAndRegistration.models.User;
import com.axsos.LoginAndRegistration.services.UserService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {
	@Autowired
    private UserService userServ;
	
	@GetMapping("/")
    public String index(Model model) {
		
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "main.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "main.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/books";
    }
	
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "main.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }
	
	@GetMapping("/books")
    public String home(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = userServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        List<Book> allbooks=userServ.allBooks();
        model.addAttribute("allbooks", allbooks);
        return "home.jsp";
        }
		else {
			return "redirect:/";
		}
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
	@GetMapping("/books/new")
	public String newBook( @ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/newbook")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
        	
            return "newBook.jsp";
        } else {
            userServ.createBook(book);
            return "redirect:/books/"+book.getId();
        }
    }
	
	@GetMapping("/books/{id}")
    public String viewBook(@PathVariable("id") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Book book1 = userServ.findBook(id);
			model.addAttribute("book1",book1);
			
			
			return "viewBook.jsp";
		}
		else {
			return "redirect:/";
		}
    }
	
	
}
