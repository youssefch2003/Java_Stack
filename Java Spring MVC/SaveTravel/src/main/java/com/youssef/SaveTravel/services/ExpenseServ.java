package com.youssef.SaveTravel.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.SaveTravel.models.Expense;
import com.youssef.SaveTravel.repositories.ExpenseRepo;

@Service
public class ExpenseServ {
	// === CRUD ===
	
		@Autowired
		private  ExpenseRepo ExpenseRepo;
		
		// READ ALL
		public List<Expense> getall(){
			return ExpenseRepo.findAll();
		}
		
		// CREATE
		public Expense create(Expense b) {
			return ExpenseRepo.save(b);
		}
		
		// READ ONE
		public Expense findone(Long id) {
			
			Optional<Expense> maybeBook = ExpenseRepo.findById(id);
			if(maybeBook.isPresent()) {
				return maybeBook.get();
			}else {
				return null;
			}
		}
		
		// UPDATE 
		public Expense updateone(Expense b) {
			return ExpenseRepo.save(b);
		}
		
		// DELETE
		public void deleteone(Long id) {
			ExpenseRepo.deleteById(id);
		}
}
