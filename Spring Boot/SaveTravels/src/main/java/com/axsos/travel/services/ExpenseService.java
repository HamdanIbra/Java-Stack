package com.axsos.travel.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.axsos.travel.models.Expense;
import com.axsos.travel.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
	
	
	public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a book
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    // retrieves a book
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
	public void deleteExpense(Long id) {
		// TODO Auto-generated method stub
		expenseRepository.deleteById(id);
		
	}
	public Expense updateExpense(Expense b) {
		// TODO Auto-generated method stub
		expenseRepository.save(b);
		return b;

	}
	
	
}
