package com.axsos.travel.controllers;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.axsos.travel.models.Expense;
import com.axsos.travel.services.ExpenseService;

import jakarta.validation.Valid;
@Controller
public class HomeController {
	private final ExpenseService expenseService;
	public HomeController(ExpenseService expenseService) {
        this.expenseService= expenseService;
    }
	
	@GetMapping("/")
    public String newExpense(@ModelAttribute("expense") Expense expense,Model model) {
	 List<Expense> allexpenses=expenseService.allExpenses();
	 model.addAttribute("allexpenses",allexpenses);
        return "index.jsp";
    }
	
	@PostMapping("/new")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	List<Expense> allexpenses=expenseService.allExpenses();
       	 	model.addAttribute("allexpenses",allexpenses);
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/";
        }
    }
	
	
	 @GetMapping("/edit/{id}")
	    public String edit(@ModelAttribute("expense") Expense expense,@PathVariable("id") Long id,Model model) {
		     Expense expense1 = expenseService.findExpense(id);
		     model.addAttribute("expense",expense1);
		     return "edit.jsp";
	    }
	 
	 @PutMapping("/handle")
	    public String editing(@Valid @ModelAttribute("expense") Expense expense,BindingResult result,Model model) {
	    	if (result.hasErrors()) {
			     model.addAttribute("expense",expense);
			     return "edit.jsp";
	        } else {
	        	expense=expenseService.updateExpense(expense);
	            return "redirect:/";
	        }
	    }
	 
	 @GetMapping("/expenses/{id}")
	    public String viewExpense(@PathVariable("id") Long id,Model model) {
		 Expense expense1 = expenseService.findExpense(id);
	     model.addAttribute("expense",expense1);
	        return "view.jsp";
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        expenseService.deleteExpense(id);
	        return "redirect:/";
	    }
	 
	 
	
}
