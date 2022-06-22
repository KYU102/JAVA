package com.codingdojo.saveTravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.saveTravels.models.Expense;
import com.codingdojo.saveTravels.services.ExpenseService;

@Controller
public class ViewController {
	
    private final ExpenseService expenseService;
    public ViewController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    
	@RequestMapping("/")
	public String allExpenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allDaExpenses = expenseService.allExpenses();
		
		model.addAttribute("allDaExpenses", allDaExpenses);
		return "allExpenses.jsp";
	}

	@PostMapping("/")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model)
			
	{
		if (result.hasErrors()) {
			// NEED TO 
			List<Expense> allDaExpenses = expenseService.allExpenses();
			model.addAttribute("allDaExpenses", allDaExpenses);
            return "allExpenses.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/";
        }
	   

	}
	
	@GetMapping("/edit/{id}") 
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense thisExpense = expenseService.findExpense(id);
		model.addAttribute("thisExpense", thisExpense);
		return "edit.jsp";
	}

}
