package com.youssef.SaveTravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.youssef.SaveTravel.models.Expense;
import com.youssef.SaveTravel.services.ExpenseServ;

import jakarta.validation.Valid;

@Controller
public class TrqvelController {
	@Autowired
	private ExpenseServ ExpenseServ;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("Expense") Expense Expense,Model model) {
		List<Expense> allTheExpenses = ExpenseServ.getall();
		model.addAttribute("Expenses",allTheExpenses);
		return "index.jsp";
	}
	  @PostMapping("/process")
	    public String create(@Valid @ModelAttribute("Expense") Expense Expense, BindingResult result,Model m) {
	        if (result.hasErrors()) {
	        	List<Expense> allTheBurgers = ExpenseServ.getall();
	    		m.addAttribute("Expenses",allTheBurgers);
	        	return "index.jsp";
	        } else {
	        	ExpenseServ.create(Expense);
	            return "redirect:/";
	        }
	    }
	  
	// Display Route - Edit form
		
		@GetMapping("expenses/edit/{id}")
		public String editPage(@PathVariable("id") Long id, Model model) {
			
			// find that book with provided id
			Expense thisExpense = ExpenseServ.findone(id);
			
			// pass thisBook to the jsp page 
			model.addAttribute("Expense",thisExpense);
			
			return "edit.jsp";
		}
		
		@PutMapping("expenses/edit/{id}")
		public String updateBook(@Valid @ModelAttribute("Expense") Expense Expense, BindingResult result, Model model) {
			if (result.hasErrors()) {
			
				return "edit.jsp";
			} else {
				// if there are no errors update one
				ExpenseServ.updateone(Expense);
				return "redirect:/";
			}
		}
		// Display Route -Get one
		@GetMapping("expenses/{id}")
		public String GetOne(@PathVariable("id") Long id, Model model) {
			
			// find that book with provided id
			Expense thisExpense = ExpenseServ.findone(id);
			
			// pass thisBook to the jsp page 
			model.addAttribute("Expense",thisExpense);
			
			return "showone.jsp";
		}
		

		// DELETE
		
		@DeleteMapping("/destroy/{id}")
		public String delete(@PathVariable("id") Long id) {
			ExpenseServ.deleteone(id);
			return "redirect:/";
		}
}
